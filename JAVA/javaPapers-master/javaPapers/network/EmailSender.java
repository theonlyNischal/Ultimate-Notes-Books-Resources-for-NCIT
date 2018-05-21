//sending email from java
//add javax.mail and activation jar files
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class EmailSender extends Authenticator {
    public static void main(String args[]) {    
     String from = "abc@gmail.com";
     String pass ="xxxx";
    
     String to = "recipient";
     String host = "smtp.gmail.com";
   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", host);
   properties.put("mail.smtp.user", from);
   properties.put("mail.smtp.password", pass);
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.auth", "true");

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);
   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));
      message.setSubject("testing java mail");
      message.setText("hi there!!!");
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      System.out.println("Message Sent Successfully....");
    }catch (MessagingException ex) { 
        System.out.println(ex);
      }
   }
}
    

