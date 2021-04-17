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
public class Tambah {
    public static void main(String[] args) throws IOException {
//        koneksi database
        FileWriter fileOutput = new FileWriter("Database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
//        inputan user
        Scanner inputUser = new Scanner(System.in);
        String id, password, nama;
        
        System.out.print("Masukkan Username Pengguna : ");
        id = inputUser.nextLine();
        System.out.print("Masukkan Password Pengguna : ");
        password = inputUser.nextLine();
        System.out.print("masukkan nama pengguna : ");
        nama = inputUser.nextLine();        
        
//        cek apakah ada id yang sama
        boolean cekUser = cekIdUser(id);
        
//        jika tidak ada maka tambah data jika ada maka akan meinput ulang
        if (!cekUser) {
            bufferOutput.write(id + "@" + password + "@" + nama);
            bufferOutput.newLine();
            bufferOutput.flush();
        }else{
            System.out.println("data id sudah ada mohon gunakan yang lain");
        }
        
        bufferOutput.close();
    }
    private static boolean cekIdUser(String id) throws IOException{
//         membaca database
        FileReader fileInput;
        BufferedReader bufferInput;
        try{
            fileInput = new FileReader("Database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch(IOException e){
            System.err.println("Database tidak ditemukan");
            System.err.println("silahkan tambah data");
            return false;
        }
        
//        membaca data perbabaris
        String data;
        while((data = bufferInput.readLine()) != null){
            ArrayList<String> list = new ArrayList<>();
//          membaca data berdasarkan delimiter
            String[] token = data.split("@");

            for (String tokens : token){
                list.add(tokens);
            }
            
//           cek jika ada yang sama maka harus diganti
            if((list.get(0).equals(id))){
                System.out.println(list.get(0));
                return true;
            }
        }
        bufferInput.close();
        return false;
    }
}
