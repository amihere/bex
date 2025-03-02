package com.arachnid.bex.order;

import com.arachnid.bex.config.GeneralException;
import com.arachnid.bex.order.data.Order;
import com.arachnid.bex.order.data.OrderRepository;
import com.arachnid.bex.query_market.data.Product;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Boolean placeOrder(OrderRequest request) {
    validateOrder(request);
    return placeOrderHelper(request);
  }

  private void validateOrder(OrderRequest request) {
    if (Objects.isNull(request))
      throw new GeneralException("bad object");
  }

  @Transactional
  public Boolean placeOrderHelper(OrderRequest request) {

    orderRepository.save(new Order(
        UUID.randomUUID().toString(), null, new Product(request.product()),
        request.type(), request.side(), request.quantity(), request.price(),
        LocalDateTime.now()));

    return true;
  }

  public OrderStatusResponse status(String id) {
    // var order = orderRepository.findById(id).orElseThrow(
    //     () -> new GeneralException("No order found"));

    return new OrderStatusResponse(100d, List.of(), 20, id, OrderType.LIMIT,
                                   90.23d, "TSLA", 20, OrderSide.BUY);
  }
}
