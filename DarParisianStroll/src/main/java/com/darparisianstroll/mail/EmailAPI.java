package com.darparisianstroll.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * API Mail, classe contenant la methode permettant d'envoyer un mail
 *
 */
@Service("emailService")
public class EmailAPI {

    @Autowired
    private MailSender mail; // MailSender interface defines a strategy

    // for sending simple mails

    /**
     * 
     * @param toAddress
     *            adresse du destinataire
     * @param fromAddress
     *            adresse de l'expediteur
     * @param subject
     *            sujet du mail
     * @param msgBody
     *            corp du mail
     */
    public void SendEmail(String toAddress, String fromAddress, String subject,
	    String msgBody) {

	SimpleMailMessage cMsg = new SimpleMailMessage();
	cMsg.setFrom(fromAddress);
	cMsg.setTo(toAddress);
	cMsg.setSubject(subject);
	cMsg.setText(msgBody);
	mail.send(cMsg);
    }
}
