public class InvoiceItem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem(String id, String desc, int qty,  double unitPrice){
        this.unitPrice = unitPrice;
        this.id = id;
        this.desc = desc;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getId(){
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public double getTotal(){
        return unitPrice*qty;
    }

    public String toString(){
        return "InvoiceItem[id=" + this.id + ", desc=" + this.desc + ", qty=" + this.qty + ", unitPrice=" + this.unitPrice + "]";
    }

}
