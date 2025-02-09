import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private ArrayList<Telefone> telefones;

    public Pessoa(String nome){
        this.nome = nome;
        this.telefones = new ArrayList<Telefone>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefones(ArrayList<Telefone> telefones){
        this.telefones = telefones;
    }
     public void addTelefone(Telefone tel){
        this.telefones.add(tel);
     }

     public void removerTelefone(Telefone tel){
        this.telefones.remove(tel);
     }
     public void listarNumeros() {
        for(Telefone tel : telefones){
            System.out.println(tel.getNumero());
        }
     }
}
