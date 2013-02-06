package org.kieda.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * a nice way of reading an entire file into a single String.
 * @author kieda
 */
public class ReadFile {
    public static String read(File f){
        String l = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String c;
            while((c=br.readLine())!=null){
                l+=c+"\n";
            }
        } catch (Exception ex) {}
        return l;
    }
}
