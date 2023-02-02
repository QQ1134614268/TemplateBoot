package com.it.sim.itree;

public interface Path extends Id {
    Integer parentId = null;

    default Integer getParentId() {
        return parentId;
    }
}