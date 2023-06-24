package cloud.zhfsmy.jdbc.dao;

import cloud.zhfsmy.jdbc.entity.User;

public interface UserDAO {
    /**
     * 更新用户余额
     *
     * @param userId 用户ID
     * @param price  扣减金额
     * @return 操作成功true, 失败false
     */
    boolean updateBalance(Integer userId, Integer price);

    User getUserById(Integer userId);
}
