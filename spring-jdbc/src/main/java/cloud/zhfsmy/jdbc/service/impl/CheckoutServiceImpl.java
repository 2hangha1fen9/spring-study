package cloud.zhfsmy.jdbc.service.impl;

import cloud.zhfsmy.jdbc.service.BookService;
import cloud.zhfsmy.jdbc.service.CheckoutService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("checkoutService")
public class CheckoutServiceImpl implements CheckoutService {
    @Resource
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer id : bookIds) {
            bookService.buyBookForTransaction(id, userId);
        }
    }
}
