import java.io.Serializable;

enum mod_tiparire {
    color, albnegru,
}

public class Imprimanta extends Echipament implements Serializable {
    public int ppm;
    public String rezolutie;
    public int p_car;

    public mod_tiparire mod_tiparire;

    public Imprimanta(){
        //default constructor for deserialization
    }
    public Imprimanta(String _denumire, int _nr_inv, int _pret, String _zona_mag, situatie _situatie, int _ppm, String _rezolutie, int _p_car, mod_tiparire _mod_tiparire) {
        super(_denumire, _nr_inv, _pret, _zona_mag, _situatie);
        this.ppm = _ppm;
        this.rezolutie = _rezolutie;
        this.p_car = _p_car;
        this.mod_tiparire = _mod_tiparire;
    }

}
