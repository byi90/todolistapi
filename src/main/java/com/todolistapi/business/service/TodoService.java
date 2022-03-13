package com.todolistapi.business.service;

import com.todolistapi.data.entity.Todo;
import com.todolistapi.data.entity.User;
import com.todolistapi.data.repository.TodoRepository;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    public void updateUserTodo(Todo todo, Todo newTodoData){
        todo.setTitle(newTodoData.getTitle());
        todo.setDescription(newTodoData.getDescription());
        todo.setDone(newTodoData.getDone());
    }

    public void deleteTodo(Todo todo, User currentUser){
        currentUser.deleteTodo(todo);
        getTodoRepository().delete(todo);

    }

    public Todo getTodoByUserAndId(User user, Long todoId){
        return getTodoRepository().findByUserAndTodoId(user, todoId);
    }

    public void addTodo(Todo todo, User currentUser){
        todo.setUser(currentUser);
        currentUser.addTodo(todo);
        getTodoRepository().save(todo);
    }





    public TodoRepository getTodoRepository() {
        return todoRepository;
    }
}
