package company.registrationandlogin_realtimeproject.service.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Async
//TODO: learn about this annotation
public class EmailService implements EmailSender{
    private JavaMailSender mailSender;
    private final static Logger LOGGER= LoggerFactory.getLogger(EmailService.class);//TODO: learn about slf4j
    @Override
    public void send(String to, String email) {
try{
    MimeMessage message=mailSender.createMimeMessage();
    MimeMessageHelper helper=new MimeMessageHelper(message,"utf-8");
    helper.setText(email,true);
    helper.setTo(to);
    helper.setSubject("Confirm your email");
    helper.setFrom("shukhratjonRayimjonov@gmail.com");
    mailSender.send(message);
}catch(MessagingException e){
    LOGGER.error("failed to send email",e);
    throw new IllegalStateException("failed to send email");
}
    }
}
