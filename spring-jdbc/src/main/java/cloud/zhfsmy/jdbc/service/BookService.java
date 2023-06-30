package cloud.zhfsmy.jdbc.service;

import cloud.zhfsmy.jdbc.entity.Book;

public interface BookService {
    /**
     * 购买图书
     *
     * @param bookId 图书ID
     * @param userId 用户ID
     * @return 操作是否成功true, 失败false
     */
    boolean buyBook(Integer bookId, Integer userId);

    /**
     * 购买图书
     *
     * @param bookId 图书ID
     * @param userId 用户ID
     * @return 操作是否成功true, 失败false
     */
    boolean buyBookForTransaction(Integer bookId, Integer userId);

    boolean buyBookForTimeoutTransaction(Integer bookId, Integer userId);

    boolean buyBookForRollbackTransaction(Integer bookId, Integer userId);

    Book getBookInfoById(Integer bookId);
}
