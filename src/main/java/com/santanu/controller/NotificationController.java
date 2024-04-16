package com.santanu.controller;

import com.santanu.Exception.UserException;
import com.santanu.model.Notification;
import com.santanu.model.User;
import com.santanu.service.NotificationService;
import com.santanu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService notificationSerivce;
    @Autowired
    private UserService userService;

    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> findUsersNotification(
            @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Notification> notifications = notificationSerivce.findUsersNotification(user.getId());
        return new ResponseEntity<List<Notification>>(notifications, HttpStatus.ACCEPTED);
    }

}

