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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import ku.pii2020.taskmanager.model.Task;
import ku.pii2020.taskmanager.model.TaskManager;

/**
 *
 * @author petre
 */
public class TablePanel extends JPanel implements ListSelectionListener, ActionListener {

    private JTable tableArea = new JTable();
    private Object[] columnNames;
    private Object[][] columnRows;
    private DefaultTableModel dtm;
    
    private JButton deleteSelected = new JButton("Delete Selected");
    
    public JButton getDeleteSelected() {
        return deleteSelected;
    }

    public void setDeleteSelected(JButton deleteSelected) {
        this.deleteSelected = deleteSelected;
    }
    
       
    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }

    public Object[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(Object[] columnNames) {
        this.columnNames = columnNames;
    }

    public Object[][] getColumnRows() {
        return columnRows;
    }

    public void setColumnRows(Object[][] columnRows) {
        this.columnRows = columnRows;
    }
    
    public TablePanel (Object[][] columnRows, Object[] columnNames) {
        super();
        this.setLayout(new BorderLayout());
        this.columnRows = columnRows;
        this.columnNames = columnNames;
        deleteSelected.addActionListener(this);
        deleteSelected.setActionCommand("deleteSelected");
        dtm = new DefaultTableModel(columnRows, columnNames);
        tableArea = new JTable(dtm);
        this.add(new JScrollPane(tableArea), BorderLayout.CENTER);
        this.add(deleteSelected, BorderLayout.SOUTH);
        
    }
    public JTable getTableArea () {
        return tableArea;
    }

    public void setTableArea(JTable tableArea) {
        this.tableArea = tableArea;
    }
    
    public TablePanel() {
        super();
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tableArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tableArea.getSelectedRow() != -1) {
            System.out.println("Delete Selected Button Clicked");
            System.out.println(tableArea.getSelectedRow());
            TaskManager.removeTask(tableArea.getSelectedRow());
            TaskManager.displayTasks();
            TaskManager.removeUser(tableArea.getSelectedRow());
            TaskManager.displayUsers();
            TaskManager.removeSubTask(tableArea.getSelectedRow());
            TaskManager.displaySubTasks();
        }     
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
