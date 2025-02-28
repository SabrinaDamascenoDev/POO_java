public abstract class Veiculo extends Estacionamento{
    private String id;
    protected String tipo;
    protected int horaEntrada;

    public Veiculo(String id, String tipo, int horaAtualEstacionamento){
        super(horaAtualEstacionamento);
        this.id = id;
        this.tipo = tipo;
    }
    public void setEntrada(int horaEntrada){
        this.horaEntrada = horaEntrada;
    };
    public int getEntrada(){
        return this.horaEntrada;
    };
    public  String getTipo(){
        return this.tipo;
    };
    public  String getId(){
        return this.id;
    };
    public abstract void calcularValor(int horaSaida);

}
