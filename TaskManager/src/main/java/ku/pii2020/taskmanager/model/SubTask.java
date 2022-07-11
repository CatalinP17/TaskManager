package ku.pii2020.taskmanager.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dave
 */
public class SubTask {

    /**
     * @param args the command line arguments
     */
        private String title;

    private int sequence;
    
        private boolean completed;
       
    private String taskId;

    /**
     * Get the value of taskId
     *
     * @return the value of taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Set the value of taskId
     *
     * @param taskId new value of taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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
     * Get the value of sequence
     *
     * @return the value of sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Set the value of sequence
     *
     * @param sequence new value of sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    /**
     *
     */
    public SubTask() {
    }
    
    /**
     *
     * @param csvLine
     */
    public SubTask(String csvLine) {
         String[] attributes = csvLine.split(",");
       // update to reflect ID
       this.sequence = Integer.parseInt(attributes[0]);
       this.taskId=attributes[1];
       this.title = attributes[2];
       this.completed = Boolean.parseBoolean(attributes[3]);
      
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
        return "Task{" + "sequence=" +  sequence + ", taskId=" + taskId + ", title=" + title + ", completed=" +  completed + "}";
    }
    
   

    
}
