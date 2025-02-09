//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Contato cont = new Contato();
        cont.setNome("Sabrina");
        //cont.setEndereco("Curral novo");
        //cont.setTelefone("99 9999-9999");

        //Criar objeto endereco relacionamento tem-um
        Endereco end = new Endereco();
        end.setCidade("Morada Nova");
        end.setEstado("Ceará");
        end.setComplemento("S/C");
        end.setNomeRua("Curral Novo");
        end.setCep("99999 999");

        cont.setEndereco(end);

        //Criar objeto tel relacionamento tem-um
        Telefone tel = new Telefone();
        tel.setTipo("Celular");
        tel.setDdd("88");
        tel.setNumero("9999-9999");

        Telefone tel2 = new Telefone();
        tel2.setTipo("Casa");
        tel2.setDdd("88");
        tel2.setNumero("8888-8888");

        Telefone[] telefones = new Telefone[2];
        telefones[0] = tel;
        telefones[1] = tel2;

        cont.setTelefones(telefones);
        //Evita erro
        if(cont.getEndereco() != null && cont != null){
            System.out.println(cont.getEndereco().getEstado());
        }

        /*if(cont.getTelefones() != null && cont != null){
            System.out.println(cont.getTelefones().getNumero());
        }*/

        if(cont.getTelefones() != null && cont != null){
            for(Telefone t: cont.getTelefones()){
                System.out.println(t.getNumero());
            }

        }



        System.out.println(cont.getNome());
    }
}