/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import ku.pii2020.taskmanager.model.TaskManager;

/**
 *
 * @author petre
 */
public class DataViewer extends JFrame implements ActionListener {

    private TextAreaPanel userPanel = new TextAreaPanel();
    private TextAreaPanel userCsvPanel = new TextAreaPanel();
    private TablePanel userTable = new TablePanel((Object[][]) TaskManager.getUserRowData(), TaskManager.getUserColumnHeaders());
    private TextAreaPanel taskPanel = new TextAreaPanel();
    private TextAreaPanel taskCsvPanel = new TextAreaPanel();
    private TablePanel taskTable = new TablePanel((Object[][]) TaskManager.getTaskRowData(), TaskManager.getTaskColumnHeaders());
    private TextAreaPanel subTaskPanel = new TextAreaPanel();
    private TextAreaPanel subTaskCsvPanel = new TextAreaPanel();
    private TablePanel subTaskTable = new TablePanel((Object[][]) TaskManager.getSubTaskRowData(), TaskManager.getSubTaskColumnHeaders());
    

    public TextAreaPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(TextAreaPanel userPanel) {
        this.userPanel = userPanel;
    }

    public TextAreaPanel getUserCsvPanel() {
        return userCsvPanel;
    }

    public void setUserCsvPanel(TextAreaPanel userCsvPanel) {
        this.userCsvPanel = userCsvPanel;
    }

    public TextAreaPanel getTaskPanel() {
        return taskPanel;
    }

    public void setTaskPanel(TextAreaPanel taskPanel) {
        this.taskPanel = taskPanel;
    }

    public TextAreaPanel getTaskCsvPanel() {
        return taskCsvPanel;
    }

    public void setTaskCsvPanel(TextAreaPanel taskCsvPanel) {
        this.taskCsvPanel = taskCsvPanel;
    }

    public TextAreaPanel getSubTaskPanel() {
        return subTaskPanel;
    }

    public void setSubTaskPanel(TextAreaPanel subTaskPanel) {
        this.subTaskPanel = subTaskPanel;
    }

    public TextAreaPanel getSubTaskCsvPanel() {
        return subTaskCsvPanel;
    }

    public void setSubTaskCsvPanel(TextAreaPanel subTaskCsvPanel) {
        this.subTaskCsvPanel = subTaskCsvPanel;
    }

    public TablePanel getSubTaskTable() {
        return subTaskTable;
    }

    public void setSubTaskTable(TablePanel subTaskTable) {
        this.subTaskTable = subTaskTable;
    }

    public TablePanel getUserTable() {
        return userTable;
    }

    public void setUserTable(TablePanel userTable) {
        this.userTable = userTable;
    }

    /**
     * Get the value of tableArea
     *
     * @return the value of tableArea
     */
    public TablePanel getTaskTable() {
        return taskTable;
    }

    /**
     * Set the value of tableArea
     *
     * @param tableArea new value of tableArea
     */
    public void setTaskTable(TablePanel taskTable) {
        this.taskTable = taskTable;
    }
    
    private JTabbedPane tabPane = new JTabbedPane();

    /**
     * Get the value of tabPane
     *
     * @return the value of tabPane
     */
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    /**
     * Set the value of tabPane
     *
     * @param tabPane new value of tabPane
     */
    public void setTabPane(JTabbedPane tabPane) {
        this.tabPane = tabPane;
    }

    private ButtonPanel buttonPanel = new ButtonPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem loadCSVFile = new JMenuItem("Load File");
    private JMenuItem openFile = new JMenuItem("Open File");
    private JMenuItem saveFile = new JMenuItem("Save File");
    private JFileChooser csvChoose = new JFileChooser(System.getProperty("user.dir"));

    /**
     * Get the value of buttonPanel
     *
     * @return the value of buttonPanel
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    /**
     * Set the value of buttonPanel
     *
     * @param buttonPanel new value of buttonPanel
     */
    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
    
    private JTextArea taskDisplay = new JTextArea();

    /**
     * Get the value of taskDisplay
     *
     * @return the value of taskDisplay
     */
    public JTextArea getTaskDisplay() {
        return taskDisplay;
    }

    /**
     * Set the value of taskDisplay
     *
     * @param taskDisplay new value of taskDisplay
     */
    public void setTaskDisplay(JTextArea taskDisplay) {
        this.taskDisplay = taskDisplay;
    }

    public DataViewer() {
        super("Data Viewer");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        tabPane.add(userPanel, "Users: Print view");
        tabPane.add(userCsvPanel, "Users: CSV view");
        tabPane.add(userTable, "Users: Table view");
        tabPane.add(taskPanel, "Tasks: Print view");
        tabPane.add(taskCsvPanel, "Tasks: CSV view");
        tabPane.add(taskTable, "Tasks: Table view");
        tabPane.add(subTaskPanel, "SubTasks: Print view");
        tabPane.add(subTaskCsvPanel, "SubTasks: CSV view");
        tabPane.add(subTaskTable, "SubTasks: Table view");
        menuBar.add(fileMenu);
        fileMenu.add(openFile);
        fileMenu.add(loadCSVFile);
        fileMenu.add(saveFile);
        this.add(menuBar, BorderLayout.NORTH);
        openFile.addActionListener(this);
        openFile.setActionCommand("openFile");
        loadCSVFile.addActionListener(this);
        loadCSVFile.setActionCommand("loadCSVFile");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("saveFile");
        csvChoose.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        this.add(tabPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "openFile":
                System.out.println("Open File Menu Item Clicked");
                int userResponse = csvChoose.showOpenDialog(this);
                if( userResponse == JFileChooser.APPROVE_OPTION) {
                    System.out.println("User chose: " + csvChoose.getSelectedFile().toString());
                    TaskManager.readUsersFromCsvFile(csvChoose.getSelectedFile().toString());
                    TaskManager.readTasksFromCsvFile(csvChoose.getSelectedFile().toString());
                    TaskManager.readSubTasksFromCsvFile(csvChoose.getSelectedFile().toString());
                    TaskManager.displayUsers();
                    TaskManager.displayTasks();
                    TaskManager.displaySubTasks();
                }
                else {
                    System.out.println("Open file dialog cancelled");
                }
                break;
            case "saveFile":
                System.out.println("Save File Menu Item Clicked");
                int userResponses = csvChoose.showSaveDialog(this);
                if ( userResponses == JFileChooser.APPROVE_OPTION) {
                    System.out.println("User chose: " + csvChoose.getSelectedFile().toString());
                    TaskManager.writeUsersToCsvFile(csvChoose.getSelectedFile().toString());
                    //TaskManager.writeTasksToCsvFile(csvChoose.getSelectedFile().toString());
                    //TaskManager.writeSubTasksToCsvFile(csvChoose.getSelectedFile().toString());
                }
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
        //thr
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
