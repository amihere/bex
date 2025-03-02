package com.arachnid.bex.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  public Boolean placeOrder(OrderRequest request) { return true; }

  public Boolean status(String id) { return false; }
}
