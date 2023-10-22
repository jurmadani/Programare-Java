public class Parabola {
    private int a;
    private int b;
    private int c;
    public Parabola(int _a,int _b, int _c){
        super();
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }

    @Override
    public String toString() {
       return "f(x) = " + this.a + "x^2" + " + " + this.b + "x + " + this.c;
    }

    public String ComputeCoordonateleMijSeg(int _a, int _b,int _c){
        int x,y;
        x = ( -((this.b)/(2*this.a)) + -(_b/(2*_a)) )  / 2;
        y = ((-(this.b * this.b) + 4*this.a*this.c) / 4*this.a ) + ((-(_b * _b) + 4*_a*_c) / 4*_a);
        return "("+x+","+y+")";
    }
    public static String ComputeCoordonateleMijSeg_Static(Parabola parabola1, Parabola parabola2){
        int x,y;
        x = ( -((parabola1.b)/(2*parabola1.a)) + -(parabola2.b/(2*parabola2.a)) )  / 2;
        y = ((-(parabola1.b * parabola1.b) + 4*parabola1.a* parabola1.c) / 4*parabola1.a ) + ((-(parabola2.b * parabola2.b) + 4*parabola2.a*parabola2.c) / 4*parabola2.a);
        return "("+x+","+y+")";
    }

    public void AfisareVarfParabola(){
        int x = - (this.b / (2*this.a));
        int y = (-(this.b * this.b) + 4*this.a*this.c) / (4*this.a);
        System.out.println("Coordonatele varfului parabolei este (x,y): (" + x + "," + y + ")");
    }
    public double ComputeLungimeaSegmentului(int _a,int _b, int _c){
        double _x1,_y1,_x2,_y2;
        _x1 = -(this.b / (2*this.a));
        _y1 = (-(this.b*this.b) + 4 * this.a * this.c) / (4*this.a);
        _x2 = -(_b / (2*_a));
        _y2 = (-(_b*_b) + 4 * _a * _c) / (4*_a);
        double dif1 = _x2-_x1;
        double dif2 = _y2 - _y1;
        return  Math.hypot(dif1,dif2);
    }

    public static double ComputeLungimeaSegmentului_Static(Parabola parabola1, Parabola parabola2){
        float _x1,_y1,_x2,_y2;
        _x1 = -(parabola2.b/ (2*parabola2.a));
        _y1 = (-(parabola2.b*parabola2.b) + 4 * parabola2.a * parabola2.c) / (4*parabola2.a);
        _x2 = -(parabola1.b / (2*parabola1.a));
        _y2 = (-(parabola1.b*parabola1.b) + 4 * parabola1.a * parabola1.c) / (4*parabola1.a);
        float dif1 = _x2-_x1;
        float dif2 = _y2 - _y1;
        return  Math.hypot(dif1,dif2);
    }
}
