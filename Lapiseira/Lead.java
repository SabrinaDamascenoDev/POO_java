public class Lead {
    private String hardness;
    private float thickness;
    private int size;

    public Lead(float thickness, String hardness, int size){
        this.hardness = hardness;
        this.size = size;
        this.thickness = thickness;
    }
    public float getThickness(){
        return this.thickness;
    }
    public int getSize(){
        return this.size;
    }
    public String getHardness(){
        return this.hardness;
    }
    public int usagePerSheet(){
        if(this.hardness.equals("HB")){
            return 1;
        } else if(this.hardness.equals("2B")){
            return 2;
        } else if(this.hardness.equals("4B")){
            return 4;
        } else {
            return 6;
        }
    }
    public void setSize(int size){
        this.size = size;
    }
    public String toString(){
        return "[" + this.thickness + ":" + this.hardness + ":" + this.size + "]";
    }
}
