package dev.syssyncer.Playground.repositories;

import dev.syssyncer.Playground.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends JpaRepository<Todo, Long> {
}