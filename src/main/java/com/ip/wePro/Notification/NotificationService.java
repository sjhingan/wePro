package com.ip.wePro.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;

import com.ip.wePro.project.Project;
import com.ip.wePro.project.ProjectSkills;
import com.ip.wePro.userProject.UserProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ip.wePro.User.User;
import com.ip.wePro.User.UserRepository;
import com.ip.wePro.userSkills.UserSkillsService;

/**
 * This service is used to fetch/update/delete notifications
 * @author WePro
 *
 */
@Service
public class NotificationService {
	
	private static final Logger logger = Logger.getLogger("NotificationService");

    @Autowired
    private JavaMailSender sender;
    
    @Autowired
    private UserSkillsService userSkillsService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationRepository notificationRepository; 

    /**
     * Async method to send email notifications to the user matching skills of a user and also keeping the 
     * record in our database to shoe them in app as well
     * @param skills
     * @throws InterruptedException
     */
	@Async
    public void sendNotificationForProject(Project project) throws InterruptedException {
        logger.info("sendNotificationForProject: " + project);
        Set<ProjectSkills> projectSkills = project.getSkills();
        List<Integer> skills = new ArrayList<>();
        for (ProjectSkills s : projectSkills ){
        	skills.add(s.getSkillId());
        }
        if(skills.size()>0){
        	List<User> userList = userSkillsService.getUsersWithSkills(skills);

            for(User user : userList){
            	try {
            		String text = "<html><body background='https://drive.google.com/file/d/1CObOseW5YB5esOvo9Dqw9nZ613Nj-5Z0/view?usp=sharing'><h1>Congratulations!!!</h1></br></br> We got you a new matching project ("+project.getName()+") for your skills. Check details regarding this opportunity by logging in to our website. <body></html>";
    				sendEmail(user.getEmail(),text, "WePro Notification: New Project found for you");
    				logger.info("New Project creation notification sent to email id: "+ user.getEmail());
    				Notification notification = new Notification();
    				notification.setSeen(false);
    				notification.setUserId(user.getId());
    				notification.setDescription("New Project found matching your skills.");
    				notificationRepository.save(notification);
    				logger.info("Added new notification for user email:"+user.getEmail());
    			} catch (Exception e) {
    				e.printStackTrace();
    				logger.log(Level.SEVERE, "Error occured while sending email to user: "+ user.getEmail());;
    			}
            }
        }else{
        	logger.info("No skills found for project with project id: "+ project.getId());
        }
        
    }
	
	@Async
    public void sendNotificationForUserHire(UserProject userProject) throws InterruptedException {
        
        if(userProject != null){
        	logger.info("sendNotificationForUserHire: " + userProject);
            Project project = userProject.getProject();
            Long userId = userProject.getUser_id();
            User user = userRepository.findById(userId.intValue()).get();
        	try {
				logger.info("New Project creation notification sent to email id: "+ user.getEmail());
				Notification notification = new Notification();
				notification.setSeen(false);
				notification.setUserId(user.getId());
				String text = "Congratulations!!! You are hired. Check details regarding your new project named: "+project.getName();
				notification.setDescription(text);
				notificationRepository.save(notification);
				sendEmail(user.getEmail(), text, "WePro Notification: Congratulations!!!");
				logger.info("Added new notification for user email:"+user.getEmail());
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Level.SEVERE, "Error occured while sending email to user: "+ user.getEmail());;
			}
        }else{
        	logger.info("No user project details found.");
        }
        
    }
    
	/**
	 * Method used to send an email to user for new project launched
	 * @param email
	 * @throws Exception
	 */	
    private void sendEmail(String email, String text, String subject) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setTo(email);
        helper.setText(text, true);
        helper.setSubject(subject);
        
        sender.send(message);
    }

    /**
     * Method to pull out all the user notifications based on user id
     * @param uid
     * @return
     */
	public List<Notification> getAllUserNotifications(int uid) {
		// TODO Auto-generated method stub
		return notificationRepository.getAllUserNotifications(uid);
	}

	/**
	 * Method used to mark a notification as read
	 * @param notificationId
	 * @return
	 */
	public List<Notification> markNotificationAsRead(Long notificationId) {
		// TODO Auto-generated method stub
		Notification notification = notificationRepository.findById(notificationId).get();
		notification.setSeen(true);
		notificationRepository.save(notification);
		
		return getAllUserNotifications(notification.getUserId());
	}
	
	/**
	 * Method used to delete a user notification
	 * @param notificationId
	 * @return
	 */
	public List<Notification> deleteNotification(Long notificationId) {
		// TODO Auto-generated method stub
		Notification notification = notificationRepository.findById(notificationId).get();
		notificationRepository.deleteById(notificationId);
		
		return getAllUserNotifications(notification.getUserId());
	}
}
