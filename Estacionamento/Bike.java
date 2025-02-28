public class Bike extends Veiculo{
    String id;
    public Bike(String id, String idVeiculo, String tipoVeiculo, int horaAtualEstacionamento){
        super(idVeiculo, tipoVeiculo, horaAtualEstacionamento);
        this.id = id;
    }
    public void calcularValor(int horaSaida){

    }
}
