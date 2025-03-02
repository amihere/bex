package com.arachnid.bex.websocket;

public record LBResponse(String name, long[] stocks, long balance, long pnl) {}
