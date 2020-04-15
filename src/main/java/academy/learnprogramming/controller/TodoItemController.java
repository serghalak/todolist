package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData(){
        //TodoData todoData = new TodoData();
//        TodoData todoData = todoItemService.getData();
//        todoData.addItem(new TodoItem("mytitle"
//                ,"mydetails",LocalDate.now()));
        return  todoItemService.getData();
    }

    @GetMapping(Mappings.ITEMS)
    public String item(Model model){
//        todoItemService.addItem(new TodoItem("mytitle"
//                ,"mydetails",LocalDate.now()));
//        model.addAttribute("todoData",todoItemService.getData());
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(
            @RequestParam(required = false, defaultValue = "-1") int id
            , Model model){

        log.info("editing id = {}",id);
        TodoItem todoItem=todoItemService.getItem(id);

        if(todoItem == null){
            todoItem=new TodoItem("","",LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(
            @ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from = {}",todoItem);

        if(todoItem.getId()==0){
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@NonNull @RequestParam int id){
        log.info("Deliting item with id = {}",id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@NonNull @RequestParam int id,Model model) {
        log.info("view item with id {}",id);
        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,item);
        return ViewNames.VIEW_ITEM;
    }

}
