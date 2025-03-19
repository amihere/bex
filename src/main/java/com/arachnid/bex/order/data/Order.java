
package com.arachnid.bex.order.data;

import com.arachnid.bex.order.OrderSide;
import com.arachnid.bex.order.OrderType;
import com.arachnid.bex.query_market.data.Product;
import com.arachnid.bex.registration.data.SecurityUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Order {

  @Id private String id;
  @OneToOne(optional = false) private SecurityUser user;
  @OneToOne(optional = false) private Product product;
  private OrderType type;
  private OrderSide side;
  private Integer quantity;
  private BigDecimal price;
  private LocalDateTime created;

  public Order() {}

  public Order(String id, SecurityUser user, Product product, OrderType type,
               OrderSide side, Integer quantity, BigDecimal price) {
    this.id = id;
    this.user = user;
    this.product = product;
    this.type = type;
    this.side = side;
    this.quantity = quantity;
    this.price = price;
  }

  public String getId() { return id; }

  public SecurityUser getUser() { return user; }

  public Product getProduct() { return product; }

  public OrderType getType() { return type; }

  public OrderSide getSide() { return side; }

  public Integer getQuantity() { return quantity; }

  public BigDecimal getPrice() { return price; }

  public LocalDateTime getCreated() { return created; }
}
