enum situatie {
    achizitionat, expus, vandut
}

public class Echipament {
    public String denumire;
    public int nr_inv;
    public int pret;
    public String zona_mag;
    public situatie situatie;

    public Echipament(){

    };
    public Echipament(String _denumire, int _nr_inv, int _pret, String _zona_mag, situatie _situatie) {
        this.denumire = _denumire;
        this.nr_inv = _nr_inv;
        this.pret = _pret;
        this.zona_mag = _zona_mag;
        this.situatie = _situatie;
    }
}

