import cloud.zhfsmy.ssm.config.SpringConfig;
import cloud.zhfsmy.ssm.domain.Book;
import cloud.zhfsmy.ssm.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void addBookTest() {
        Book book = new Book();
        book.setName("Java核心技术卷(一)");
        book.setPrice(120);
        book.setStock(10);
        boolean b = bookService.saveBook(book);
        Assert.assertTrue(b);
    }

    @Test
    public void deleteBookTest() {
        boolean b = bookService.deleteBook(1);
        Assert.assertTrue(b);
    }

    @Test
    public void updateBookTest() {
        Book book = bookService.getBookById(1);
        book.setName("Java核心技术卷(二)");
        boolean b = bookService.modifyBook(book);
        Assert.assertTrue(b);
    }

    @Test
    public void getBookByIdTest() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
        Assert.assertNotNull(book);
    }

    @Test
    public void getBookList() {
        List<Book> bookList = bookService.getBookList();
        System.out.println(bookList);
        Assert.assertNotNull(bookList);
    }
}
