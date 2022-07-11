/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.model;

import java.io.File;

/**
 *
 * @author dave
 * To provide data for testing the requirements
 */
public class TestData {
    
    public static String testUserReadFilename(){
        return "testdata" + File.separator + "users.csv";
    }
    
    public static String testTaskReadFilename(){
        return "testdata" + File.separator + "tasks.csv";
    }
    
    public static String testSubTaskReadFilename(){
        return "testdata" + File.separator + "subtasks.csv";
    }
    
    public static String testUserWriteFilename(){
        return "testdata" + File.separator + "usersWrite.csv";
    }
    
    public static String testTaskWriteFilename(){
        return "testdata" + File.separator + "tasksWrite.csv";
    }
    
    public static String testSubTaskWriteFilename(){
        return "testdata" + File.separator + "subtasksWrite.csv";
    }
    public static String testTasksData(){
        // multiple tasks
        StringBuilder sb = new StringBuilder();
        sb.append("1,1,Tie Shoes,3,2021-11-30,true");
        sb.append(System.lineSeparator());
        sb.append("2,1,Use the visual EXE spyware,1,2020-12-30,true");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
    
    public static String testTaskData(){
        // a single task
         return new String("1,1,Tie Shoes,3, 2021-11-30,true");
    }
    
       
     public static String testUsersData(){
         // multiple users
        StringBuilder sb = new StringBuilder();
        sb.append("1,Ahmed Livingstone");
        sb.append(System.lineSeparator());
        sb.append("2,Mike Wallace");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
    
    public static String testUserData(){
         return new String("1,Ahmed Livingstone");
    }
    
     public static String testSubTaskData(){
        String subTaskData = "";
        StringBuilder sb = new StringBuilder();
        sb.append("1,11,Use mobile IDE port to calculate address,false");
        //sb.append(System.lineSeparator());
        return sb.toString();
        
    }
     
     

  
     public static String testSubTasksData(){
         // multiple users
        StringBuilder sb = new StringBuilder();
        sb.append("1,11,Use mobile IDE port to calculate address,false");
        sb.append(System.lineSeparator());
        sb.append("1,7,Copy the array into the antenna,true");
        sb.append(System.lineSeparator());
        return sb.toString();
    }
     
   
}
