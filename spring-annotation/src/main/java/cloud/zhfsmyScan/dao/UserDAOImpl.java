package cloud.zhfsmyScan.dao;

import cloud.zhfsmyScan.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser() {
        return new User("zhang", 18);
    }
}
