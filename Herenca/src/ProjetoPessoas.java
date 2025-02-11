package src;

public class ProjetoPessoas {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa();
        Aluno p2 = new Aluno();
        Professor p3 = new Professor();
        Funcionario p4 = new Funcionario();

        p1.setNome("Sabrina");
        p1.setIdade(18);
        p1.setSexo("Feminino");

        p2.setNome("Duda");
        p2.setMatr(999999);
        p2.setIdade(19);
        p2.setCurso("Sistemas de informação");
        p2.setSexo("Feminino");

        p3.setNome("Alguem");
        p3.setSalario(2300);
        p3.setIdade(100);
        p3.setEspecialidade("Arquitetura");
        p3.setSexo("Masculino");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

    }
}
