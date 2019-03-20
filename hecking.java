/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qanda;

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
import java.util.Scanner;



/**
 *
 * @author Kelly
 */
public class Qanda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws FileNotFoundException, UnsupportedEncodingException, IOException {
        ArrayList<String> questions = new ArrayList<>(); 
        ArrayList<String> answers = new ArrayList<>();
        Scanner questionReader = new Scanner(new FileReader("C:\\Users\\Kelly\\Documents\\NetBeansProjects\\qanda\\src\\questions.txt")); 
        Scanner answerReader = new Scanner(System.in); 
        
        while(questionReader.hasNextLine()) { 
            String q = questionReader.nextLine(); 
            questions.add(q); 
            System.out.println(q);
            String a = answerReader.next(); 
            answers.add(a); 
        }
        
        String fileName = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                .format(new Date())) + ".txt";
        
        try(FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for(int i = 0; i < answers.size(); i++) { 
                String q = questions.get(i); 
                String a = answers.get(i);
                System.out.println(a);
                out.println(q);
                out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
