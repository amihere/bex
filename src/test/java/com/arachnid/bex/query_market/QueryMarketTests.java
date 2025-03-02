package com.arachnid.bex.query_market;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.arachnid.bex.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "/data.sql",
     executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class QueryMarketTests extends Config {

  @Autowired private QueryMarketDataService dataService;

  @Test
  public void testQueryMarket() {
    var list = dataService.getProductList();
    assertFalse(list.isEmpty());
  }
}
