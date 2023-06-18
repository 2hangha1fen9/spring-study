package cloud.zhfsmy.dao;

import cloud.zhfsmy.entity.User;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser() {
        User user = new User();
        user.setName("通过DAO获取User");
        user.setAge(19);
        return user;
    }

    @Override
    public void listUser() {
        System.out.println("listUser");
    }
}
