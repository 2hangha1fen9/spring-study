package cloud.zhfsmy.jdbc.service.impl;

import cloud.zhfsmy.jdbc.dao.BookDAO;
import cloud.zhfsmy.jdbc.dao.UserDAO;
import cloud.zhfsmy.jdbc.entity.Book;
import cloud.zhfsmy.jdbc.entity.User;
import cloud.zhfsmy.jdbc.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDAO bookDao;
    @Resource
    private UserDAO userDao;


    @Override
    public boolean buyBook(Integer bookId, Integer userId) {
        Book book = bookDao.getBookById(bookId);
        User user = userDao.getUserById(userId);
        Integer bookPrice = bookDao.getPriceByBookId(bookId);
        boolean bookUpdate = bookDao.updateStock(bookId, 1);
        boolean userUpdate = userDao.updateBalance(userId, bookPrice);
        user.setBalance(user.getBalance() - book.getPrice());
        System.out.printf("用户: %s 购买了: %s 价格: %s 余额: %s \n", user.getName(), book.getName(), book.getPrice(), user.getBalance());
        return bookUpdate && userUpdate;
    }

    //开启事务
    @Transactional(propagation = Propagation.REQUIRED)
    //默认情况，表示如果当前线程上有已经开启的事务可用，那么就在这个事务中运行。
    // 经过观察，购买图书的方法buyBook()在checkout()中被调用，checkout()上有事务注解，
    // 因此在此事务中执行。所购买的两本图书的价格为80和50，而用户的余额为100，
    // 因此在购买第二本图书时余额不足失败，导致整个checkout()回滚，即只要有一本书买不了，就都买不了
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    // 表示不管当前线程上是否有已经开启的事务，都要开启新事务。同样的场景，
    // 每次购买图书都是在buyBook()的事务中执行，因此第一本图书购买成功，
    // 事务结束，第二本图书购买失败，只在第二次的buyBook()中回滚，购买第一本图书不受影响，即能买几本就买几本。
    @Override
    public boolean buyBookForTransaction(Integer bookId, Integer userId) {
        Book book = bookDao.getBookById(bookId);
        User user = userDao.getUserById(userId);
        Integer bookPrice = bookDao.getPriceByBookId(bookId);
        boolean bookUpdate = bookDao.updateStock(bookId, 1);
        boolean userUpdate = userDao.updateBalance(userId, bookPrice);
        user.setBalance(user.getBalance() - book.getPrice());
        System.out.printf("用户: %s 购买了: %s 价格: %s 余额: %s \n", user.getName(), book.getName(), book.getPrice(), user.getBalance());
        return bookUpdate && userUpdate;
    }

    //超时时间单位秒
    //事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间占用资源，
    //大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。
    //此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。
    //概括来说就是一句话：超时回滚，释放资源。
    @Transactional(timeout = 3)
    @Override
    public boolean buyBookForTimeoutTransaction(Integer bookId, Integer userId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book = bookDao.getBookById(bookId);
        User user = userDao.getUserById(userId);
        Integer bookPrice = bookDao.getPriceByBookId(bookId);
        boolean bookUpdate = bookDao.updateStock(bookId, 1);
        boolean userUpdate = userDao.updateBalance(userId, bookPrice);
        user.setBalance(user.getBalance() - book.getPrice());
        System.out.printf("用户: %s 购买了: %s 价格: %s 余额: %s \n", user.getName(), book.getName(), book.getPrice(), user.getBalance());
        return bookUpdate && userUpdate;
    }

    //声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
    //可以通过@Transactional中相关属性设置回滚策略
    //- rollbackFor属性：需要设置一个Class类型的对象
    //- rollbackForClassName属性：需要设置一个字符串类型的全类名
    //- noRollbackFor属性：需要设置一个Class类型的对象
    //- rollbackFor属性：需要设置一个字符串类型的全类名
    @Transactional(noRollbackFor = ArithmeticException.class)
    @Override
    public boolean buyBookForRollbackTransaction(Integer bookId, Integer userId) {
        Book book = bookDao.getBookById(bookId);
        User user = userDao.getUserById(userId);
        Integer bookPrice = bookDao.getPriceByBookId(bookId);
        boolean bookUpdate = bookDao.updateStock(bookId, 1);
        boolean userUpdate = userDao.updateBalance(userId, bookPrice);
        user.setBalance(user.getBalance() - book.getPrice());
        System.out.printf("用户: %s 购买了: %s 价格: %s 余额: %s \n", user.getName(), book.getName(), book.getPrice(), user.getBalance());
        int e = 1 / 0;
        return bookUpdate && userUpdate;
    }

    //@Transactional(readOnly = true)
    //对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。
    @Transactional(readOnly = true)
    public Book getBookInfoById(Integer bookId) {
        return bookDao.getBookById(bookId);
    }
}
