package com.veselov.alex.controller;

import com.veselov.alex.model.TodoData;
import com.veselov.alex.util.Mappings;
import com.veselov.alex.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
