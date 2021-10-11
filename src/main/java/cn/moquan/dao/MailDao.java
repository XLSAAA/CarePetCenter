package cn.moquan.dao;

import cn.moquan.bean.mail.Mail;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDao {

    void createMail(Mail mail);

    List<Mail> sendMail();

    boolean clear();

    void updateStatus(@Param("mailIdList") List<Integer> mailId, @Param("status") int status);

    List<Mail> getErrorMail();
}
