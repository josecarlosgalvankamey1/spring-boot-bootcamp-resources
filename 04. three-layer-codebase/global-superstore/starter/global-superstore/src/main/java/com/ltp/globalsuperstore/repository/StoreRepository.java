package com.ltp.globalsuperstore.repository;

import java.util.ArrayList;
import java.util.List;
import com.ltp.globalsuperstore.Item;

public class StoreRepository {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItem(Item item, int index) {
        items.set(index, item);
    }

}
