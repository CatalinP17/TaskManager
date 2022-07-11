/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ku.pii2020.taskmanager.model.SubTask;
import ku.pii2020.taskmanager.model.Task;
import ku.pii2020.taskmanager.model.TaskManager;
import ku.pii2020.taskmanager.model.User;

/**
 *
 * @author petre
 */
public class TextAreaPanel extends JPanel implements ActionListener  {

    private JTextArea textDisplay = new JTextArea();
    
    private JTextField userField = new JTextField();
  
    private JButton userButton = new JButton("Add Row");
  
    /**
     * Get the value of userButton
     *
     * @return the value of userButton
     */
    public JButton getUserButton() {
        return userButton;
    }

    /**
     * Set the value of userButton
     *
     * @param userButton new value of userButton
     */
    public void setUserButton(JButton userButton) {
        this.userButton = userButton;
    }

    /**
     * Get the value of userField
     *
     * @return the value of userField
     */
    public JTextField getUserField() {
        return userField;
    }

    /**
     * Set the value of userField
     *
     * @param userField new value of userField
     */
    public void setUserField(JTextField userField) {
        this.userField = userField;
    }
    /**
     * Get the value of textDisplay
     *
     * @return the value of textDisplay
     */
    public JTextArea getTextDisplay() {
        return textDisplay;
    }

    /**
     * Set the value of textDisplay
     *
     * @param textDisplay new value of textDisplay
     */
    public void setTextDisplay(JTextArea textDisplay) {
        this.textDisplay = textDisplay;
    }

    public TextAreaPanel() {
        super();
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(textDisplay), BorderLayout.CENTER);
        userButton.addActionListener(this);
        this.add(userButton, BorderLayout.EAST);
        this.add(userField, BorderLayout.SOUTH);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        User u = new User(user);
        TaskManager.addUser(u);
        TaskManager.displayUsers();
        
        String task = userField.getText();
        Task t = new Task(task);
        TaskManager.addTask(t);
        TaskManager.displayTasks();
        
        String subTask = userField.getText();
        SubTask s = new SubTask(subTask);
        TaskManager.addSubTask(s);
        TaskManager.displaySubTasks();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
