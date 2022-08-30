package com.mytodo_backend.todo_back;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Desc")
    private String desc;

    @Column(name = "Status")
    private boolean isDone;

    public Todo() {
    }

    public Todo(Integer id, String title, String desc, boolean isDone) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.isDone = isDone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
