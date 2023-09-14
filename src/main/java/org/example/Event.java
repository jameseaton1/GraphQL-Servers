package org.example;

public class Event {
    private final Integer id;
    private final String name;

    public Event(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
