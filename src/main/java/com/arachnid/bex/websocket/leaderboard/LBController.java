package com.arachnid.bex.websocket.leaderboard;

import java.util.List;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class LBController {
  private final SimpMessagingTemplate smt;
  private final LBService lbService;

  public LBController(SimpMessagingTemplate smt, LBService lbService) {
    this.smt = smt;
    this.lbService = lbService;
  }

  // @MessageMapping("/get-leaders")
  // @SendTo("/topic/leaderboard")
  @Scheduled(fixedRate = 100)
  public void getLeaderBoard() throws Exception {
    long millis = System.currentTimeMillis();
    System.out.println(String.format("Update at %d", millis));

    List<LBResponse> rsp = lbService.getLeaderBoard(millis);
    smt.convertAndSend("/topic/leaderboard", rsp);
  }
}
