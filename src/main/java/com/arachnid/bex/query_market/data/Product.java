package com.arachnid.bex.query_market.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
  @Column(unique = true) private String name;
  private LocalDateTime created;

  public Product() {}
  public Product(String name) {
    this.id = null;
    this.name = name;
  }
  public Long getId() { return id; }
  public String getName() { return name; }
  public LocalDateTime getCreated() { return created; }
}
