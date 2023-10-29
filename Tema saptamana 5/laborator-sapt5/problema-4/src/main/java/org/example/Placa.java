package org.example;

enum Orientare {
    LUNGIME,
    LATIME,
    ORICARE
}
public class Placa {
    public String descriere;
    public int lungime;
    public int latime;
    public Orientare orientare;
    public boolean[] canturi;
    public int nr_bucati;
    public Placa(String _descriere, int _lungime, int _latime, Orientare _orientare, boolean[] _canturi, int _nr_bucati){
        this.descriere = _descriere;
        this.lungime = _lungime;
        this.latime = _latime;
        this.orientare = _orientare;
        this.canturi = _canturi;
        this.nr_bucati = _nr_bucati;
    }
    public Placa(){}
    public void afisareInformatiiPlaca(){
        System.out.println("Descriere: " + this.descriere);
        System.out.println("Lungime: " + this.lungime );
        System.out.println("Latime: " + this.latime);
        System.out.println("Orientare: " + this.orientare);
        System.out.println("Canturi: ");
        for(boolean iterator: this.canturi){
            System.out.println(iterator);
        }
        System.out.println("Numar bucati: " + this.nr_bucati);
        System.out.println("--------------------------------------------");
    }
}
