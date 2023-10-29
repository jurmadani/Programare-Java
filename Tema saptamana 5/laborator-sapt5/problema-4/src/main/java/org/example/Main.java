package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // a) + b) Afișarea datelor despre piesele de mobilier
        ArrayList<Mobilier> mobilierList = citire();
        assert mobilierList != null;
        for(Mobilier iterator: mobilierList){
            iterator.afisareInformatii();
        }
        //c)
        System.out.println("Cerinta c)");
        afisareCaracteristiciPlaciPentruPiesa(mobilierList, "dulap 1");
        // d)
        float numarColiNecesare = calculNumarColiPentruCorpMobilier(mobilierList, "mobilier corp 1");
        System.out.println("Estimativ numărul de coli de pal necesare pentru birou: " + numarColiNecesare);


    }

    public static ArrayList<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            ArrayList<Mobilier> lista = mapper.readValue(file, new TypeReference<ArrayList<Mobilier>>(){});
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisareCaracteristiciPlaciPentruPiesa(ArrayList<Mobilier> mobilierList, String numePiesa) {
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.nume.equals(numePiesa)) {
                System.out.println("Caracteristici plăci pentru piesa " + numePiesa);
                for (Placa placa : mobilier.placi) {
                   placa.afisareInformatiiPlaca();
                }
                break;
            }
        }
    }

    public static float calculNumarColiPentruCorpMobilier(ArrayList<Mobilier> mobilierList, String numePiesa) {
        float numarColi = 0;
        for (Mobilier mobilier : mobilierList) {
            if (mobilier.nume.equals(numePiesa)) {
                for (Placa placa : mobilier.placi) {
                    // Calculați numărul de coli necesare pe baza dimensiunilor plăcilor și numărului de bucăți
                    float ariePlaca = placa.lungime * placa.latime;
                    numarColi += (ariePlaca * placa.nr_bucati) / (2800 * 2070);


                }
                break;
            }
        }
        return numarColi;
    }
}

