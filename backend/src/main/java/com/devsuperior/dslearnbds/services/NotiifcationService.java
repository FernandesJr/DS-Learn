package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotiifcationService {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> findNotificationByAuthenticatedUser(Pageable pageable, boolean unreadOnly){

        User user = authService.userAuthenticated(); //User autenticado no SpringSecurity
        Page<Notification> page = repository.find(unreadOnly, user , pageable);
        return page.map(n -> new NotificationDTO(n));
    }
}
