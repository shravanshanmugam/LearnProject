package com.shravan.learn;

public abstract class EventHandler implements Events {

    enum Event {
        ADD, EDIT, REMOVE, REFRESH
    }

    public void handleEvents(String event, Tuple tuple) {
        if (Event.ADD.name().equals(event)) {
            onAdd(tuple);
        } else if (Event.EDIT.name().equals(event)) {
            onEdit(tuple);
        } else if (Event.REMOVE.name().equals(event)) {
            onRemove(tuple);
        } else if (Event.REFRESH.name().equals(event)) {
            onRefresh();
        }
    }
}
