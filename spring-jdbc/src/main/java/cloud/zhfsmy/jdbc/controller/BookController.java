package cloud.zhfsmy.jdbc.controller;

import cloud.zhfsmy.jdbc.service.BookService;
import cloud.zhfsmy.jdbc.service.CheckoutService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Resource
    private BookService bookService;
    @Resource
    private CheckoutService checkoutService;

    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }

    public void buyBookForTransaction(Integer bookId, Integer userId) {
        bookService.buyBookForTransaction(bookId, userId);
    }

    public void buyBookForTimeoutTransaction(Integer bookId, Integer userId) {
        bookService.buyBookForTimeoutTransaction(bookId, userId);
    }

    public void buyBookForRollbackTransaction(Integer bookId, Integer userId) {
        bookService.buyBookForRollbackTransaction(bookId, userId);
    }

    public void checkout(Integer[] bookIds, Integer userId) {
        checkoutService.checkout(bookIds, userId);
    }

    public void getBookInfo(Integer bookId) {
        System.out.println(bookService.getBookInfoById(bookId));
    }
}
