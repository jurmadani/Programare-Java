import java.io.Serializable;

enum format_copiere {
    A3, A4
}

public class Copiator extends Echipament implements Serializable {
    public int p_ton;
    public format_copiere format_copiere;

    public Copiator(){

    }
   public Copiator(String _denumire, int _nr_inv, int _pret, String _zona_mag, situatie _situatie, int _p_ton, format_copiere _format_copiere) {
        super(_denumire, _nr_inv, _pret, _zona_mag, _situatie);
        this.p_ton = _p_ton;
        this.format_copiere = _format_copiere;
    }


}

