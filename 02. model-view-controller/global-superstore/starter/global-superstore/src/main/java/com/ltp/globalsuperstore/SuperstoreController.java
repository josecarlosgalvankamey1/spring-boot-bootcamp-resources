package com.ltp.globalsuperstore;

import static com.ltp.globalsuperstore.Constants.CATEGORIES;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperstoreController {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("categories", CATEGORIES);
        model.addAttribute("item", new Item());
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory() {

        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item) {
        System.out.println(item);
        items.add(item);
        return "redirect:/inventory";
    }
}
