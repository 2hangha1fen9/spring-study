package cloud.zhfsmy.jdbc.service;

public interface CheckoutService {
    void checkout(Integer[] bookIds, Integer userId);
}
