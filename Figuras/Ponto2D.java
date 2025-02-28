public class Ponto2D {
    private double x;
    private double y;

    public Ponto2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return String.format("(%.1f,%.1f)", x, y);
    }
}
