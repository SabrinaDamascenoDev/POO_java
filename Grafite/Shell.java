import java.util.Scanner;
class Lead {
    private int size;
    private final String hardness;
    private final double thickness;

    public Lead(double thickness, String hardness, int size){
        this.size = size;
        this.hardness = hardness;
        this.thickness = thickness;
    }

    public int usagePerSheet(){
        return switch (hardness) {
            case "HB" -> 1;
            case "2B" -> 2;
            case "4B" -> 4;
            case "6B" -> 6;
            default -> 0;
        };

    }

    public double getThickness(){
        return this.thickness;
    }

    public int getSize(){
        return this.size;
    }

    public String getHardness(){
        return this.hardness;
    }

    public void setSize(int valor){
        this.size = valor;
    }

    public String toString() {
        return String.format("[%.1f:%s:%d]", this.thickness, this.hardness, this.size);
    }

}
class Pencil {
    private Lead tip;
    private double thickness;

    public Pencil(double thickness){
        this.thickness = thickness;
        this.tip = null;
    }

    public boolean hasGrafite() {
        if(tip != null){
            return true;
        } else {
            System.out.println("fail: nao existe grafite");
            return false;
        }
    }

    public boolean insert(Lead lead){

        if(tip != null){
            System.out.println("fail: ja existe grafite");
            return false;
        }  else {
            this.tip = lead;
            if(tip.getThickness() != this.thickness){
                System.out.println("fail: calibre incompativel");
                this.tip = null;
            }
            return true;
        }
    }

    public Lead remove(){
        if(this.tip == null){
            System.out.println("fail: nao existe grafite");
            return null;
        } else {

            tip = null;
            return tip;
        }
    }

    public void writePage(){
        if(this.tip == null){
            System.out.println("fail: nao existe grafite");
        } else if((tip.getSize()-tip.usagePerSheet()/2) < 10){
            System.out.println("fail: tamanho insuficiente");
        } else {
            if(tip.usagePerSheet() == 1){
                if((tip.getSize()-1) < 10){
                    System.out.println("fail: folha incompleta");
                    tip.setSize(10);
                } else {
                    tip.setSize(tip.getSize()-1);
                }
            } else if(tip.usagePerSheet() == 2){
                if((tip.getSize()-2) < 10){
                    System.out.println("fail: folha incompleta");
                    tip.setSize(10);
                } else {
                    tip.setSize(tip.getSize()-2);
                }
            } else if(tip.usagePerSheet() == 4){
                if((tip.getSize()-4) < 10){
                    System.out.println("fail: folha incompleta");
                    tip.setSize(10);
                    return;
                } else {
                    int valor4 = tip.getSize();
                    tip.setSize(valor4-4);
                }
            } else if(tip.usagePerSheet() == 6){
                if((tip.getSize()-6) < 10){
                    System.out.println("fail: folha incompleta");
                    tip.setSize(10);
                } else {
                    int valor = tip.getSize();
                    tip.setSize(valor-6);
                }
            }
        }
    }

    public String toString(){
        if(tip == null){
            return String.format("calibre: %.1f, grafite: null", thickness);
        } else {
            return String.format("calibre: %.1f, grafite: %s", thickness, tip.toString());
        }

    }

}
class Adapter {
    private Pencil pencil;
    public Adapter(double thickness) {
        pencil = new Pencil(thickness);
    }

    public void insert(double thickness, String hardness, int length) {
        pencil.insert(new Lead(thickness, hardness, length));
    }

    public void remove() {
        pencil.remove();
    }

    public void writePage() {
        pencil.writePage();
    }

    public void show() {
        System.out.println(pencil.toString());
    }
}


public class Shell {
    public static void main(String[] _args) {
        Adapter adp = new Adapter(0.5f);

        while (true) {
            String line = input();
            String[] args = line.split(" ");
            write('$' + line);

            if      ("end".equals(args[0])   ) { break;                                                       }
            else if ("init".equals(args[0])  ) { adp = new Adapter(number(args[1]));                          }
            else if ("insert".equals(args[0])) { adp.insert(number(args[1]), args[2], (int) number(args[3])); }
            else if ("remove".equals(args[0])) { adp.remove();                                                }
            else if ("write".equals(args[0]) ) { adp.writePage();                                             }
            else if ("show".equals(args[0])  ) { adp.show();                                                  }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static double number(String str) { return Double.parseDouble(str); }
}