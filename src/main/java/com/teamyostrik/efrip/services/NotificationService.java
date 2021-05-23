package com.teamyostrik.efrip.services;

import com.teamyostrik.efrip.models.Notification;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getNotificationsByUser(User user){
        return this.notificationRepository.findAllByUser(user);
    }

    public void notifyUser(Notification notification){
        this.notificationRepository.save(notification);
    }

    public void markAsRead(String id){
        Optional<Notification> notification= this.notificationRepository.findById(id);

        notification.ifPresent((notif -> {
            notif.setRead(true);
            this.notificationRepository.save(notif);
        }));
    }

}
