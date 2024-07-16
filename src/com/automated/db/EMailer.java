package com.automated.db;


import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
public class EMailer{  
    public static void send(final String from,final String password,String to,String sub,String msg){  
          //Get properties object    
          Properties properties = new Properties();    
        
        properties.put("mail.smtp.host","smtp.gmail.com");
  		properties.put("mail.smtp.auth", "true");
  		properties.put("mail.smtp.starttls.enable","true");
  		properties.put("mail.smtp.starttls.required", "true");
  		properties.put("mail.smtp.ssl.trust","smtp.gmail.com");
  		properties.put("mail.smtp.port", "587");
          //get Session   
          Session session = Session.getDefaultInstance(properties,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           
           message.setText(msg);    
           message.setContent(msg,"text/html;charset=UTF-8");
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {
        	  throw new RuntimeException(e);}    
             
    }  
}  
