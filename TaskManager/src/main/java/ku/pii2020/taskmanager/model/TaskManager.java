/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTable;
import ku.pii2020.taskmanager.view.DataViewer;

/**
 *
 * @author dave
 */
public class TaskManager {
   private static final String CSVHEADERUSERS = "user_id,name";
   private static final String CSVHEADERTASKS = "task_id,user_id,title,priority,targetDate,completed";
   private static final String CSVHEADERSUBTASKS = "sequence,task_id,title,completed";
   
    private static List<Task> tasks = new ArrayList();

    private static List<User> users = new ArrayList();
    
    private static DataViewer dataViewer;

    /**
     * Get the value of taskViewer
     *
     * @return the value of taskViewer
     */
    public static DataViewer getDataViewer() {
        return dataViewer;
    }

    /**
     * Set the value of taskViewer
     *
     * @param taskViewer new value of taskViewer
     */
    public static void setDataViewer(DataViewer dataViewer) {
        TaskManager.dataViewer = dataViewer;
    }
      
    public static void displayUsers() {
        dataViewer.getUserPanel().getTextDisplay().append(printUsers());
        dataViewer.getUserCsvPanel().getTextDisplay().append(csvUsers());
        dataViewer.getUserTable().getDtm().setDataVector((Object[][]) getUserRowData(), getUserColumnHeaders());
    }
    
    public static void displayTasks() {
        dataViewer.getTaskPanel().getTextDisplay().append(printTasks());
        dataViewer.getTaskCsvPanel().getTextDisplay().append(csvTasks());
        dataViewer.getTaskTable().getDtm().setDataVector((Object[][]) getTaskRowData(), getTaskColumnHeaders());
    }
    
    public static void displaySubTasks() {
        dataViewer.getSubTaskPanel().getTextDisplay().append(printSubTasks());
        dataViewer.getSubTaskCsvPanel().getTextDisplay().append(csvSubTasks());
        dataViewer.getSubTaskTable().getDtm().setDataVector((Object[][]) getSubTaskRowData(), getSubTaskColumnHeaders());
    }
   
    public static void clearTables() {
        dataViewer.getUserPanel().getTextDisplay().setText("");
        dataViewer.getUserCsvPanel().getTextDisplay().setText("");
        dataViewer.getTaskPanel().getTextDisplay().setText("");
        dataViewer.getTaskCsvPanel().getTextDisplay().setText("");
        dataViewer.getSubTaskPanel().getTextDisplay().setText("");
        dataViewer.getSubTaskCsvPanel().getTextDisplay().setText("");
        dataViewer.getTaskTable().getDtm().setDataVector(null, getTaskColumnHeaders());
        dataViewer.getUserTable().getDtm().setDataVector(null, getUserColumnHeaders());
        dataViewer.getSubTaskTable().getDtm().setDataVector(null, getSubTaskColumnHeaders());
    }
      
    public static Object[] getUserColumnHeaders() {
        Object[] colss = {"id", "name"};
        return colss;
    }
    
    public static Object[] getUserRowData() {
        Object[][] rows = new Object[users.size()] [2];
        Object[] row = users.toArray();
        for(int i=0; i < users.size(); i++) {
            rows[i][0] = ((User)(row[i])).getId();
            rows[i][1] = ((User)(row[i])).getName();            
        }
        return rows;
    }
    
    public static Object[] getTaskColumnHeaders() {
        Object[] cols = {"id", "userId", "title", "priority", "target date", "isCompleted"};
        return cols;
    }
    
    public static Object[] getTaskRowData() {
        Object[][] rows = new Object[tasks.size()] [6];
        Object[] row = tasks.toArray();
        for(int i=0; i < tasks.size(); i++) {
            rows[i][0] = ((Task)(row[i])).getId();
            rows[i][1] = ((Task)(row[i])).getUserId();
            rows[i][2] = ((Task)(row[i])).getTitle();
            rows[i][3] = String.valueOf(((Task)(row[i])).getPriority());
            rows[i][4] = ((Task)(row[i])).getTargetDate().toString();
            rows[i][5] = ((Task)(row[i])).isCompleted();
            
        }
        return rows;
    }
     
    public static Object[] getSubTaskColumnHeaders() {
        Object[] cols = {"sequence", "taskId", "title", "isCompleted"};
        return cols;
    }
    
    public static Object[] getSubTaskRowData() {
        Object[][] rows = new Object[subTasks.size()] [4];
        Object[] row = subTasks.toArray();
        for(int i=0; i < subTasks.size(); i++) {
            rows[i][0] = ((SubTask)(row[i])).getSequence();
            rows[i][1] = ((SubTask)(row[i])).getTaskId();
            rows[i][2] = ((SubTask)(row[i])).getTitle();
            rows[i][3] = ((SubTask)(row[i])).isCompleted();
        }
        return rows;
    }
    
    public static String printUsers() {
        StringBuilder sb = new StringBuilder();
        for (User u: users) {
            sb.append(u.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public static String csvUsers() {
        StringBuilder sb = new StringBuilder();
        for (User u: users) {
            sb.append(u.getId() + "," + u.getName());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public static String printTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task t: tasks) {
            sb.append(t.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public static String csvTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task t: tasks) {
            sb.append(t.getId() + "," + t.getUserId() + "," + t.getTitle() + "," + t.getPriority() + "," + t.getTargetDate().toString() + "," + t.isCompleted());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public static String printSubTasks() {
        StringBuilder sb = new StringBuilder();
        for (SubTask s: subTasks) {
            sb.append(s.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    
    public static String csvSubTasks() {
        StringBuilder sb = new StringBuilder();
        for (SubTask s: subTasks) {
            sb.append(s.getSequence() + "," + s.getTaskId() + "," + s.getTitle() + "," + s.isCompleted());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    /**
     *
     * @return
     */
    public static List<SubTask> getSubTasks() {
        return subTasks;
    }

    // a temporary store of subtasks before being assigned to the relevant tasks

    /**
     *
     * @param subTasks
     */
    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
    private static List<SubTask> subTasks = new ArrayList();
    
    /**
     *
     */
    public TaskManager(){
     
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // this is currently unused as the model is tested using RunTests in the Test Packages
        
    }
    
    /**
     *
     */
    public void assignStoredTasks(){
        // assign new tasks to users after initialising the application 
        // this currently works just for the initial csvFile
        for(Task t: tasks){
            User u = this.getUser(t.getUserId());
            u.addTask(t);
        }
        
    }
    
    /**
     *
     */
    public void assignStoredSubTasks(){
        // assign sub-tasks to tasks after initialising the application 
        // this currently works just for the initial csvFile
        for(SubTask s: subTasks){
            Task t = this.getTask(s.getTaskId());
            t.addSubTask(s);
        }
        
    }
    /**
     * Get the value of users
     *
     * @return the value of users
     */
    public static List<User> getUsers() {
        return users;
    }

    /**
     * Set the value of users
     *
     * @param users new value of users
     */
    public void setUsers(List<User> users) {
        this.users = users;
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
     *
     * @param task
     * @return
     */
    public static boolean addTask(Task task){
        return tasks.add(task);
    }

    /**
     *
     * @param user
     * @return
     */
    public static boolean addUser(User user){
         return users.add(user);
    }
    
    /**
     *
     * @param subTask
     * @return
     */
    public static boolean addSubTask(SubTask subTask){
         return subTasks.add(subTask);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Task getTask(String id){
         Task task = null;
         for (Task t : tasks){
             if (t.getId().equals(id)) task = t;
         }
         return task;
     }

    /**
     *
     * @param id
     * @return
     */
    public User getUser(String id){
           User user = null;
         for (User u : users){
             if (u.getId().equals(id)) user = u;
         }
         return user;
       }
       
    /**
     *
     * @param id
     * @param sequence
     * @return
     */
    public SubTask getSubTask(String id, int sequence){
           SubTask subTask = null;
         for (SubTask s : subTasks){
             if (s.getTaskId().equals(id) && s.getSequence()==sequence) subTask = s;
         }
         return subTask;
       }
       
    /**
     *
     * @param task
     * @return
     */
    public static void removeTask(int task){
           tasks.remove(task);
       }
       
    /**
     *
     * @param user
     * @return
     */
    public static void removeUser(int user){
          users.remove(user);
      }
    
    public static void removeSubTask(int subTask){
          subTasks.remove(subTask);
      }
      
    /**
     *
     * @param user
     * @param property
     * @return
     */
    public String getValue(User user, String property){
          String value=null;
          // set value to be the value of the selected property
          switch(property){
              case "name":
                  value = user.getName();
                  break;
                  
              case "id":
                  value = user.getId();
                  break;
                  
                  
          }
          return value;
      }
      
    /**
     *
     * @param task
     * @param property
     * @return
     */
    public String getValue(Task task, String property){
          String value=null;
          // set value to be the value of the selected property
          switch(property){
              case "title":
                  value = task.getTitle();
                  break;
               case "priority":
                  value = Integer.toString(task.getPriority());
                  break;
                case "targetDate":
                  value = task.getTargetDate().toString();
                  break;    
              case "id":
                  value = task.getId();
                  break;
               case "completed":
                  value= Boolean.toString(task.isCompleted());
                  break;
                      
                  
          }
          return value;
      }
      
    /**
     *
     * @param subTask
     * @param property
     * @return
     */
    public String getValue(SubTask subTask, String property){
          String value=null;
          // set value to be the value of the selected property
          switch(property){
              case "title":
                  value = subTask.getTitle();
                  break;
               case "sequence":
                  value = Integer.toString(subTask.getSequence());
                  break;
              case "taskid":
                  value = subTask.getTaskId();
                  break;
               case "completed":
                  value= Boolean.toString(subTask.isCompleted());
                  break;
                      
                  
          }
          return value;
      }
      
    /**
     *
     * @param task
     * @param property
     * @param value
     * @return
     */
    public String setValue(Task task, String property, String value){
          boolean result=false;
          // set value to be the value of the selected property
          switch(property){
              case "title":
                  task.setTitle(value);
                  result = true;
                  break;
               case "priority":
                  task.setPriority(Integer.parseInt(value));
                  result = true;
                  break;
                case "targetDate":
                  task.setTargetDate(LocalDate.parse(value));
                  result = true;
                  break;    
              case "id":
                  task.setId(value);
                  result = true;
                  break;
              case "completed":
                  task.setCompleted(Boolean.parseBoolean(value));
                  result = true;
                  break;
                  
                  
          }
          return value;
      }
      
    /**
     *
     * @param subTask
     * @param property
     * @param value
     * @return
     */
    public String setValue(SubTask subTask, String property, String value){
          boolean result=false;
          // set value to be the value of the selected property
          switch(property){
              case "title":
                  subTask.setTitle(value);
                  result=true;
                  break;
               case "sequence":
                  subTask.setSequence(Integer.parseInt(value));
                  result=true;
                  break;
              case "taskid":
                  subTask.setTaskId(value);
                  result=true;
                  break;
               case "completed":
                  subTask.setCompleted(Boolean.parseBoolean(value));
                  result=true;
                  break;  
          }
          return value;
      }
       
    /**
     *
     * @param user
     * @param property
     * @param value
     * @return
     */
    public boolean setValue(User user, String property,String value) {
             boolean result=false;
          // set value to be the value of the selected property
          switch(property){
              case "name":
                  user.setName(value);
                  result = true;
                  break;
                  
              case "id":
                  user.setId(value);
                  result = true;
                  break;
                  
                  
          }
          return result;
         }
         
    /**
     *
     * @param filename
     */
    public static void readUsersFromCsvFile(String filename){
      try (Scanner in = new Scanner(new File(filename))){
           // read in header line and ignore
          in.nextLine();
          while(in.hasNextLine()){
              String csvLine = in.nextLine();
              User user = new User(csvLine);
              addUser(user);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
         
   }
   
    /**
     *
     * @param filename
     */
    public static void readTasksFromCsvFile(String filename){
      try (BufferedReader in = new BufferedReader(new FileReader(filename))){
          // read in header line and ignore
          in.readLine();
          while(in.ready()){
              String csvLine = in.readLine();
              Task task = new Task(csvLine);
              addTask(task);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
    /**
     *
     * @param filename
     */
    public static void readSubTasksFromCsvFile(String filename){
      try (BufferedReader in = new BufferedReader(new FileReader(filename))){
          // read in header line and ignore
          in.readLine();
          while(in.ready()){
              String csvLine = in.readLine();
              SubTask subtask = new SubTask(csvLine);
              addSubTask(subtask);
          }
          
          in.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
    /**
     *
     * @param filename
     */
    public static void writeTasksToCsvFile(String filename){
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
          // write the headerline
          out.write(CSVHEADERTASKS);
          out.newLine();
          for(Task t: tasks){
              out.write(t.toString());
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
       
    /**
     *
     * @param filename
     */
    public static void writeUsersToCsvFile(String filename){
        
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
          // write the headerline
          out.write(CSVHEADERUSERS);
          out.newLine();
          for(User u: users){
              out.write(u.toString());
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }
    
    /**
     *
     * @param filename
     */
    public static void writeSubTasksToCsvFile(String filename){
        
      try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))){
          // write the headerline
          out.write(CSVHEADERSUBTASKS);
          out.newLine();
          for(SubTask s: subTasks){
              out.write(s.toString());
              out.newLine();
              
          }
          
          out.close();
      }
      catch(IOException e){
          e.printStackTrace();
      }
    }


    
    
}
