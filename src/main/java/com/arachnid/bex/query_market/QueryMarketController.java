package com.arachnid.bex.query_market;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryMarketController {

  private final QueryMarketDataService dataService;

  public QueryMarketController(QueryMarketDataService dataService) {
    this.dataService = dataService;
  }

  @GetMapping("pd")
  public List<String> getAllProductData() {
    return dataService.getProductList();
  }

  @GetMapping("pd/{product}")
  public String getProduct(@RequestParam("product") String product) {
    return dataService.getProduct(product);
  }
}
