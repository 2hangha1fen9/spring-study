package cloud.zhfsmy.ssm.service.impl;

import cloud.zhfsmy.ssm.dao.BookDao;
import cloud.zhfsmy.ssm.domain.Book;
import cloud.zhfsmy.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        try {
            bookDao.addBook(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBook(int id) {
        try {
            bookDao.deleteBook(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean modifyBook(Book book) {
        try {
            bookDao.updateBook(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Book getBookById(int id) {
        try {
            return bookDao.getBookById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Book> getBookList() {
        try {
            return bookDao.listBooks();
        } catch (Exception e) {
            return null;
        }
    }
}
