package cloud.zhfsmyScan.service;

import cloud.zhfsmyScan.dao.UserDAO;
import cloud.zhfsmyScan.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public User getUserInfo() {
        return userDAO.getUser();
    }
}
