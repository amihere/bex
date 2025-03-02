package com.arachnid.bex.order;

import java.math.BigDecimal;

public record OrderExecution(BigDecimal price, short quantity,
                             String timestamp) {}
