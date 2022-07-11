/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dave
 */
public class User {
   
    private String name;

    private static List<Task> tasks = new ArrayList();

    private String id;

    /**
     *
     */
    public User(){
        
    }
     /**
     *
     * @param string
     */
    public User(String csvLine) {
        String[] attributes = csvLine.split(",");
       // update to reflect ID
        this.id = attributes[0];
        this.name = attributes[1];
      
    }

    /**
     *
     * @param task
     * @return
     */
    public boolean addTask(Task task){
        return tasks.add(task);
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the value of tasks
     *
     * @return the value of tasks
     */
    public static List<Task> getTasks() {
        return tasks;
    }

    /**
     * Set the value of tasks
     *
     * @param tasks new value of tasks
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public static Task getTask(String id){
         Task task = null;
         for (Task t : tasks){
             if (t.getId().equals(id)) task = t;
         }
         return task;
     }
    
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + "}";
    }
 
}
