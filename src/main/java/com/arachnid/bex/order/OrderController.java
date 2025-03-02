package com.arachnid.bex.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  private static Logger LOG = LoggerFactory.getLogger(OrderController.class);

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("order/{id}")
  public Boolean status(@RequestParam("id") String id) {
    return orderService.status(id);
  }

  @PostMapping("order")
  public Boolean placeOrder(OrderRequest request) {
    LOG.warn("order in " + request.toString());
    return orderService.placeOrder(request);
  }
}
