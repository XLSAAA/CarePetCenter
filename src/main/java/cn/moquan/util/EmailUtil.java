package cn.moquan.util;

import cn.moquan.bean.mail.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender javaMailSender;
    private static final Properties prop;
    static{
        prop = new Properties();
        try {
            //从配置文件中拿到发件人邮箱地址
            prop.load(EmailUtil.class.getResourceAsStream("/email.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sendEmail(Mail mail){

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        String form = prop.getProperty("mail.smtp.username")+"";

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            // 发件人
            mimeMessageHelper.setFrom(form);
            // 收件人邮箱
            mimeMessageHelper.setTo(mail.getMasterEmail());
            // 邮件的主题
            mimeMessageHelper.setSubject("宠物护理中心邮件通知~");
            //邮件的文本内容，true表示文本以html格式打开
            mimeMessageHelper.setText("<p>尊敬的客户, 您的小主 " + mail.getPetName() + " 在护理中心接受 "+ mail.getItemName() + " 服务后已经过去很长时间喽。 </p><br />" +
                                           "<p>为了保障小主的健康, 您可以根据情况再次到店为小主进行日常护理。", true);
            javaMailSender.send(mimeMailMessage);

        } catch (MessagingException e) {
            System.out.println("Error : ? \n Path : cn.moquan.util.EmailUtil.sendEmail()");
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
}
