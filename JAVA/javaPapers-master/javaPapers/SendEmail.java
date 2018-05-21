
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public int mailSender(String tomail,int confno,String fname)
    {    
    // Sender's email ID needs to be mentioned
     String from = "geevan.josh@gmail.com";
     String pass ="unknown";
    // Recipient's email ID needs to be mentioned.
   String to = tomail;

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

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("Conformation code from nepal Bazar.com");

      // Now set the actual message
      message.setText("Dear "+fname+", your purchase has been accepted and we will deliver you product within 2 days . keep this code "+confno+" to verify yourself while receiving your  product.Thank you");

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      
      transport.close();
      return 1;
      
    }catch (MessagingException mex) { return 0;
      
   }
    return 0;
    }
}
    

