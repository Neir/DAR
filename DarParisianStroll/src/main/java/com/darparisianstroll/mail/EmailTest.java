package com.darparisianstroll.mail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailTest {

    @SuppressWarnings("resource")
    public static void sendEmail(String toAddr, String subject, String body) {
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		"mail-bean.xml");

	EmailAPI crunchifyEmailAPI = (EmailAPI) context.getBean("emailService");

	crunchifyEmailAPI.SendEmail(toAddr, "dar.parisianstroll@gmail.com",
		subject, body);
    }
}
