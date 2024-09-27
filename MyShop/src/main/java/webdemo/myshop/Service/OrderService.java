package webdemo.myshop.Service;

import webdemo.myshop.Dto.Request.OrderRequest;
import webdemo.myshop.Dto.Response.OrderResponse;

public interface OrderService {
    public String addOrder();
    public OrderResponse getOrderById(int id);
}
