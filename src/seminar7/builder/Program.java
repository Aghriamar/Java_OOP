package seminar7.builder;

public class Program {


    public static void main(String[] args) {
        MailMessage mailMessage = new MailMessage();
        mailMessage.setTo("to@gmail.com");
        mailMessage.setFrom("from@gmail.com");
        mailMessage.setSubject("Hello, My Friend!");

        MailMessage mailMessage1 = new MailMessageBuilder()
                .setBody("message body")
                .setFrom("from@gmail.com")
                .setSubject("Message subject")
                .build();


    }

}
