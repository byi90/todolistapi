package com.todolistapi.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolistapi.data.entity.Todo;
import com.todolistapi.data.entity.User;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Page<Todo> findByUser(User user, Pageable pageable);

    Todo findByUserAndTodoId(User user, Long todoId);
    boolean existsByUserAndTodoId(User currentUser, Long todoId);


}
