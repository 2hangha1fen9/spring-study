import cloud.zhfsmy.jdbc.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TransactionTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testNoTransaction() {
        //没有事务的情况下,如果用户余额不足,会导致余额变为负数,又因为字段设置了无符号类型,所以在扣减余额时会有异常
        //但图书库存已经扣减了
        bookController.buyBook(4, 4);
    }

    @Test
    public void testTransaction() {
        //开启了@Transactional声明式注解
        bookController.buyBookForTransaction(1, 4);
    }

    @Test
    public void testTimeoutTransaction() {
        //事务在执行过程中，有可能因为遇到某些问题，导致程序卡住，从而长时间占用数据库资源。而长时间占用资源，
        //大概率是因为程序运行出现了问题（可能是Java程序或MySQL数据库或网络连接等等）。
        //此时这个很可能出问题的程序应该被回滚，撤销它已做的操作，事务结束，把资源让出来，让其他正常程序可以执行。
        //概括来说就是一句话：超时回滚，释放资源。
        bookController.buyBookForTimeoutTransaction(1, 4);
    }

    @Test
    public void testRollbackTransaction() {
        //声明式事务默认只针对运行时异常回滚，编译时异常不回滚。
        //可以通过@Transactional中相关属性设置回滚策略
        //- rollbackFor属性：需要设置一个Class类型的对象
        //- rollbackForClassName属性：需要设置一个字符串类型的全类名
        //- noRollbackFor属性：需要设置一个Class类型的对象
        //- rollbackFor属性：需要设置一个字符串类型的全类名
        bookController.buyBookForRollbackTransaction(1, 4);
    }

    //- REQUIRED：支持当前事务，如果不存在就新建一个(默认)**【没有就新建，有就加入】**
    //- SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行**【有就加入，没有就不管了】**
    //- MANDATORY：必须运行在一个事务中，如果当前没有事务正在发生，将抛出一个异常**【有就加入，没有就抛异常】**
    //- REQUIRES_NEW：开启一个新的事务，如果一个事务已经存在，则将这个存在的事务挂起**【不管有没有，直接开启一个新事务，开启的新事务和之前的事务不存在嵌套关系，之前事务被挂起】**
    //- NOT_SUPPORTED：以非事务方式运行，如果有事务存在，挂起当前事务**【不支持事务，存在就挂起】**
    //- NEVER：以非事务方式运行，如果有事务存在，抛出异常**【不支持事务，存在就抛异常】**
    //- NESTED：如果当前正有一个事务在进行中，则该方法应当运行在一个嵌套式事务中。被嵌套的事务可以独立于外层事务进行提交或回滚。如果外层事务不存在，行为就像REQUIRED一样。**【有事务的话，就在这个事务里再嵌套一个完全独立的事务，嵌套的事务可以独立的提交和回滚。没有事务就和REQUIRED一样。】**
    @Test
    public void testSpreadTransaction() {
        bookController.checkout(new Integer[]{1, 2}, 2);
    }

    @Test
    public void testReadonlyTransaction() {
        //对一个查询操作来说，如果我们把它设置成只读，就能够明确告诉数据库，这个操作不涉及写操作。这样数据库就能够针对查询操作来进行优化。
        bookController.getBookInfo(1);
    }
}
