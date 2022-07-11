/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.model;
/**
 *
 * @author dave
 * For testing the individual Requirements of Phase 2
 * Each requirement will have more than one test
 */
public class TestP2 {
    private static TaskManager testTaskManager;
    private static Task testTask1;
    private static Task testTask2;
    private static User testUser1;
    private static User testUser2;
    private static SubTask testSubTask1;
    private static SubTask testSubTask2;
   
    
    public static boolean testCreateTaskManagerListsEmpty(){
        System.out.println("Testing P2R1 Test1: testCreateTaskManagerListEmpty");
        testTaskManager = new TaskManager();
        return testTaskManager.getTasks().isEmpty() && testTaskManager.getUsers().isEmpty();
    }
     
    public static boolean testCreateUserFromCsvLineTasksEmpty(){
        System.out.println("Testing P2R1 Test2: testCreateUserFromCsvLineTasksEmpty");
        String testCSVLine = TestData.testUserData();
        testUser1 = new User(testCSVLine);
        return testUser1.getTasks().isEmpty();
    }
    
     public static boolean testCreateUsersFromCsvLineTasksEmpty(){
        System.out.println("Testing P2R1 Test3: testCreateUsersFromCsvLineTasksEmpty");
        String testCSVLines[] = TestData.testUsersData().split(System.lineSeparator());
        testUser1 = new User(testCSVLines[0]);
        testUser2 = new User(testCSVLines[0]);
        return testUser1.getTasks().isEmpty() && testUser1.getTasks().isEmpty();
    }
     
      public static boolean testCreateUsersFromCsvLineAttributesCorrect(){
         System.out.println("Testing P2R1 Test4: testCreateUsersFromCsvLineAttributesCorrect");
        String testCSVLines[] = TestData.testUsersData().split(System.lineSeparator());
        testUser1 = new User(testCSVLines[0]);
        testUser2 = new User(testCSVLines[1]);
        return testUser1.toString().equals(testCSVLines[0]) &&
               testUser2.toString().equals(testCSVLines[1]);
    }
      
     public static boolean testCreateTasksFromCsvLineAttributesCorrect(){
         System.out.println("Testing P2R1 Test5: testCreateTasksFromCsvLineAttributesCorrect");
         String testCSVLines[] = TestData.testTasksData().split(System.lineSeparator());
        testTask1 = new Task(testCSVLines[0]);
        testTask2 = new Task(testCSVLines[1]);
        return testTask1.toString().equals(testCSVLines[0]) &&
               testTask2.toString().equals(testCSVLines[1]);
    }
         
    public static boolean testAddTasksToTaskManagerCorrectSize(){
         System.out.println("Testing P2R1 Test6: testAddTasksToTaskManagerCorrectSize");
         testTaskManager = new TaskManager();
         testTaskManager.addTask(testTask1);
         testTaskManager.addTask(testTask2);
         return testTaskManager.getTasks().size() == 2;

         }
         
    public static boolean testAddTasksToTaskManagerTasksAdded(){
         System.out.println("Testing P2R1 Test7: testAddUserToTaskManagerTasksAdded");
         testTaskManager = new TaskManager();
         testTaskManager.addTask(testTask1);
         testTaskManager.addTask(testTask2);
         return testTaskManager.getTasks().contains(testTask1) &&
                    testTaskManager.getTasks().contains(testTask2);
         }
         
    public static boolean testAddUsersToTaskManagerCorrectSize(){
         System.out.println("Testing P2R1 Test8: testAddUserToTaskManagerCorrectSize");
         testTaskManager = new TaskManager();
         testTaskManager.addUser(testUser1);
         testTaskManager.addUser(testUser2);
         return testTaskManager.getUsers().size() == 2;
             
         }
           
     public static boolean testAddUsersToTaskManagerUsersAdded(){
        System.out.println("Testing P2R1 Test8: testAddUserToTaskManagerCorrectSize");
        testTaskManager = new TaskManager();
        testTaskManager.addUser(testUser1);
        testTaskManager.addUser(testUser2);
        return testTaskManager.getUsers().contains(testUser1) &&
                testTaskManager.getUsers().contains(testUser2);
             
         }
     
      
     // P2R2 Tests
      public static boolean testGetUserFromTaskManager(){
        System.out.println("Testing P2R2 Test1: testGetUserFromTaskManager");
        TaskManager testTaskManager = new TaskManager();
        testTaskManager.addUser(testUser1);
        return testTaskManager.getUser("1") == testUser1;
    }
     
      public static boolean testGetTaskFromTaskManager(){
         System.out.println("Testing P2R2 Test2: testGetTaskFromTaskManager");
          TaskManager testTaskManager = new TaskManager();
          testTaskManager.addTask(testTask1);
         return testTaskManager.getTask("1") == testTask1;
    }
      
      public static boolean testRemoveUserFromTaskManager(){
           System.out.println("Testing P2R2 Test3: testRemoveUserFromTaskManager");
            TaskManager testTaskManager = new TaskManager();
           testTaskManager.addUser(testUser1);
           //testTaskManager.removeUser(testUser1);
           return ! testTaskManager.getUsers().contains(testUser1);
      }
      
      
      public static boolean testRemoveTaskFromTaskManager(){
           System.out.println("Testing P2R2 Test4: testRemoveTaskFromTaskManager");
             TaskManager testTaskManager = new TaskManager();
           testTaskManager.addTask(testTask1);
           //testTaskManager.removeTask(testTask1);
           return ! testTaskManager.getTasks().contains(testTask1);
      }
      
      // P2R3 Tests
      
       public static boolean testAssignTaskToUser(){
          System.out.println("Testing P2R3 Test1: testAssignTaskToUser");
          testUser1.addTask(testTask1);
          return testUser1.getTasks().contains(testTask1);
    }
      
       // P2R4 Tests
       // Test1
       // Get the specified attribute of a User as an editable String using the getter (a property)
     public static boolean testGetPropertyOfUser(){
         System.out.println("Testing P2R4 Test1: testGetPropertyOfUser");
         String testString= testUser1.toString();
         return testString.contains(testTaskManager.getValue(testUser1,"id")) &&
                testString.contains(testTaskManager.getValue(testUser1,"name"));
     }
     
     //Test2 
     // Get the specified attribute of a User as an editable String using the getter (a property)
     public static boolean testGetPropertyOfTask(){
         System.out.println("Testing P2R4 Test2: testGetPropertyOfTask");
         String testString= testTask1.toString();
         return testString.contains(testTaskManager.getValue(testTask1,"id")) &&
                testString.contains(testTaskManager.getValue(testTask1,"priority")) &&
                testString.contains(testTaskManager.getValue(testTask1,"title")) &&
                testString.contains(testTaskManager.getValue(testTask1,"targetDate")) &&
                testString.contains(testTaskManager.getValue(testTask1,"completed")) ;
         
     }
     
    
     // Test3
     // Set the specified attribute of a User as an editable String using the setter (a property)
      public static boolean testSetPropertyOfUser(){
          System.out.println("Testing P2R4 Test3: testSetPropertyOfUser");
          String startString = "99,Ed Ituser";
          User editUser = new User(startString);
          boolean result1 = editUser.toString().equals(startString);
          testTaskManager.getUsers().add(editUser);
          String editString = "999,Che Ng";
          testTaskManager.setValue(editUser, "id", "999");
          testTaskManager.setValue(editUser, "name", "Che Ng");
          boolean result2 = editUser.toString().equals(editString);
          testTaskManager.getUsers().remove(editUser);
          return result1 && result2;
      
      }
     //Test4 
     // Set the specified attribute of a Task as an editable String using the setter (a property)
      public static boolean testSetPropertyOfTask(){
          System.out.println("Testing P2R4 Test4: testSetPropertyOfTask");
          String startString = "99,1,Just do it,1,2020-01-01,true";
          Task editTask = new Task(startString);
          boolean result1 = editTask.toString().equals(startString);
          testTaskManager.getTasks().add(editTask);
          String editString = "999,1,Don't do that,2,2020-12-31,false";
          testTaskManager.setValue(editTask, "id", "999");
          testTaskManager.setValue(editTask, "priority", "2");
          testTaskManager.setValue(editTask, "title", "Don't do that");
          testTaskManager.setValue(editTask, "targetDate", "2020-12-31");
          testTaskManager.setValue(editTask, "completed", "false");
          boolean result2 = editTask.toString().equals(editString);
          testTaskManager.getTasks().remove(editTask);
          return result1 && result2;
      }
       
  
        // P2R5 Tests
       //test1
         public static boolean testGetTaskFromUser(){
          System.out.println("Testing P2R5 Test1 :  testGetTaskFromUser");
          testUser1.addTask(testTask1);
          return testUser1.getTask("1")==testTask1;
    }

     
     //test2
       public static boolean testCreateSubTaskFromCsvLine(){
          System.out.println("Testing P2R5 Test2 : testCreateSubTaskFromCsvLine ");
         String csvLine = TestData.testSubTaskData();
         testSubTask1 = new SubTask(csvLine);
        if (testSubTask1.toString().equals(csvLine)){
            return true;
        }
        return false;
    }
       
       
        //test3
       public static boolean testCreateSubTasksFromCsvLine(){
          System.out.println("Testing P2R5 Test3 : testCreateSubTaskFromCsvLine ");
          String testCSVLines[] = TestData.testSubTasksData().split(System.lineSeparator());
         testSubTask1 = new SubTask(testCSVLines[0]);
         testSubTask2 = new SubTask(testCSVLines[1]);
        return testSubTask1.toString().equals(testCSVLines[0]) &&
               testSubTask2.toString().equals(testCSVLines[1]);
        
    }
       
       //test4
      public static boolean testAddSubTaskToTask(){
          System.out.println("Testing P2R5: Test4 testAddSubTaskToTask");
          testTask1.addSubTask(testSubTask1);
          return testTask1.getSubTasks().contains(testSubTask1);
    }
      
      
      // now test if we can edit subTasks so that P2R4 is complete
      
       //Test5
     // Get the specified attribute of a User as an editable String using the getter (a property)
     public static boolean testGetPropertyOfSubTask(){
         System.out.println("Testing P2R5 P2R4 Test5: testGetPropertyOfSubTask");
         String testString= testSubTask1.toString();
         return testString.contains(testTaskManager.getValue(testSubTask1,"taskid")) &&
                testString.contains(testTaskManager.getValue(testSubTask1,"sequence")) &&
                testString.contains(testTaskManager.getValue(testSubTask1,"title")) &&
                testString.contains(testTaskManager.getValue(testSubTask1,"completed")) ;
         
     }
     
      //Test6 
     // Set the specified attribute of a SubTask as an editable String using the setter (a property)
      public static boolean testSetPropertyOfSubTask(){
          System.out.println("Testing P2R5 P2R4 Test5: testSetPropertyOfSubTask");
          String startString = "1,11,Use mobile IDE port to calculate address,false";
          SubTask editSubTask = new SubTask(startString);
          boolean result1 = editSubTask.toString().equals(startString);
          testTaskManager.getSubTasks().add(editSubTask);
           String editString = "2,7,Configure mobile IDE port to calculate address,true";
          testTaskManager.setValue(editSubTask, "taskid", "7");
          testTaskManager.setValue(editSubTask, "sequence", "2");
          testTaskManager.setValue(editSubTask, "title", "Configure mobile IDE port to calculate address");
          testTaskManager.setValue(editSubTask, "completed", "true");
          boolean result2 = editSubTask.toString().equals(editString);
          testTaskManager.getTasks().remove(editSubTask);
          return result1 && result2;
      }
       
       // P2R6
   
      // test1 - create users from csv file
    public static boolean testAddUsersFromCsvFile(){
        System.out.println("Testing P2R6 Test1: testAddUsersFromCsvFile");  
        String filename = TestData.testUserReadFilename();
        TaskManager testTaskManager = new TaskManager();
        String[] csvLines =  TestData.testUsersData().split(System.lineSeparator());
        testTaskManager.readUsersFromCsvFile(filename);
        return  testTaskManager.getUser("1").toString().equals(csvLines[0]) && 
                testTaskManager.getUser("2").toString().equals(csvLines[1]);
      
        }
        
          // test2 - create taskd from csv file
    public static boolean testAddTasksFromCsvFile(){
        System.out.println("Testing P2R6 Test2: testAddTasksFromCsvFile");
        String filename = TestData.testTaskReadFilename();
        TaskManager testTaskManager = new TaskManager();
        String[] csvLines =  TestData.testTasksData().split(System.lineSeparator());
       // this time get the data from the file
       testTaskManager.readTasksFromCsvFile(filename);
        return testTaskManager.getTask("1").toString().equals(csvLines[0]) 
                && testTaskManager.getTask("2").toString().equals(csvLines[1]);
      
        }
    
     // test3 - create subtasks from csv file
    public static boolean testAddSubTasksFromCsvFile(){
        System.out.println("Testing P2R6 Test3: testAddSubTasksFromCsvFile");  
        String filename = TestData.testSubTaskReadFilename();
        TaskManager testTaskManager = new TaskManager();
        String[] csvLines =  TestData.testSubTasksData().split(System.lineSeparator());
        testTaskManager.readSubTasksFromCsvFile(filename);
        return  testTaskManager.getSubTask("11",1).toString().equals(csvLines[0]) && 
                testTaskManager.getSubTask("7", 1).toString().equals(csvLines[1]);
      
        }
    
     public static boolean testAssignStoredTasksToUsers(){
    // test4 - assign stored tasks to users 
     // after reading in the data stored in the test csv files
     // this relies on P2R6 Test1, P2R6 Test2, passing and so is not currently independent
     // really it requires pre-defined User and Task ArrayLists
       System.out.println("Testing P2R6 Test4: testAssignStoredTasksToUsers");
       TaskManager testTaskManager = new TaskManager();
       String userFilename = TestData.testUserReadFilename();
       String taskFilename = TestData.testTaskReadFilename();
       testTaskManager.readUsersFromCsvFile(userFilename);
       testTaskManager.readTasksFromCsvFile(taskFilename);
       testTaskManager.assignStoredTasks();
       
       // initially we will just test the total number of tasks for all the users in the test files
       // this should be 12
       int numTasks=0;
       int expectedTasks=12;
       for (User u: testTaskManager.getUsers()){
           numTasks+=u.getTasks().size();
       }
        return numTasks==expectedTasks;
     }
     
     
      public static boolean testAssignStoredSubTasksToTasks(){
    // test5 - assign stored sub-tasks to tasks
     // after reading in the data stored in the test csv files
     // this relies on P2R6 Test2, P2R6 Test3, passing and so is not currently independent
     // really it requires pre-defined User, and Task and ArrayLists
       System.out.println("Testing P2R6 Test5: testAssignStoredSubTasksToTasks");
       TaskManager testTaskManager = new TaskManager();
      
       String taskFilename = TestData.testTaskReadFilename();
       String subTaskFilename = TestData.testSubTaskReadFilename();
       
       testTaskManager.readTasksFromCsvFile(taskFilename);
       testTaskManager.readSubTasksFromCsvFile(subTaskFilename);
       testTaskManager.assignStoredSubTasks();
       
       // initially we will just test the total number of subtasks for all the tasks in the test files
       // this should be 14
       int numSubTasks=0;
       int expectedSubTasks=14;
       for (Task t: testTaskManager.getTasks()){
           numSubTasks+=t.getSubTasks().size();
       }
        return numSubTasks==expectedSubTasks;
     }
    
        
      // P2R7: Save User and Task/SubTasks to a local file
        // Also initially test it only by inspection i.e. looking at the file
          // test2 - create users from csv file
        public static void testWriteUsersToCsvFile(){
              System.out.println("Testing P2R7 Test 1: testWriteUsersToCsvFile");
        // initially just write to the NetBeans project directory
         
          String filename = TestData.testUserWriteFilename();
          TaskManager testTaskManager = new TaskManager();
          testTaskManager.addUser(testUser1);
          testTaskManager.addUser(testUser2);
           testTaskManager.writeUsersToCsvFile(filename);
       // not formally tested yet only by inspecion
        }
        
         // test2 - create users from csv file
        public static void testWriteTasksToCsvFile(){
              System.out.println("Testing P2R7 Test 2: testWriteTasksToCsvFile");
        // initially just write to the NetBeans project directory
         String filename = TestData.testTaskWriteFilename();
         TaskManager testTaskManager = new TaskManager();
          testTaskManager.addTask(testTask1);
          testTaskManager.addTask(testTask2);
          testTaskManager.writeTasksToCsvFile(filename);
       // not formally tested yet only by inspecion
        }
        
         // test2 - create users from csv file
        public static void testWriteSubTasksToCsvFile(){
              System.out.println("Testing P2R7 Test 3: testWriteSubTasksToCsvFile");
        // initially just write to the NetBeans project directory
         String filename = TestData.testSubTaskWriteFilename();
         TaskManager testTaskManager = new TaskManager();
          testTaskManager.addSubTask(testSubTask1);
          testTaskManager.addSubTask(testSubTask2);
          testTaskManager.writeSubTasksToCsvFile(filename);
       // not formally tested yet only by inspecion
        }
       
}
