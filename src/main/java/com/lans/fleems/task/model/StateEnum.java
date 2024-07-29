package com.lans.fleems.task.model;

public enum StateEnum {
    ONGOING("Ongoing"), UNASSIGNED("Unassigned"), FINISHED("Finished");

    public final String state;

    StateEnum(String state) {
        this.state = state;
    }
}
