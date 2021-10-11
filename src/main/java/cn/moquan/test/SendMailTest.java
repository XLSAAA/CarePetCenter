package cn.moquan.test;

import cn.moquan.util.EmailUtil;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMailTest {

//
//    @Controllerpublic
//    class SendMailController {
//        @Autowired
//        private JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean
//
//        @RequestMapping("sendMailTest")
//        public Object sendMailTest() {
//            MimeMessage mMessage = javaMailSender.createMimeMessage();//创建邮件对象
//            MimeMessageHelper mMessageHelper;
//            Properties prop = new Properties();
//            String from;
//            try {
//                //从配置文件中拿到发件人邮箱地址
//                prop.load(this.getClass().getResourceAsStream("/email.properties"));
//                from = prop.get("mail.smtp.username") + "";
//                mMessageHelper = new MimeMessageHelper(mMessage, true);
//                mMessageHelper.setFrom(from);//发件人邮箱
//                mMessageHelper.setTo("收件人邮箱号@qq.com");//收件人邮箱
//                mMessageHelper.setSubject("ssm框架测试邮件发送");//邮件的主题
//                mMessageHelper.setText("<p>这是使用spring,springmvc,mybatis整合框架的邮件功能发送的一封邮件,测试</p>", true);//邮件的文本内容，true表示文本以html格式打开
//                File file = new File("C:\\Users\\lcl\\Pictures\\Saved Pictures\\blog.csdn.net_Mr__Viking_article_details_81090046.png");//在邮件中添加一张图片
//                FileSystemResource resource = new FileSystemResource(file);
//                //mMessageHelper.addInline("fengye", resource);//这里指定一个id,在上面引用
//                //mMessageHelper.addAttachment("QQ截图20200721221932.png", resource);//在邮件中添加一个附件
//                javaMailSender.send(mMessage);//发送邮件
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return "发送成功";
//        }
//    }

}
