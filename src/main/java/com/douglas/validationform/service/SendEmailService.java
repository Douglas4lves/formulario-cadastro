package com.douglas.validationform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendEmailService {
    
    @Autowired
    private JavaMailSender sendEmail;

    public SendEmailService(JavaMailSender sendEmail) {
        this.sendEmail = sendEmail;
    }

    public void toSend(String userEmail, String title, String content){
        log.info("Enviando email para confirmação...");

        var msg = new SimpleMailMessage();

        msg.setTo(userEmail);
        msg.setSubject(title);
        msg.setText(content);
        sendEmail.send(msg);
        log.info("Um email de confirmação de cadastro foi enviado para seu email!");
    }

    public void toSendDeleteUser(String userEmail, String title, String content){
        log.info("Dados sendo deletados...");

        var msg = new SimpleMailMessage();

        msg.setTo(userEmail);
        msg.setSubject(title);
        msg.setText(content);
        sendEmail.send(msg);
        log.info("Dados deletados!");
    }
    

}
