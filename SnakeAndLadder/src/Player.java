package com.lld;

public class Player {
    private Integer id;
    private String name;
//    private PlayerStats playerStats;

    public Player(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
