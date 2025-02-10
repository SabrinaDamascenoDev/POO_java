import java.util.ArrayList;
import java.util.LinkedList;

public class Mercantil {
    public ArrayList<Pessoa> caixas;
    public LinkedList<Pessoa> espera;
    Mercantil(int qtdCaixas){
        this.caixas = new ArrayList<Pessoa>(qtdCaixas);
        this.espera = new LinkedList<>();

        for(int i = 0; i < qtdCaixas; i++){
            caixas.add(null);
        }
    }
    public void chegar(Pessoa p){
        this.espera.addLast(p);
    }
    public boolean chamarNoCaixa(int indice){
        if(this.espera.isEmpty()){
            System.out.println("fail: fila vazia");
            return false;
        }else if(caixas.get(indice) != null){
            System.out.println("fail: caixa ocupado");
            return false;
        } else {
            caixas.set(indice, espera.removeFirst());
            return true;
        }
    }
    public Pessoa finalizarAtendimento(int indice){
        if(caixas.get(indice) == null){
            System.out.println("fail: caixa inixistente");
            return null;
        } else if(caixas.isEmpty()){
            System.out.println("fail: caixa vazio");
            return null;
        } else{
            Pessoa p2 = new Pessoa(caixas.get(indice).getNome());
            caixas.set(indice, null);
            return caixas.get(indice);


        }
    }
    public String toString(){
        String caixasStr = caixas.stream()
                .map(p -> (p == null) ? "-----" : p.getNome())
                .reduce((a, b) -> a + ", " + b)
                .orElse("");

        // Mapeia a fila de espera: pega os nomes das pessoas
        String esperaStr = espera.stream()
                .map(Pessoa::getNome)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");

        // Retorna a string formatada
        return "Caixas: [" + caixasStr + "]\nEspera: [" + esperaStr + "]";
    }
}
