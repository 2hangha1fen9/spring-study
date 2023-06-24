package cloud.zhfsmy.annotation.dao;


import cloud.zhfsmy.annotation.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {
    /**
     * 更新用户余额
     *
     * @param userId 用户ID
     * @param price  扣减金额
     */
    @Update("update user set balance = balance - #{balance} where id = #{userId}")
    void updateBalance(Integer userId, Integer price);

    @Select("select * from user where id = #{userId}")
    User getUserById(Integer userId);
}
