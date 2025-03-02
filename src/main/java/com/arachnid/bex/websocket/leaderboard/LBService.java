package com.arachnid.bex.websocket.leaderboard;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LBService {
  private ArrayList<String> stocks;

  public LBService() { this.stocks = new ArrayList<>(20); }

  public List<LBResponse> getLeaderBoard(long millis) throws Exception {
    long[] stocks = new long[] {800, 320, 1, -1242, 0, 903, 0, 10};

    return List.of(new LBResponse("lewis", stocks, 100, 1000),
                   new LBResponse("charles", stocks, 100, 800),
                   new LBResponse("max", stocks, 100, 300),
                   new LBResponse("seb", stocks, 100, -81000));
  }
}
