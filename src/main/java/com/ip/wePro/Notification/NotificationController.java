package com.ip.wePro.Notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.wePro.User.User;
import com.ip.wePro.skills.Skills;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	/**
	 * To Test send email notification part through rest api
	 */
	/*@GetMapping("/get")
    public void getAllProjects() throws InterruptedException{
		
		Skills skills = new Skills();
		skills.setId(1);
		skills.setName("JAVA");
		List<Integer> list = new ArrayList<>();
		list.add(1);
        notificationService.sendNotificationForProject(list);
    }*/
	
	/**
	 * Method to pull out all the user notifications based on user id
	 * @param uid
	 * @return
	 */
	@GetMapping("/get/{uid}")
    public List<Notification> getAllUserNotifications(@PathVariable int uid){
		
        return notificationService.getAllUserNotifications(uid);
    }
	
	/**
	 * Method used to mark a notification as read
	 * @param notificationId
	 * @return
	 */
	@GetMapping("/markRead/{notificationId}")
    public List<Notification> markNotificationAsRead(@PathVariable Long notificationId){
		
        return notificationService.markNotificationAsRead(notificationId);
    }
	
	/**
	 * Method used to delete a user notification
	 * @param notificationId
	 * @return
	 */
	@GetMapping("/delete/{notificationId}")
    public List<Notification> deleteNotification(@PathVariable Long notificationId){
		
        return notificationService.deleteNotification(notificationId);
    }


}
