/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Deklarasi
        Scanner cin = new Scanner(System.in);
        boolean loop = true;
        Teman teman = new Teman();
        // Deskripsi
        do{
            System.out.println("MENU");
            System.out.println("1. Tampil Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.print("Masukan [0-4]: ");

            switch(Integer.valueOf(cin.nextLine())){
                case 0 : {
                    loop = false; 
                    System.out.println("\nTerimakasih..!!");
                    break;
                }
                case 1 : {
                    // show data
                    teman.showData();
                    break;
                }
                case 2 : {
                    teman.addData();
                    break;
                }
                case 3 : {
                    teman.updData();
                    break;
                }
                case 4 : {
                    teman.delData();
                    break;
                }
                default : break;
            }

        } while(loop);
    }
}
