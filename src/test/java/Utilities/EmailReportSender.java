package Utilities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class EmailReportSender {
    public static void sendEmailReport() {
        // Sender's email credentials
        final String senderEmail = "your-email@gmail.com";
        final String senderPassword = "your-email-password";
        final String recipientEmail = "recipient-email@example.com";

        // Email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Authenticate sender
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Automation Test Execution Report");

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find the attached test execution report.\n\nRegards,\nAutomation Team");

            // Attach Extent Report
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String reportPath = "target/extent-reports.html";
            File reportFile = new File(reportPath);
            if (reportFile.exists()) {
                attachmentPart.attachFile(reportFile);
            } else {
                System.out.println("Report file not found at: " + reportPath);
                return;
            }

            // Combine parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("Test execution report email sent successfully!");
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
