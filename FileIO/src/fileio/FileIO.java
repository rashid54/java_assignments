/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author rsd
 */
public class FileIO {

    public static void main(String[] args) {
        String a;
        BufferedReader br = null;
        BufferedWriter writer=null;
        try {
            br = new BufferedReader(new FileReader("rashid.txt"),10);
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write('\n');
            String s;
            String word;
            int count ;
            while((s = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(s," ?."); 
                String str= new String();
                while(st.hasMoreTokens())
                {
                    word=st.nextToken();
                    count= 1;
                    while(st.hasMoreTokens())
                    {
                        String nxtword=st.nextToken();
                        if(nxtword.equals(word))
                        {
                            count++;
                        }
                        else
                        {
                            str= str + nxtword + " " ;
                        }
                    }
                    System.out.println("'" + word + "'" + " is " + count + " times.");
                    writer.append("'" + word + "'" + " is " + count + " times.\n");
                    st = new StringTokenizer(str," ?.");
                    str= new String();
                }
                }
                writer.close();
            }catch(IOException e) {
            e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
    }
    
}
