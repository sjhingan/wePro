package com.ip.wePro.Notification;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.MimeMessage;

import com.ip.wePro.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ip.wePro.User.User;
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
    private NotificationRepository notificationRepository; 

    /**
     * Async method to send email notifications to the user matching skills of a user and also keeping the 
     * record in our database to shoe them in app as well
     * @param skills
     * @throws InterruptedException
     */
	@Async
    public void sendNotificationForProject(Project project) throws InterruptedException {
        /*logger.info("sendNotificationForProject: " + skills);
        List<User> userList = userSkillsService.getUsersWithSkills(skills);

        for(User user : userList){
        	try {
				sendEmail(user.getEmail());
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
        }*/
    }
    
	/**
	 * Method used to send an email to user for new project launched
	 * @param email
	 * @throws Exception
	 */	
    private void sendEmail(String email) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setTo(email);
        helper.setText("<html><body>New Project Added...<body></html>", true);
        helper.setSubject("WePro Notification: New Project Found");
        
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
