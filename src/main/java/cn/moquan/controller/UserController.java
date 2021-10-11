package cn.moquan.controller;

import cn.moquan.bean.user.LoginInfo;
import cn.moquan.bean.user.User;
import cn.moquan.service.UserService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody LoginInfo loginInfo) {
//    public User login(@RequestBody String username, @RequestBody String password) {
//        System.out.println(username);
//        System.out.println(password);
        System.out.println( loginInfo);
        System.out.println(" to this");

        return userService.loginService(loginInfo);
//        return new User("ok");
    }


    @RequestMapping("/statusCheck")
    @ResponseBody
    public int statusCheck(@RequestBody User user) {

        return userService.statusCheck(user);
    }

    @RequestMapping("/categoryCheck")
    @ResponseBody
    public int categoryCheck(@RequestBody User user) {

        return userService.categoryCheck(user);
    }

    @RequestMapping("/loginCheck")
    @ResponseBody
    public int loginCheck(@RequestBody(required = false) User user) {

        return userService.loginCheck(user);
    }

    // CRUD

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String insertUser(@RequestBody User user) {

        if (userService.insertUser(user)) {
            return SuccessMessage.INSERT_OK;
        } else {
            return SuccessMessage.INSERT_FILED;
        }

    }

    @RequestMapping(value = "/users")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {

        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {

        if (userService.deleteUserById(id)) {
            return SuccessMessage.DELETE_OK;
        } else {
            return SuccessMessage.DELETE_FILED;
        }

    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        if (userService.updateUserById(user)) {
            return SuccessMessage.UPDATE_OK;
        } else {
            return SuccessMessage.UPDATE_FILED;
        }

    }

    @ResponseBody
    @RequestMapping("/reset/{id}")
    public String useDefaultPasswordById(@PathVariable("id") int id) {

        if (userService.updateDefaultPasswordById(id)) {
            return SuccessMessage.UPDATE_OK;
        } else {
            return SuccessMessage.UPDATE_FILED;
        }

    }

}
