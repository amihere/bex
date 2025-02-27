package com.arachnid.bex.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LBController {

  public LBController() {}

  @MessageMapping("/get-leaders")
  @SendTo("/topic/leaderboard")
  public LBResponse getLeaderBoard(LBRequest message) throws Exception {
    System.out.println("Update at " + System.currentTimeMillis());
    Thread.sleep(1000); // simulated delay
    return new LBResponse("kwesi leads with " + (1 + Math.random() * 100) +
                          " stocks");
  }
}
