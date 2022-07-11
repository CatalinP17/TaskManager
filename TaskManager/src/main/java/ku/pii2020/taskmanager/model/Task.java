package ku.pii2020.taskmanager.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dave
 */
public class Task {
    
    private String id;

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

    private String title;

    private int priority;
    
    private LocalDate targetDate;
    
    private String userId;
   
    private boolean completed;

    /**
     * Get the value of completed
     *
     * @return the value of completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Set the value of completed
     *
     * @param completed new value of completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * Get the value of userId
     *
     * @return the value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set the value of userId
     *
     * @param userId new value of userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }


    private static List<SubTask> subTasks = new ArrayList();
  /**
     *
     * @param string
     */
    public Task(String csvLine) {
        String[] attributes = csvLine.split(",");
       // update to reflect ID
        this.id = attributes[0];
        this.userId = attributes[1];
        this.title = attributes[2];
        this.priority = Integer.parseInt(attributes[3]);
        this.targetDate = LocalDate.parse(attributes[4]);
        this.completed = Boolean.parseBoolean(attributes[5]);
        
    }

    /**
     *
     */
    public Task() {
    }
    
    
    /**
     * Get the value of subTasks
     *
     * @return the value of subTasks
     */
    public static List<SubTask> getSubTasks() {
        return subTasks;
    }

    /**
     * Set the value of subTasks
     *
     * @param subTasks new value of subTasks
     */
    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    /**
     * Get the value of targetDate
     *
     * @return the value of targetDate
     */
    public LocalDate getTargetDate() {
        return targetDate;
    }

    /**
     * Set the value of targetDate
     *
     * @param targetDate new value of targetDate
     */
    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    /*
    public void setTargetDate(String dateStr) throws DateTimeParseException {
        this.targetDate = LocalDate.parse(dateStr);
    }
*/
    /**
     * Get the value of priority
     *
     * @return the value of priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the value of priority
     *
     * @param priority new value of priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", userId=" + userId + ", title=" + title + ", priority=" + priority + ", targetDate=" + targetDate.toString() + ", isCompleted=" + completed + "}";
    }
    
    /**
     *
     * @param subTask
     * @return
     */
    public boolean addSubTask(SubTask subTask){
        return subTasks.add(subTask);
    }
    
}
