package com.darparisianstroll.mail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailTest {
    @SuppressWarnings("resource")
    public static void main(String args[]) {

	// Spring Bean file you specified in /src/main/resources folder
	String crunchifyConfFile = "mail-bean.xml";
	ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		crunchifyConfFile);

	// @Service("Email") <-- same annotation you specified in
	// EmailAPI.java
	EmailAPI crunchifyEmailAPI = (EmailAPI) context.getBean("Email");
	String toAddr = "mohamed.af@hotmail.fr";
	String fromAddr = "dar.parisianstroll@gmail.com";

	// email subject
	String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";

	// email body
	String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
	crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject,
		body);
    }
}
