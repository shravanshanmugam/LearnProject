package com.shravan.learn;

public interface Events {

    void onAdd(Tuple tuple);
    void onEdit(Tuple tuple);
    void onRemove(Tuple tuple);
    void onRefresh();
}
