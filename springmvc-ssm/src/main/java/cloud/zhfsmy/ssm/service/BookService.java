package cloud.zhfsmy.ssm.service;

import cloud.zhfsmy.ssm.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 新增图书
     *
     * @param book 图书实体
     * @return 是否操作成功
     */
    boolean saveBook(Book book);

    /**
     * 删除图书
     *
     * @param id 图书id
     * @return 是否操作成功
     */
    boolean deleteBook(int id);

    /**
     * 修改图书
     *
     * @param book 图书实体
     * @return 是否操作成功
     */
    boolean modifyBook(Book book);

    /**
     * 根据Id获取图书
     *
     * @param id 图书ID
     * @return 图书实体
     */
    Book getBookById(int id);

    /**
     * 获取图书列表
     *
     * @return 图书列表
     */
    List<Book> getBookList();
}
