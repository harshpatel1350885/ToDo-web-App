package com.mytodo_backend.todo_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

// http://localhost:8080/todo
@Controller // This means that this class is a Controller
@RequestMapping(path="/todo") // This means URL's start with /todo (after Application path)
@CrossOrigin(origins = "http://localhost:4200/")
public class MainController {
    private final TodoRepository todoRepository;

    @Autowired
    public MainController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // http://localhost:8080/todo/add
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addTodo (@RequestBody Todo item) {
        todoRepository.save(item);
        return "Todo Added";
    }

    // http://localhost:8080/todo/complete
    @PostMapping(path="/complete")
    public @ResponseBody String completeTodo(@RequestBody Todo item) {
        Todo element = todoRepository.findById(item.getId()-1).orElseThrow(NoSuchElementException::new);
        element.setDone(Boolean.TRUE);
        todoRepository.save(element);
        System.out.println("todo completed");
        return "Saved";
    }

    // http://localhost:8080/todo/delete
    @PostMapping(path="/delete")
    public @ResponseBody String deleteTodo(@RequestBody Todo item) {
        Todo element = todoRepository.findById(item.getId()-1).orElseThrow(NoSuchElementException::new);
        todoRepository.delete(element);
        return "Deleted";
    }

    // http://localhost:8080/todo/find
    @GetMapping(path="/find")
    public @ResponseBody Todo findTodo(@RequestParam Integer todoId) {
        Todo item = todoRepository.findById(todoId).orElseThrow(NoSuchElementException::new);
        return item;
    }

    // http://localhost:8080/todo/all
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Todo> getAllTodos() {
        // This returns a JSON or XML with the users
        return todoRepository.findAll();
    }
}