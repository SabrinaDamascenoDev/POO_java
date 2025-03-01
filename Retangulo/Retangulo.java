public class Retangulo {
    private float length;
    private float width;

    public Retangulo(){
        this.length = 1;
        this.width = 1;
    }

    public Retangulo(float length, float width){
        this.length = length;
        this.width = width;
    }

    public float getLength(){
        return this.length;
    }

    public void setLength(float length){
        this.length = length;
    }

    public float getWidth(){
        return this.width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getArea(){
        return length*width;
    }

    public float getParimeter(){
        return this.length*2+this.width*2;
    }

    public String toString(){
        return "Rectangle[Length= " + this.length + ", width= " + this.width + "]";
    }

}
