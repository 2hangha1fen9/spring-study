package cloud.zhfsmyScan.controller;

import cloud.zhfsmyScan.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    public void printUser() {
        System.out.println(userService.getUserInfo());
    }
}
