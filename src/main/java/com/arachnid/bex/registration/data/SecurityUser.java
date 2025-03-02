package com.arachnid.bex.registration.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SecurityUser {
  @jakarta.persistence.Id private long id;
  @Column(unique = true) private String username;
  private String token;

  public SecurityUser() {}

  public SecurityUser(long id, String username, String token) {
    this.id = id;
    this.username = username;
    this.token = token;
  }

  public Long getId() { return id; }

  public String getUsername() { return username; }

  public String getToken() { return token; }
}
