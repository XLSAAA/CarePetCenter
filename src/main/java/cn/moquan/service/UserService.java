package cn.moquan.service;

import cn.moquan.bean.user.*;
import cn.moquan.dao.UserDao;
import cn.moquan.util.MD5Util;
import cn.moquan.util.TypeTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private static final String DEFAULT_PASSWORD = "e10adc3949ba59abbe56e057f20f883e";

    @Autowired
    UserDao userDao;

    public boolean checkUserInfo(User user) {

        return true;
    }

    public User loginService(LoginInfo loginInfo) {

        User user = userDao.login(loginInfo.getUsername());

        System.out.println(user);

        // 用户名错误
        if (user == null) {
            return new User("账号或密码错误");
        }

        // 密码错误
        if (user.getStatus() == UserStatus.NORMAL && !user.getPassword().equals(MD5Util.encryptMD5(loginInfo.getPassword()))) {
            if (user.getErrorCount() <= 3)
                userDao.updateUserErrorCountById(user.getId(), user.getErrorCount() + 1);
            else
                userDao.updateUserFreezeById(user.getId(), UserStatus.FREEZE);
            return new User("账号或密码错误");
        }

        // 状态检查
        if (user.getStatus() == UserStatus.DISABLE) {
            return new User("账号或密码错误");
        } else if (user.getStatus() == UserStatus.FREEZE) {

            Date freezeTime = null;

            try {
                freezeTime = TypeTranslation.stringToDate(user.getFreezeTime(), "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                System.out.println(" ERROR : 时间格式转换错误 \n PATH : cn.moquan.service.UserService.login()");
                e.printStackTrace();
            }

            if (freezeTime != null) {
                if (!freezeTime.after(new Date())) {
                    userDao.updateUserUnfreezeById(user.getId(), UserStatus.NORMAL);
                    user.setStatus(UserStatus.NORMAL);
                } else {
                    return new User("当前账号被冻结, 如需解冻请联系管理员");
                }
            } else {
                return new User("当前账号异常, 请联系管理员");
            }

        } else if (user.getStatus() == UserStatus.ERROR) {
            return new User("该账号异常, 请联系管理员");
        } else if (user.getStatus() == UserStatus.NORMAL) {
            if (user.getErrorCount() > 3) {
                userDao.updateUserFreezeById(user.getId(), UserStatus.FREEZE);
                return new User("当前账号被冻结, 如需解冻请联系管理员");
            }
        }

        return user;
    }

    public int statusCheck(User user) {
        if (user != null)
            return user.getStatus() == UserStatus.NORMAL ? CheckMessage.NORMAL : CheckMessage.STATUS_EXCEPTION;
        else
            return CheckMessage.NEED_LOGIN;
    }

    public int categoryCheck(User user) {

        if (user.getCategory() != null)
            return user.getCategory().equals(UserCategory.ADMIN) ? CheckMessage.ADMIN : CheckMessage.USER;
        else
            return CheckMessage.NEED_LOGIN;
    }

    public int loginCheck(User user) {

        User userById = null;

        try {
            userById = userDao.getUserById(user.getId());
            if (userById.getUsername().equals(user.getUsername()) && userById.getPassword().equals(user.getPassword()))
                return CheckMessage.NORMAL;
            else
                return CheckMessage.NEED_LOGIN;
        } catch (Exception e) {
            e.printStackTrace();
            return CheckMessage.NEED_LOGIN;
        }
    }

    public boolean insertUser(User user) {

        boolean returnFlag = false;

        user.setPassword(MD5Util.encryptMD5(user.getPassword()));

        try {
            int count = userDao.insertUser(user);
            returnFlag = count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnFlag;
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id) > 0;
    }

    public boolean updateUserById(User user) {
        return userDao.updateUserById(user) > 0;

    }

    public boolean updateDefaultPasswordById(int id) {
        return userDao.updateDefaultPasswordById(id, DEFAULT_PASSWORD) > 0;
    }
}
