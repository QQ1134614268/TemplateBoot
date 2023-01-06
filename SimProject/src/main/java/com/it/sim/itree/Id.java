package com.it.sim.itree;


public interface Id {
    Integer id = null;

    default Integer getId() {
        return id;
    }
}