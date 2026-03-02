package com.brand.blockus.utils.helper;

public enum BoatTypes {
    WHITE_OAK("white_oak"),
    CHARRED("charred"),
    RAW_BAMBOO("raw_bamboo");

    public final String boat;
    public final String chestBoat;
    public final String raft;
    public final String chestRaft;
    public final String boatLayer;
    public final String chestBoatLayer;
    public final String raftLayer;
    public final String chestRaftLayer;

    BoatTypes(String type) {
        this.boat = type + "_boat";
        this.chestBoat = type + "_chest_boat";
        this.raft = type + "_raft";
        this.chestRaft = type + "_chest_raft";
        this.boatLayer = "boat/" + type;
        this.chestBoatLayer = "chest_boat/" + type;
        this.raftLayer = "raft/" + type;
        this.chestRaftLayer = "chest_raft/" + type;
    }
}
