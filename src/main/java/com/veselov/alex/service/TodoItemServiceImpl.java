package com.veselov.alex.service;

import com.veselov.alex.model.TodoData;
import com.veselov.alex.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Getter
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem item) {
        this.data.add(item);
    }

    @Override
    public void removeItem(int id) {
        this.data.remove(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return this.data.getById(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        this.data.update(item);
    }
}
