package dev.syssyncer.Playground.services;

import dev.syssyncer.Playground.repositories.TodoRepository;
import dev.syssyncer.Playground.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public void deleteAllTodo() {
        todoRepository.deleteAll();
    }

    public Page<Todo> getPagedTodos(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }

}
