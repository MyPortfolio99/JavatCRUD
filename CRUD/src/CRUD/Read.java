/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.io.*;
import java.util.*;

/**
 *
 * @author Acer
 */
public class Read {
    public static void main(String[] args) throws IOException {
//        membaca database
        FileReader fileInput;
        BufferedReader bufferInput;
        try{
            fileInput = new FileReader("Database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch(IOException e){
            System.err.println("Database tidak ditemukan");
            System.err.println("silahkan tambah data");
            return;
        }
        
//        membaca data perbabaris
        String data = bufferInput.readLine();
        
//        menampilkan data
        System.out.println("| No |\t ID              |\t Password             |\t Nama                      |");
        System.out.println("|----------------------------------------------------------------------------------|");
        
        Integer No = 0;
        while(data != null){
            No++;
//            membaca data berdasarkan delimiter
            StringTokenizer stringToken = new StringTokenizer(data, "@");
            
//            menampilkan data
            String id = stringToken.nextToken();
            String password = stringToken.nextToken();
            String nama = stringToken.nextToken();
            System.out.printf("| %2d " , No);
            System.out.printf("|\t %-15s " , id);
            System.out.printf("|\t %-20s " , password);
            System.out.printf("|\t %-25s |" , nama);
            System.out.print("\n");
            
            data = bufferInput.readLine();
        }
        System.out.println("|----------------------------------------------------------------------------------|");
        bufferInput.close();
    }
}
