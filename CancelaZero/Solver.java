import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
class ComputaSequencia{

    private ArrayList<Integer> notas = new ArrayList<>();

    public void cadastra(int valor){

        if(valor != 0){
            notas.add(valor);
        } else {
            notas.remove(notas.size()-1);
        }
    }

    public int computa(){
        int soma = 0;
        for(int i = 0; i < notas.size(); i++){
            soma = notas.get(i) + soma;
        }

        return soma;
    }

    public String toString(){
        return "valores = " + notas;
    }

}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia sequencia = new ComputaSequencia();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("cadastra")) {
                sequencia.cadastra( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("computa")) {
                System.out.println( sequencia.computa() );
            } else if(ui[0].equals("show")) {
                System.out.println( sequencia );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
