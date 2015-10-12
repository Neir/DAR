package com.darparisianstroll.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("Email")
public class EmailAPI {

    @Autowired
    private MailSender mail; // MailSender interface defines a strategy

    // for sending simple mails

    public void crunchifyReadyToSendEmail(String toAddress, String fromAddress,
	    String subject, String msgBody) {

	SimpleMailMessage cMsg = new SimpleMailMessage();
	cMsg.setFrom(fromAddress);
	cMsg.setTo(toAddress);
	cMsg.setSubject(subject);
	cMsg.setText(msgBody);
	mail.send(cMsg);
    }
}
