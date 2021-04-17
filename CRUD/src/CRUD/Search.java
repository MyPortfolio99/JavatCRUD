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
public class Search {
    public static void main(String[] args) throws Exception {
//        membaca database
        try{
            File file = new File("Database.txt");
        } catch(Exception e){
            System.err.println("Database tidak ditemukan");
            System.err.println("silahkan tambah data");
            return;
        }
//        ambil inputan dari user
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukkan nama yang akan dicari : ");
        String inputUser = userInput.nextLine();
        
//        cek database
        cekData(inputUser);
    }
    private static void cekData(String keyword) throws IOException{
        FileReader fileInput;
        BufferedReader bufferInput;
//        konkesi database
        try {
            fileInput = new FileReader("Database.txt");
            bufferInput = new BufferedReader(fileInput);
            
            String data = bufferInput.readLine();
        System.out.println("| ID              | Password             | Nama                      |");
        System.out.println("|--------------------------------------------------------------------|");
//        cari data perbaris
            while(data != null){
//                 cek delimiter
                StringTokenizer stringToken = new StringTokenizer(data, "@");
                
                String ID = stringToken.nextToken();
                String Password = stringToken.nextToken();
                String Nama = stringToken.nextToken();
//               tampilkan data jika sesuai keyowrd
                if(keyword.toLowerCase().contains(ID.toLowerCase())){
                    System.out.printf("| %-15s " , ID);
                    System.out.printf("| %-20s " , Password);
                    System.out.printf("| %-25s |" , Nama);
                    System.out.print("\n");
                }
                
                data = bufferInput.readLine();
            }
            System.out.println("|--------------------------------------------------------------------|");
        } catch (IOException e) {
            System.err.println("Database tidak ditemukan");
            System.err.println("silahkan tambah data");
            return;
        }
        bufferInput.close();
    }
}
