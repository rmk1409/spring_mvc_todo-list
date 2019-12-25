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
import org.springframework.web.bind.annotation.*;

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
    public String addEditItem(Model model) {
        model.addAttribute(AttributeNames.TODO_ITEM, new TodoItem("", "", LocalDate.now()));
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem item) {
        log.info("todoItem from form -> {}", item);
        this.service.addItem(item);
        return String.format("redirect:/%s", ITEMS);
    }

    @GetMapping(DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        this.service.removeItem(id);
        return String.format("redirect:/%s", ITEMS);
    }
}
