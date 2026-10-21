package dev.dj.cortim.gui;

import java.util.Set;

public interface ItemSelector {
    Set<String> getSelected();
    void toggleItem(String id);
    void clearItems();
}