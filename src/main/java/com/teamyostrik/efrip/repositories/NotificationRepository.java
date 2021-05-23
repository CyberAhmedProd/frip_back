package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Notification;
import com.teamyostrik.efrip.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
    List<Notification> findAllByUser(User user);
}
