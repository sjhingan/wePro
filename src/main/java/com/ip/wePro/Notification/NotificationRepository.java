package com.ip.wePro.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	@Query("select t from Notification t where t.userId = :userId order by created_date desc")
	List<Notification> getAllUserNotifications(@Param(value = "userId") int userId);


}
