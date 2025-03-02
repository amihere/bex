package com.arachnid.bex.order;

import java.math.BigDecimal;

public record OrderRequest(String product, Integer quantity, OrderType type,
                           OrderSide side, BigDecimal price) {}
