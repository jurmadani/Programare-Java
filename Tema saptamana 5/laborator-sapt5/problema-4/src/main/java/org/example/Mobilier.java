package org.example;
import java.util.ArrayList;
public class Mobilier {
    public String nume;
    public ArrayList<Placa> placi;
    public Mobilier(String _nume, ArrayList<Placa> _placi){
        this.nume = _nume;
        this.placi = _placi;
    }
    public Mobilier(){}
    public void afisareInformatii(){
        System.out.println("Nume: " + this.nume);
        for(Placa iterator:placi){
            iterator.afisareInformatiiPlaca();
        }
    }
}
