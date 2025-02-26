package com.arachnid.bex.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LBController {

  public LBController() {}

  @MessageMapping("/get-leaders")
  @SendTo("${bex.websocket.broker}/leaderboard")
  public LBResponse getLeaderBoard(LBRequest message) throws Exception {
    Thread.sleep(1000); // simulated delay
    return new LBResponse("Hello, " + HtmlUtils.htmlEscape(message.username()) +
                          "!");
  }
}
