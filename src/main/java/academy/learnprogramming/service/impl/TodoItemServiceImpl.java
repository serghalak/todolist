package academy.learnprogramming.service.impl;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoData data=new TodoData();

    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

//    @Override
//    public TodoData getData() {
//        return todoData;
//    }
}
