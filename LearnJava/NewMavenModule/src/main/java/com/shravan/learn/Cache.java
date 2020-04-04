package com.shravan.learn;

import java.util.HashMap;
import java.util.Map;

public class Cache extends EventHandler {

    private static Cache INSTANCE = new Cache();

    private Cache() {
    }

    public static Cache getInstance() {
        return INSTANCE;
    }

    private Map<Integer, String> cacheData = new HashMap<>();

    public Map<Integer, String> getCacheData() {
        return cacheData;
    }

    @Override
    public void onAdd(Tuple tuple) {
        cacheData.put(tuple.getId(), tuple.getValue());
    }

    @Override
    public void onEdit(Tuple tuple) {
        cacheData.put(tuple.getId(), tuple.getValue());
    }

    @Override
    public void onRemove(Tuple tuple) {
        cacheData.remove(tuple.getId());
    }

    @Override
    public void onRefresh() {
        // DB Call
    }
}
