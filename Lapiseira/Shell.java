import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

public class Shell {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] _args) {
        Pencil pencil = null;

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                if (pencil != null) {
                    System.out.println(pencil);
                } else {
                    System.out.println("fail: lápis não inicializado");
                }
            }
            else if (cmd.equals("init")) {
                var thickness = Float.parseFloat(par[1]);
                pencil = new Pencil(thickness);
            }
            else if (cmd.equals("insert")) {
                if (pencil != null) {
                    var thickness = Float.parseFloat(par[1]);
                    var hardness = par[2];
                    var size = Integer.parseInt(par[3]);
                    pencil.insert(new Lead(thickness, hardness, size));
                } else {
                    System.out.println("fail: lápis não inicializado");
                }
            }
            else if (cmd.equals("remove")) {
                if (pencil != null) {
                    pencil.remove();
                } else {
                    System.out.println("fail: lápis não inicializado");
                }
            }
            else if (cmd.equals("write")) {
                if (pencil != null) {
                    pencil.writePage();
                } else {
                    System.out.println("fail: lápis não inicializado");
                }
            }
            else if (cmd.equals("pull")) {
                if (pencil != null) {
                    pencil.pull();
                } else {
                    System.out.println("fail: lápis não inicializado");
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}
