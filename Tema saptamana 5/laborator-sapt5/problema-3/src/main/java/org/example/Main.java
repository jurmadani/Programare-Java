package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void scriere(ArrayList<PerecheNumere> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/persoane.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<PerecheNumere> citire() {
        try {
            File file=new File("src/main/resources/persoane.json");
            ObjectMapper mapper=new ObjectMapper();
            ArrayList<PerecheNumere> lista = mapper.readValue(file, new TypeReference<ArrayList<PerecheNumere>>(){});
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        ArrayList<PerecheNumere> lista = new ArrayList<PerecheNumere>();
        lista.add(new PerecheNumere(144,233));
        lista.add(new PerecheNumere(11,20));
        lista.add(new PerecheNumere(5,5));


        System.out.println(lista);
        for(PerecheNumere p:lista){
            System.out.println(p);
        }
        scriere(lista);
        System.out.println("Verifica daca 2 numere sunt consecutive");
        //verifica daca 2 nr sunt consecutive in sirul lui fibonacci
       for(PerecheNumere p : lista){
           System.out.println(p.checkIfNumbersAreFibonacciGroup());
       }
    //returneaza cmmdc
        System.out.println("CMMDC pentru perechile de numere:");
        for(PerecheNumere p : lista){
            System.out.println(p.cmmdc());
        }
        //suma cifrelor egala
        System.out.println("Suma cifrelor egala:");
        for(PerecheNumere p : lista){
            System.out.println(p.sumaCifrelorEgala());
        }
        //suma cifrelor egala
        System.out.println("Numarul cifrelor pare:");
        for(PerecheNumere p : lista){
            System.out.println(p.nrCifrelorPareEgala());
        }
    }
}