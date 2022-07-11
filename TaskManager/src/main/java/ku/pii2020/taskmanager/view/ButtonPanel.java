/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import ku.pii2020.taskmanager.model.TaskManager;

/**
 *
 * @author petre
 */
public class ButtonPanel extends JPanel implements ActionListener {

    private JButton loadUser = new JButton("Load User");
    private JButton loadTask = new JButton("Load Task");
    private JButton loadSubTask = new JButton("Load SubTask");
    private JButton clearData = new JButton("Clear Data");
    private JButton quitViewer = new JButton("Quit Viewer");

    public ButtonPanel() {
        super();
        this.setLayout(new FlowLayout());
        loadUser.addActionListener(this);
        loadUser.setActionCommand("loadUser");
        loadTask.addActionListener(this);
        loadTask.setActionCommand("loadTask");
        loadSubTask.addActionListener(this);
        loadSubTask.setActionCommand("loadSubTask");
        clearData.addActionListener(this);
        clearData.setActionCommand("clearData");
        quitViewer.addActionListener(this);
        quitViewer.setActionCommand("quitViewer");
        this.add(loadUser);
        this.add(loadTask);
        this.add(loadSubTask);
        this.add(clearData);
        this.add(quitViewer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "loadUser":
                System.out.println("loadUser Button Clicked");
                TaskManager.readUsersFromCsvFile("users.csv");
                TaskManager.displayUsers();
                break;
            case "loadTask":
                System.out.println("loadTask Button Clicked");
                TaskManager.readTasksFromCsvFile("tasks.csv");
                TaskManager.displayTasks();
                break;
            case "loadSubTask":
                System.out.println("loadSubTask Button Clicked");
                TaskManager.readSubTasksFromCsvFile("subtasks.csv");
                TaskManager.displaySubTasks();
                break;
            case "clearData":
                System.out.println("clearData Button Clicked");
                TaskManager.clearTables();
                break;  
            case "quitViewer":
                System.out.println("quitViewer Button Clicked");
                System.exit(0);
                break;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
