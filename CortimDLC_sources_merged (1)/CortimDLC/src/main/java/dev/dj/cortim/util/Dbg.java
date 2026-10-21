package dev.dj.cortim.util;

import dev.dj.cortim.Cortim;

import java.util.HashMap;
import java.util.Map;

public final class Dbg {
    private static final Map<String, Long> LAST = new HashMap<>();

    private Dbg() {}

    public static void every(String key, long ms, String msg, Object... args) {
        long now = System.currentTimeMillis();
        Long prev = LAST.get(key);
        if (prev != null && now - prev < ms) return;
        LAST.put(key, now);
        Cortim.LOG.info("[dbg] " + msg, args);
    }
}