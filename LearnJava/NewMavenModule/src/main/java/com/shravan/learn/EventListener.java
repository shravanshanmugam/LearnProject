package com.shravan.learn;

public abstract class EventListener {

    abstract void messageReceived(String event, Tuple tuple);
}
