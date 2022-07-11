/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.view;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author petre
 */
public class CSVFileChooserFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.getName().endsWith(".csv");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String getDescription() {
        return "CSV Files";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
