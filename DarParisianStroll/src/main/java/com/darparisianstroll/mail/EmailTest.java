package com.darparisianstroll.mail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe contenant une methode appelant l'API mail permettant d'envoyer un mail
 *
 */
public class EmailTest {

    /**
     * Methode permettant d'envoyer un mail
     * 
     * @param toAddr
     *            adresse du destinataire
     * @param subject
     *            sujet du mail
     * @param body
     *            corp du mail
     */
    @SuppressWarnings("resource")
    public static void sendEmail(String toAddr, String subject, String body) {
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		"mail-bean.xml");

	EmailAPI crunchifyEmailAPI = (EmailAPI) context.getBean("emailService");

	crunchifyEmailAPI.SendEmail(toAddr, "dar.parisianstroll@gmail.com",
		subject, body);
    }
}
