import java.util.ArrayList;


public class Pencil{
    private float thickness;
    private Lead tip;
    private ArrayList<Lead> barrel;

    public Pencil(float thickness){
        this.thickness = thickness;
        this.tip = null;
        this.barrel = new ArrayList<>();
    }

    //Inserir grafite no barrel
    public boolean insert(Lead lead){
        if(this.thickness != lead.getThickness()){
            System.out.println("fail: calibre incompatível");
            return false;
        } else {
            barrel.add(lead);
            return true;
        }
    }

    //Remover o grafite do bico
    public Lead remove(){
        Lead deleted = tip;
        this.tip = null;
        return deleted;
    }

    public boolean pull(){
        if(this.tip == null){
            this.tip = barrel.get(0);
            barrel.remove(0);
            return true;
        } else {
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
    }
    public void writePage(){
        if(this.tip == null){
            System.out.println("fail: nao existe grafite no bico");
        } else if(tip.getSize() <= 10){
            System.out.println("fail: tamanho insuficiente");
        } else if(tip.getSize() - tip.usagePerSheet() < 10){
            System.out.println("fail: folha incompleta");
            tip.setSize(10);
        } else {
            tip.setSize(tip.getSize()-tip.usagePerSheet());
        }
    }
    public String toString(){

        StringBuilder barrelContent = new StringBuilder();
        for (Lead lead : barrel) {
            barrelContent.append(lead.toString());
        }

        if(tip == null){
            return "calibre: " + this.thickness + ", bico: [], tambor: <" + barrelContent + ">";
        } else {
            return "calibre: " + this.thickness + ", bico: " + this.tip.toString() +", tambor: <" + barrelContent + ">";
        }

    }
}