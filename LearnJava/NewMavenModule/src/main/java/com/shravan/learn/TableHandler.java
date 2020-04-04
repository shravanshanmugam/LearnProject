package com.shravan.learn;

public class TableHandler extends EventListener {

    private Cache cache = Cache.getInstance();

    public void add(Tuple tuple) {
        // DB call
        publishEvent(EventHandler.Event.ADD.name(), tuple);

    }

    private void publishEvent(String event, Tuple tuple) {
        // Publish to Rabbit MQ
    }

    @Override
    void messageReceived(String event, Tuple tuple) {
        cache.handleEvents(event, tuple);
    }
}
