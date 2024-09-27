package webdemo.myshop.Service.ServiceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdemo.myshop.Dto.Request.OrderRequest;
import webdemo.myshop.Dto.Response.OrderResponse;
import webdemo.myshop.Entity.Order;
import webdemo.myshop.HandleException.AppException;
import webdemo.myshop.HandleException.ErrorCode;
import webdemo.myshop.Repository.OrderRepository;
import webdemo.myshop.Service.OrderService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String addOrder() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setOrderDate(LocalDateTime.now());
        Order order = modelMapper.map(orderRequest, Order.class);
        orderRepository.save(order);
        return "Add Order Successfully";
    }

    @Override
    public OrderResponse getOrderById(int id) {
        if (!orderRepository.existsById(id)) {
            throw new AppException(ErrorCode.ORDER_NOT_FOUND);
        }
        return modelMapper.map(orderRepository.findById(id).get(), OrderResponse.class);
    }
}
