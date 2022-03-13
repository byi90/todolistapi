package com.todolistapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todo")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long todoId;

    @NotNull
    @Size(max = 100)
    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    

    @Column(name = "done")
    private boolean done;


// Many to one between a user and todos
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;




    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo )) return false;
        return todoId != null && todoId.equals(((Todo) o).getTodoId());
    }

    @Override
    public int hashCode() {
        return 31;
    }





    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
