package cloud.zhfsmy.annotation.service;

import cloud.zhfsmy.annotation.entity.Book;

public interface BookService {
    /**
     * 购买图书
     *
     * @param bookId 图书ID
     * @param userId 用户ID
     */
    void buyBook(Integer bookId, Integer userId);

    /**
     * 购买图书
     *
     * @param bookId 图书ID
     * @param userId 用户ID
     */
    void buyBookForTransaction(Integer bookId, Integer userId);

    void buyBookForTimeoutTransaction(Integer bookId, Integer userId);

    void buyBookForRollbackTransaction(Integer bookId, Integer userId);

    Book getBookInfoById(Integer bookId);
}
