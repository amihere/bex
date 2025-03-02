package com.arachnid.bex.query_market;

import com.arachnid.bex.query_market.data.Product;
import com.arachnid.bex.query_market.data.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class QueryMarketDataService {

  private ProductRepository productRepository;

  public QueryMarketDataService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  List<String> getProductList() {
    return productRepository.findAll().stream().map(Product::getName).toList();
  }

  public String getProduct(String product) {
    System.out.println("get product");
    return "";
  }
}
