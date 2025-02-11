package src;

public class Funcionario extends Pessoa{
    private String setor;
    private boolean trabalhando;

    public void mudaTrabalho(){
        if(!this.trabalhando){
            this.trabalhando = true;
        } else {
            this.trabalhando = false;
        }
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }
    public boolean getTrabalhando(){
        return this.trabalhando;
    }

}
