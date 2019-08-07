/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestApplication;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Kelly
 */
public class TestApplication {
    static String DELIMITER = "|";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws FileNotFoundException, UnsupportedEncodingException, IOException {       
        Scanner lineReader = new Scanner(new FileReader("C:\\Users\\Kelly\\Documents\\NetBeansProjects\\qanda\\src\\questions.txt")); 
        // id, parent 
        HashMap<String, String> parentAndID = new HashMap<>(); 
        // parent id, child strings 
        HashMap<String, ArrayList<String>> rootAndChildPosts = new HashMap<>(); 
        int counter = 0; 
        int idLoc = -1; 
        int parentIDLoc = -1; 
        int threadIDLoc = -1; 
        int expertLoc = -1; 
        int bodyLoc = -1; 
        
        while(lineReader.hasNextLine()) { 
            String line = lineReader.nextLine(); 
            String[] splitLine = line.split(DELIMITER); 
            
            // Header locations
            if (counter == 0) { 
                int loc = 0; 
                for (String a : splitLine) { 
                    if (a.equals("id")) { 
                        idLoc = loc; 
                    } else if (a.equals("replied_to_id")) { 
                        parentIDLoc = loc; 
                    } else if (a.equals("thread_id")) { 
                        threadIDLoc = loc; 
                    } else if (a.equals("Expert answer?")) {
                        expertLoc = loc; 
                    } else if (a.equals("body")) { 
                        bodyLoc = loc; 
                    }
                    
                    loc++; 
                
                }
                counter++; 
                continue; 
            }
            
            // Add as parent 
            if (splitLine[parentIDLoc] == "") { 
                parentAndID.put(splitLine[threadIDLoc], splitLine[bodyLoc]); 
                rootAndChildPosts.put(splitLine[threadIDLoc], new ArrayList<>()); 
            // Add as child only if it is an expert answer 
            } else if (splitLine[expertLoc] != "N"){ 
                rootAndChildPosts.get(splitLine[threadIDLoc]).add(splitLine[bodyLoc]); 
            }
            
        }
        
        String[] keywords = {"spider", "clas"}; 
        String fileName = "TestYammerOutput"; 
        
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for (String a : parentAndID.keySet()) { 
            String lower = a.toLowerCase(); 
            
            for (String b : keywords) { 
                if (lower.contains(b)) { 
                    // TODO: create the line 
                    String output = "holder, place line here";
                    System.out.println(output);
                    out.println(output); 
                    }
                }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
