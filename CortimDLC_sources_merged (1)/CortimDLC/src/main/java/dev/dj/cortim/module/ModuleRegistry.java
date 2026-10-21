package dev.dj.cortim.module;

import java.util.ArrayList;
import java.util.List;

public final class ModuleRegistry {
    private static final List<Module> MODULES = new ArrayList<>();

    private ModuleRegistry() {}

    public static void add(Module m) { MODULES.add(m); }
    public static List<Module> all() { return MODULES; }

    public static Module byName(String name) {
        for (Module m : MODULES) if (m.getName().equalsIgnoreCase(name)) return m;
        return null;
    }
}