package cloud.zhfsmy.annotation.dao;


import cloud.zhfsmy.annotation.entity.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookDao {
    /**
     * 根据图书ID获取价格
     *
     * @param bookId 图书ID
     * @return 图书价格
     */
    @Select("select price from book where id = #{bookId}")
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书价格
     *
     * @param bookId 图书ID
     * @param count  扣减数量
     */
    @Update("update book set stock = stock - #{count} where id = #{bookId}")
    void updateStock(Integer bookId, Integer count);

    @Select("select * from book where id = #{bookId}")
    Book getBookById(Integer bookId);
}
