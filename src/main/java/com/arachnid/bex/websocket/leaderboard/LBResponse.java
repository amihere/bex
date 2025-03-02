package com.arachnid.bex.websocket.leaderboard;

public record LBResponse(String name, long[] stocks, long balance, long pnl) {}
