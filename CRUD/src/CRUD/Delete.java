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
public class Delete {
    public static void main(String[] args) throws IOException {
//        mengambil database original
        File database = new File("Database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        
//       membuat database sementara 
        File tempDb = new File("tempDb.txt");
        FileWriter fileOutput = new FileWriter(tempDb);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
//        input no delete data
        Scanner inputUser = new Scanner(System.in);
        System.out.print("masukkan Usernam yang akan dihapus : ");
        String namaDelete = inputUser.nextLine();
        boolean isFound = false;
        
//        looping untuk membaca setiap data yang tidak hapus
        String data = bufferInput.readLine();
        while (data != null){
            StringTokenizer stringToken = new StringTokenizer(data, "@");
            String id = stringToken.nextToken();
            String password = stringToken.nextToken();
            String nama = stringToken.nextToken();
            
            boolean isDelete = false;
//            pisah data yang didelete
            if ((namaDelete.toLowerCase()).equals(id.toLowerCase())){
                isDelete = true;
                isFound = true;
            }
            
            if (isDelete){
                System.out.println("data berhasil dihapus");
            }else{
//                pindah data ke tempDb
                bufferOutput.write(data);
                bufferOutput.newLine();

            }
            data = bufferInput.readLine();
        }
        if(!isFound){
            System.err.println("nama tidak ditemukan");
        }
        
//        menulis data ke tempDb
        bufferOutput.flush();
        bufferOutput.close();
        bufferInput.close();
//      delete original database  
        database.delete();
//        rename temp ke original
        tempDb.renameTo(database);

    }
}
