package cloud.zhfsmy.jdbc.dao;

import cloud.zhfsmy.jdbc.entity.Book;

public interface BookDAO {
    /**
     * 根据图书ID获取价格
     *
     * @param bookId 图书ID
     * @return 图书价格
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书价格
     *
     * @param bookId 图书ID
     * @param count  扣减数量
     */
    boolean updateStock(Integer bookId, Integer count);

    Book getBookById(Integer bookId);
}
