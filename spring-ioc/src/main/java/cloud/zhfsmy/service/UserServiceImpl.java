package cloud.zhfsmy.service;

import cloud.zhfsmy.dao.UserDAO;
import cloud.zhfsmy.entity.User;

public class UserServiceImpl implements UserService {
    private UserDAO dao;

    public UserServiceImpl() {
    }

    public UserDAO getDao() {
        return dao;
    }

    //通过类型setter自动注入
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public User getUserInfo() {
        return dao.getUser();
    }
}
