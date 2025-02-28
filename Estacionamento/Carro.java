public class Carro extends Veiculo{
    String id;
    public Carro(String id, String idVeiculo, String tipoVeiculo, int horaAtualEstacionamento){
        super(idVeiculo, tipoVeiculo, horaAtualEstacionamento);
        this.id = id;

    }


      
    public float calcularValor(int horaSaida, float taxa){
        float valor = 0;
        try {

            if ((horaSaida > horaEntrada )&& (horaSaida<0) || (horaEntrada<0)) {
                return  0;
            } else {
                int horaPermanecida = horaSaida - horaEntrada;
                valor = (horaPermanecida * taxa);
            }
            return valor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
