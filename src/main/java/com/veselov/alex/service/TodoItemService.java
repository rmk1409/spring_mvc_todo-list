package com.veselov.alex.service;

import com.veselov.alex.model.TodoData;
import com.veselov.alex.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem item);

    TodoData getData();
}
