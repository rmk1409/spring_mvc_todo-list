package com.veselov.alex.controller;

import com.veselov.alex.model.TodoData;
import com.veselov.alex.model.TodoItem;
import com.veselov.alex.service.TodoItemService;
import com.veselov.alex.util.AttributeNames;
import com.veselov.alex.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static com.veselov.alex.util.Mappings.*;

@Slf4j
@Controller
public class TodoItemController {
    @Autowired
    private TodoItemService service;

    @ModelAttribute
    public TodoData todoData() {
        return this.service.getData();
    }

    @GetMapping(ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        log.info("Editing id -> {}", id);
        TodoItem item = this.service.getItem(id);
        if (item == null) {
            item = new TodoItem("", "", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem item) {
        if (0 == item.getId()) {
            log.info("Add Item -> {}", item);
            this.service.addItem(item);
        } else {
            log.info("Update Item -> {}", item);
            this.service.updateItem(item);
        }
        return String.format("redirect:/%s", ITEMS);
    }

    @GetMapping(DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Delete item by id -> {}", id);
        this.service.removeItem(id);
        return String.format("redirect:/%s", ITEMS);
    }

    @GetMapping(VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        model.addAttribute(AttributeNames.TODO_ITEM, this.service.getItem(id));
        return ViewNames.VIEW_ITEM;
    }
}
