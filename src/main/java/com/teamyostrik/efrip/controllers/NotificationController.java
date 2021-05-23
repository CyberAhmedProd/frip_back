package com.teamyostrik.efrip.controllers;

import com.teamyostrik.efrip.models.Notification;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.services.NotificationService;
import com.teamyostrik.efrip.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/notification")
public class NotificationController {

    private final UserService userService;
    private final NotificationService notificationService;

    public NotificationController(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @GetMapping(path="{user_id}")
    public List<Notification> getNotifications(@PathVariable("user_id") String user_id){
        Optional<User> user= this.userService.getUser(user_id);
        return user.map(notificationService::getNotificationsByUser).orElse(null);
    }

    @PutMapping(path="{id}")
    public void markAsRead(@PathVariable("id") String id){
        this.notificationService.markAsRead(id);
    }
}
