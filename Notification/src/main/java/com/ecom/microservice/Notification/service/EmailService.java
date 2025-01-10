package com.ecom.microservice.Notification.service;


import com.ecom.microservice.Notification.entity.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}