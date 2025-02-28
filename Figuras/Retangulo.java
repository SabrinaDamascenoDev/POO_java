class Retangulo extends Shape {
    Ponto2D infEsq, supDir;

    Retangulo(Ponto2D infEsq, Ponto2D supDir) {
        this.infEsq = infEsq;
        this.supDir = supDir;
    }

    @Override
    double area() {
        return Math.abs((supDir.x - infEsq.x) * (supDir.y - infEsq.y));
    }

    @Override
    double perimetro() {
        return 2 * (Math.abs(supDir.x - infEsq.x) + Math.abs(supDir.y - infEsq.y));
    }

    @Override
    boolean inside(Ponto2D p) {
        return (p.x >= infEsq.x && p.x <= supDir.x && p.y >= infEsq.y && p.y <= supDir.y);
    }

    public String toString() {
        return String.format("Retângulo com cantos %s e %s", infEsq, supDir);
    }
}