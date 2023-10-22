import java.io.Serializable;

enum sistem_operare {
    windows, linux
}

public class SistemCalcul extends Echipament implements Serializable {
    public String tip_mon;
    public String vit_proc;
    public int c_hdd;
    public sistem_operare sistem_operare;

    public SistemCalcul(){

    }
    public SistemCalcul(String _denumire, int _nr_inv, int _pret, String _zona_mag, situatie _situatie, String _tip_mon, String _vit_proc, int _c_hdd, sistem_operare _sistem_operare) {
        super(_denumire, _nr_inv, _pret, _zona_mag, _situatie);
        this.tip_mon = _tip_mon;
        this.vit_proc = _vit_proc;
        this.c_hdd = _c_hdd;
        this.sistem_operare = _sistem_operare;
    }
}
