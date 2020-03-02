package com.example.testcalander;

import java.util.ArrayList;

public class AppCalendar {
    private String title;

    private ArrayList<Plan> planList;
    private ArrayList<Todo> todoList;
    private ArrayList<Project> projectList;

    public AppCalendar(String title){
        this.title = title;
        planList = new ArrayList<Plan>();
        todoList = new ArrayList<Todo>();
        projectList = new ArrayList<Project>();
    }
    public AppCalendar(){

    }

    public void createPlan(){}
    public void createTodo(){}
    public void createProject(){}

    public void removePlan(){}
    public void removeTodo(){}
    public void removeProject(){}

    public void editPlan(){}
    public void editTodo(){}
    public void editProject(){}
}
