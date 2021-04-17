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
public class Update {
    public static void main(String[] args) throws IOException {
//        mengambil database original
        File database = new File("Database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferInput = new BufferedReader(fileInput);

        
//       membuat database sementara 
        File tempDb = new File("tempDb.txt");
        FileWriter fileOutput = new FileWriter(tempDb);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
//        inputan dari user
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Masukkan id yang akan diubah : ");
        String userId = inputUser.nextLine();
        
//        pilih data yang akan diupdate
        String data = bufferInput.readLine();
        while(data != null){
            StringTokenizer stringToken = new StringTokenizer(data, "@");
            
            String id = stringToken.nextToken();
            String password = stringToken.nextToken();
            String nama = stringToken.nextToken();
            
            if(id.equals(userId)){
//            update data
             
//              mengambil inputan dari user data yang diupdate
              String[] dataFields = {"id", "password", "nama"};
              String[] tempData = new String[3];
              
              for (int i = 0 ; i < dataFields.length; i++){
                  
                  System.out.print("masukkan " + dataFields[i] + " baru : ");
                  String updateInput =  inputUser.nextLine();
                  tempData[i] = updateInput;;
                  
              }
            bufferOutput.write(tempData[0] + "@" + tempData[1] + "@" + tempData[2]);
            bufferOutput.newLine();
                
            }else{
//                pindah data
                bufferOutput.write(data);
                bufferOutput.newLine();
            }
            
            data = bufferInput.readLine();
        }
        bufferOutput.flush();
        bufferOutput.close();
        bufferInput.close();
//      delete original database  
        database.delete();
//        rename temp ke original
        tempDb.renameTo(database);
 
    }
}
