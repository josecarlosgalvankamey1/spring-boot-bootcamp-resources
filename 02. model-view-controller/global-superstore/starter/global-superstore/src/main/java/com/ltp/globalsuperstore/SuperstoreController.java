package com.ltp.globalsuperstore;

import static com.ltp.globalsuperstore.Constants.CATEGORIES;
import static com.ltp.globalsuperstore.Constants.FAILED_STATUS;
import static com.ltp.globalsuperstore.Constants.NOT_FOUND;
import static com.ltp.globalsuperstore.Constants.SUCCESS_STATUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SuperstoreController {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        Item item;
        int itemIndex = getIndex(id);
        item = (itemIndex == NOT_FOUND ? new Item() : items.get(itemIndex));
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("item", item);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        String currentItemId = item.getId();
        String currentStatus = SUCCESS_STATUS;
        int currentItemIndex = getIndex(currentItemId);
        if (currentItemIndex == NOT_FOUND) {
            items.add(item);
        } else if (within5Days(item.getDate(), items.get(currentItemIndex).getDate())) {
            items.set(currentItemIndex, item);
        } else {
            currentStatus = FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", currentStatus);
        return "redirect:/inventory";
    }

    private int getIndex(String id) {
        for (int i = 0; i < items.size(); ++i) {
            Item currentItem = items.get(i);
            if (currentItem.getId().equals(id))
                return i;
        }
        return NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
