package com.devsuperior.dslearnbds.resources;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotiifcationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    @Autowired
    private NotiifcationService service;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> findNotificationsByUserAuthenticated(Pageable pageable){
        Page<NotificationDTO> page = service.findNotificationByAuthenticatedUser(pageable);
        return ResponseEntity.ok().body(page);
    }
}
