package cloud.zhfsmy.ssm.dao;

import cloud.zhfsmy.ssm.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    /**
     * 新增图书
     *
     * @param book 图书实体
     */
    @Insert("insert into book (name,price,stock) values(#{name},#{price},#{stock})")
    void addBook(Book book);

    /**
     * 删除图书
     *
     * @param id 图书ID
     */
    @Delete("delete from book where id = #{id}")
    void deleteBook(int id);

    /**
     * 更新图书
     *
     * @param book 图书实体
     */
    @Update("update book set name = #{name},price = #{price},stock = #{stock} where id = #{id}")
    void updateBook(Book book);

    /**
     * 根据ID获取图书实体
     *
     * @param id
     * @return 图书实体
     */
    @Select("select * from book where id = #{id}")
    Book getBookById(int id);

    /**
     * 列出所有图书
     *
     * @return 图书列表
     */
    @Select("select * from book")
    List<Book> listBooks();
}
