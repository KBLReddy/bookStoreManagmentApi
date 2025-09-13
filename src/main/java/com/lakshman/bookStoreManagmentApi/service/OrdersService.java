package com.lakshman.bookStoreManagmentApi.service;

import com.lakshman.bookStoreManagmentApi.dto.CreateOrderRequestDto;
import com.lakshman.bookStoreManagmentApi.dto.OrderItemRequestDto;
import com.lakshman.bookStoreManagmentApi.entity.Book;
import com.lakshman.bookStoreManagmentApi.entity.Customer;
import com.lakshman.bookStoreManagmentApi.entity.Order;
import com.lakshman.bookStoreManagmentApi.entity.OrderItems;
import com.lakshman.bookStoreManagmentApi.repository.BooksRepository;
import com.lakshman.bookStoreManagmentApi.repository.CustomerRepository;
import com.lakshman.bookStoreManagmentApi.repository.OrderItemsRepository;
import com.lakshman.bookStoreManagmentApi.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private  CustomerRepository customerRepository;
    @Autowired
    private BooksRepository bookRepository;
    @Autowired
    private  OrdersRepository orderRepository;
    @Autowired
    private OrderItemsRepository orderItemRepository;
    @Transactional
    public Order createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Customer customer = customerRepository.getReferenceById(createOrderRequestDto.getCustomerId());
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
        List<OrderItems> orderItems = new ArrayList<>();
        for (OrderItemRequestDto itemRequest : createOrderRequestDto.getItems()) {
            Book book = bookRepository.findById(itemRequest.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            OrderItems orderItem = new OrderItems();
            orderItem.setOrder(order);
            orderItem.setBookId(book);
            orderItem.setQuantity(itemRequest.getQuantity());

            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);
        return order;
    }

}
