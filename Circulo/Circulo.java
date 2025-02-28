public class Circulo {
    private double radios;
    private String color;

    public Circulo(){
        radios = 1.0;
        color = "red";
    }

    public Circulo(double r){
        radios = r;
        color = "red";
    }

    public double getRadios(){
        return this.radios;
    }

    public String getColor(){
        return this.color;
    }
    public static void main(String[] args){
        Circulo circ1 = new Circulo(2.25);
        System.out.println(circ1.getRadios());
        System.out.println(circ1.getColor());
    }
}


