package com.veselov.alex.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
    private static int increment = 1;
    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        this.add(new TodoItem("first title", "first details", LocalDate.now()));
        this.add(new TodoItem("second title", "second details", LocalDate.now()));
        this.add(new TodoItem("third title", "third details", LocalDate.now()));
        this.add(new TodoItem("4rd title", "4rd details", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public void add(@NonNull TodoItem item) {
        item.setId(increment++);
        this.items.add(item);
    }

    public TodoItem getById(int id) {
        return this.items
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(@NonNull TodoItem updated) {
        ListIterator<TodoItem> iterator = this.items.listIterator();
        while (iterator.hasNext()) {
            TodoItem next = iterator.next();
            if (updated.equals(next)) {
                iterator.set(updated);
                break;
            }
        }
    }

    public void remove(int id) {
        ListIterator<TodoItem> iterator = this.items.listIterator();
        while (iterator.hasNext()) {
            TodoItem next = iterator.next();
            if (id == next.getId()) {
                iterator.remove();
                break;
            }
        }
    }
}
