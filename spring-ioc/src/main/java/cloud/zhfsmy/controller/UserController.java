package cloud.zhfsmy.controller;

import cloud.zhfsmy.entity.User;
import cloud.zhfsmy.service.UserService;

public class UserController {
    private UserService userService;
    private User user12;

    public User getUser12() {
        return user12;
    }

    public void setUser12(User user12) {
        this.user12 = user12;
    }

    public UserService getUserService() {
        return userService;
    }

    //通过类型setter自动注入
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return userService.getUserInfo();
    }

    public void getCurrentUser() {
        System.out.println(user12);
    }
}
