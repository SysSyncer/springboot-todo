package dev.syssyncer.Playground.controllers;

import dev.syssyncer.Playground.models.Todo;
import dev.syssyncer.Playground.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestParam("todoId") Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return new ResponseEntity<Todo>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<String> deleteTodoById(@RequestParam("todoId") Long id) {
        todoService.deleteTodoById(id);
        return new ResponseEntity<String>("Deleted ID " + id + " Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteAllTodo() {
        todoService.deleteAllTodo();
        return new ResponseEntity<>("Deleted All Todos", HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getPagedTodos(@RequestParam("pageno") Integer page, @RequestParam("size") Integer size) {
        return new ResponseEntity<Page<Todo>>(todoService.getPagedTodos(page, size), HttpStatus.OK);
    }
}
