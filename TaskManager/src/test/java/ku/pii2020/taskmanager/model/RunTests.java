/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.model;

import ku.pii2020.taskmanager.view.DataViewer;

/**
 *
 * @author dave
 */
public class RunTests {
    public static void main(String[] args){
         // Testing P2R1:
         // Instantiate a TaskManager object to act as reference point for all application objects 
        System.out.println(TestP2.testCreateTaskManagerListsEmpty());
        System.out.println(TestP2.testCreateUserFromCsvLineTasksEmpty());
        System.out.println(TestP2.testCreateUsersFromCsvLineTasksEmpty());
        System.out.println(TestP2.testCreateUsersFromCsvLineAttributesCorrect());
        System.out.println(TestP2.testCreateTasksFromCsvLineAttributesCorrect());
        System.out.println(TestP2.testAddTasksToTaskManagerCorrectSize());
        System.out.println(TestP2.testAddTasksToTaskManagerTasksAdded());
        System.out.println(TestP2.testAddUsersToTaskManagerCorrectSize());
        System.out.println(TestP2.testAddUsersToTaskManagerUsersAdded());
      // Testing P2R2
      // Delete a pre-existing User(s) and pre-existingTask(s) from the TaskManager
         System.out.println(TestP2.testGetUserFromTaskManager());
         System.out.println(TestP2.testGetTaskFromTaskManager());
         System.out.println(TestP2.testRemoveUserFromTaskManager());
         System.out.println(TestP2.testRemoveTaskFromTaskManager());
      // Testing P2R3
      // Assign a pre-existing User with a pre-existing Task
        System.out.println(TestP2.testAssignTaskToUser());
       
      // Testing P2R4
      // Edit the details of pre-existing Users , pre-existingTasks and pre-existing SubTasks
       System.out.println(TestP2.testGetPropertyOfUser());
       System.out.println(TestP2.testGetPropertyOfTask());
       System.out.println(TestP2.testSetPropertyOfUser());
       System.out.println(TestP2.testSetPropertyOfTask());
       // Testing P2R5
       //Add sub-tasks, to a pre-existing Task of a pre-existingUser
       System.out.println(TestP2.testGetTaskFromUser());
       System.out.println(TestP2.testCreateSubTaskFromCsvLine());
       System.out.println(TestP2.testCreateSubTasksFromCsvLine());
       System.out.println(TestP2.testAddSubTaskToTask()); 
       // now see if editing functionality of sub-tasks is in place
       System.out.println(TestP2.testGetPropertyOfSubTask());
       System.out.println(TestP2.testSetPropertyOfSubTask());
       
   
        // Testing P2R6
        // Load User and Task/SubTasks from a provided file(s)
        System.out.println(TestP2.testAddUsersFromCsvFile());
        System.out.println(TestP2.testAddTasksFromCsvFile());
        System.out.println(TestP2.testAddSubTasksFromCsvFile());
        System.out.println(TestP2.testAssignStoredTasksToUsers());
        System.out.println(TestP2.testAssignStoredSubTasksToTasks());
        
         
        // Testing P2R7
        //  Save User and Task/SubTasks to a local file
        TestP2.testWriteUsersToCsvFile();
        TestP2.testWriteTasksToCsvFile();
        TestP2.testWriteSubTasksToCsvFile();
      
        DataViewer dv = new DataViewer();
        TaskManager.setDataViewer(dv);
        
    
    }
}
