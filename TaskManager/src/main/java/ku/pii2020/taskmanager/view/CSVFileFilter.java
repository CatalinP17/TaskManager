/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.taskmanager.view;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author petre
 */
public class CSVFileFilter implements FileFilter {

    
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".csv");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
