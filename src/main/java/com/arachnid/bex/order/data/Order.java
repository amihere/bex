
package com.arachnid.bex.order.data;

import com.arachnid.bex.order.OrderSide;
import com.arachnid.bex.order.OrderType;
import com.arachnid.bex.query_market.data.Product;
import com.arachnid.bex.registration.data.SecurityUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Order {

  @Id private String id;
  @Column(unique = true) private SecurityUser user;
  private Product product;
  private OrderType type;
  private OrderSide side;
  private Integer quantity;
  private BigDecimal price;
  private LocalDateTime created;

  public Order() {}

  public String getId() { return id; }

  public SecurityUser getUser() { return user; }

  public Product getProduct() { return product; }

  public OrderType getType() { return type; }

  public OrderSide getSide() { return side; }

  public Integer getQuantity() { return quantity; }

  public BigDecimal getPrice() { return price; }

  public LocalDateTime getCreated() { return created; }
}
