/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dnitarea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class DNITarea {

    /**
     * @param args the command line arguments
     */
    
    private static String dnisOk = "";
    private static String dnisNotOk = "";
    public static void main(String[] args) {
            File f = new File("dnis.txt");
        try {
            Scanner sc = new Scanner(f);
            boolean ok;
            String lineaActual;
            while(sc.hasNextLine()){
                lineaActual = sc.nextLine();
                ok = validarDNI(lineaActual);
                if (ok) {
                    dnisOk += lineaActual + "\n";
                }else{
                    dnisNotOk += lineaActual + "\n";
                }
            }
            escribirArchivos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DNITarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean validarDNI(String dni){
        boolean ok = true;
        char actualChar;
        int sumaNumeros = 0;
        if (dni.length() == 9) {
            for (int i = 0; i < 8; i++) {
                actualChar = dni.charAt(i);
                if (Character.isDigit(actualChar)) {
                    sumaNumeros += Character.valueOf(actualChar);
                }else{
                    ok = false;
                    break;
                }
            }
            if (ok) {
                actualChar = dni.charAt(8);
                int correctNumber = sumaNumeros%23;
                if (!isCorrectLetter(actualChar, correctNumber)) {
                    ok = false;
                }
            }
        }else{
            ok = false;
        }
        return ok;
    }
    public static void escribirArchivos(){
        File okFile = new File("./dniok.txt");
        try(FileWriter okFw = new FileWriter(okFile, false);) {
            okFw.write(dnisOk);
        } catch (IOException ex) {
            Logger.getLogger(DNITarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        File notOkFile = new File("./dninotok.txt");
        try(FileWriter notOkFw = new FileWriter(notOkFile, false);) {
            notOkFw.write(dnisNotOk);
        } catch (IOException ex) {
            Logger.getLogger(DNITarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static boolean isCorrectLetter(char letra, int numero){
        if (letra == 'A') {
            return numero == 3;
        }else if (letra == 'B') {
            return numero == 11;
        }else if (letra == 'C') {
            return numero == 20;
        }else if (letra == 'D') {
            return numero == 9;
        }else if (letra == 'E') {
            return numero == 22;
        }else if (letra == 'F') {
            return numero == 7;
        }else if (letra == 'G') {
            return numero == 4;
        }else if (letra == 'H') {
            return numero == 18;
        }else if (letra == 'J') {
            return numero == 13;
        }else if (letra == 'K') {
            return numero == 21;
        }else if (letra == 'L') {
            return numero == 19;
        }else if (letra == 'M') {
            return numero == 5;
        }else if (letra == 'N') {
            return numero == 12;
        }else if (letra == 'P') {
            return numero == 8;
        }else if (letra == 'Q') {
            return numero == 16;
        }else if (letra == 'R') {
            return numero == 1;
        }else if (letra == 'S') {
            return numero == 15;
        }else if (letra == 'T') {
            return numero == 0;
        }else if (letra == 'V') {
            return numero == 17;
        }else if (letra == 'W') {
            return numero == 2;
        }else if (letra == 'X') {
            return numero == 10;
        }else if (letra == 'Y') {
            return numero == 6;
        }else if (letra == 'Z') {
            return numero == 14;
        }else{
            return false;
        }
    }
}
