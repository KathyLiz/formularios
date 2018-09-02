/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.mycompany.dataconverter.EchoServer;
import java.io.File;

/**
 *
 * @author Kathy
 */
public class DataConverterUtils {
    public static final String getAppPath()
    {
        String appPath = "";
        
        String path = EchoServer.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("path: " + path);

        if (path.endsWith(".jar") && !path.contains("Temp"))
            appPath = path.substring(0, path.lastIndexOf("/")) + File.separator;
        else
            appPath = System.getProperty("user.dir") + File.separator;
        
        return appPath;
    }
    
}
