package com.ltp.globalsuperstore.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

public class StoreService {
    StoreRepository storeRepository = new StoreRepository();

    public void addItem(Item item) {
        storeRepository.addItem(item);
    }

    public void updateItem(Item item, int index) {
        storeRepository.updateItem(item, index);
    }

    public Item getItem(int index) {
        return storeRepository.getItem(index);
    }

    public List<Item> getItems() {
        return storeRepository.getItems();
    }

    public Item getItemById(String id) {
        int index = getIndexFromId(id);
        return (index == Constants.NOT_FOUND ? new Item() : storeRepository.getItem(index));
    }

    public int getIndexFromId(String id) {
        List<Item> items = storeRepository.getItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id))
                return i;
        }
        return Constants.NOT_FOUND;
    }

    public String submitItem(Item item) {
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            storeRepository.addItem(item);
        } else if (within5Days(item.getDate(), storeRepository.getItem(index).getDate())) {
            storeRepository.updateItem(item, index);
        } else {
            status = Constants.FAILED_STATUS;
        }
        return status;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
