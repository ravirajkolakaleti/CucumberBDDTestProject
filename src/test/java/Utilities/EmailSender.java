package Utilities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void sendReportByEmail() {
        final String username = "rkolakaleti@gmail.com";
        final String password = "Sushen@2003";
        String to = "rkolakaleti@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Automation Test Execution Report");
            message.setText("Please find the attached test report.");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart.attachFile("test-output/ExtentReport.html");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Email Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
