package com.arachnid.bex.order;

import java.util.List;

public record OrderStatusResponse(double cumulativePrice,
                                  List<OrderExecution> executions,
                                  int cumulatitiveQuantity, String orderID,
                                  OrderType orderType, double price,
                                  String product, int quantity,
                                  OrderSide side) {}
