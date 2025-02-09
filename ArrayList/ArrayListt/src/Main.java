//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Pessoa pessoa = new Pessoa("Sabrina");

            Telefone tel = new Telefone("Casa", "88", "9999-9999");
            Telefone tel2 = new Telefone("Casa", "88", "8888-9999");

            pessoa.addTelefone(tel);
            pessoa.addTelefone(tel2);

            pessoa.listarNumeros();

            pessoa.removerTelefone(tel);

            pessoa.listarNumeros();
    }
}