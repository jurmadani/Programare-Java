package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void scriereCartiInFisier(Map<Integer,Carte> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer,Carte> citesteCartiDinFisier() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            Map<Integer,Carte> listaCarti = mapper.readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return listaCarti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Map<Integer, Carte> colectieCarti = citesteCartiDinFisier();
        Scanner s = new Scanner(System.in);

        //cerinta 1)
        colectieCarti.forEach((integer, carte) -> System.out.println(integer + "" + carte));
        //cerinta 2)
        System.out.println("Cheia pe care o doreti sa o stergi din map: ");
        int keyToPassToRemoveFunction = s.nextInt();
        colectieCarti.remove((keyToPassToRemoveFunction));
        System.out.println("Obiectul cu cheia " + keyToPassToRemoveFunction + " a fost sters din map");
        //cerinta 3)
        System.out.println("\n");
        colectieCarti.putIfAbsent(keyToPassToRemoveFunction,new Carte("Ursul pacalit de vulpe","Bacovia", 1300));
        System.out.println("O noua carte a fost introdusa");
        //cerinta 4)
        System.out.println("\n");
        scriereCartiInFisier(colectieCarti);
        System.out.println("Noua colectie a fost scrisa in fisierul json");
        //cerinta 5)
        System.out.println("\n");
        Set<Carte> cartiYuval = colectieCarti.entrySet().stream()
                .filter(entry ->entry.getValue().autorul().equals("Yuval Noah Harari"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
        cartiYuval.forEach(carte -> System.out.println(carte));
        //cerinta 6)
        System.out.println("\n");
        cartiYuval.stream().sorted((a,b) -> a.titlul().compareTo(b.t    itlul())).forEach(System.out::println);
        //cerinta 7)
        System.out.println("\n");
        Optional<Carte> ceaMaiVecheCarte = cartiYuval.stream()
                .min(Comparator.comparingInt(Carte::anul));

        ceaMaiVecheCarte.ifPresent(carte -> {
            System.out.println("Cea mai veche carte:");
            System.out.println(carte);
        });


    }
}