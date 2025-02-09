public class Telefone {
    private String tipo;
    private  String ddd;
    private String numero;
    public Telefone(String tipo, String ddd, String numero){
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getDdd(){
        return this.ddd;
    }
    public String getNumero(){
        return this.numero;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setDdd(String ddd){
        this.ddd = ddd;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
}

