import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Parabola> parabole=new ArrayList<Parabola>();
        try {
            RandomAccessFile file = new RandomAccessFile("D:\\lucru_java_intellij\\lab3-3.1\\src\\in.txt", "r");
            String str;

            while ((str = file.readLine()) != null) {
                String[] result = str.split( " ");
                parabole.add(new Parabola(Integer.parseInt(result[0]),Integer.parseInt(result[1]),Integer.parseInt(result[2])));


            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Lista contine parabolele:");
        for(Parabola p:parabole) {
           System.out.println(p);
            p.AfisareVarfParabola();
        }
        Parabola parabola1 = parabole.get(0);
        Parabola parabola2 = parabole.get(1);

        System.out.println("Coordonatele mijlocului segmentului: " + Parabola.ComputeCoordonateleMijSeg_Static(parabola1,parabola2));
        System.out.println("Lungimea segmentului: " + Parabola.ComputeLungimeaSegmentului_Static(parabola1,parabola2));

    }
}