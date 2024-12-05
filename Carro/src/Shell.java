import java.util.*;
class Car{
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;

    public Car(){
        this.gas = 0;
        this.gasMax = 100;
        this.pass = 0;
        this.passMax = 2;
        this.km = 0;

    }

    void enter(){
        if(this.pass >= this.passMax){
            System.out.println("fail: limite de pessoas atingido");
            this.pass=2;
        } else {
            this.pass++;
        }
    }
    void leave(){
        if(this.pass <= 0){
            System.out.println("fail: nao ha ninguem no carro");
            this.pass=0;
        } else {
            this.pass--;
        }
    }

    void fuel(int valor){
        if(gas >= gasMax){
            System.out.println("fail: tanque cheio");
            this.gas = gasMax;
        }
        if((valor+gas) > gasMax){
            this.gas = 100;
        } else {
            this.gas += valor;
        }


    }

    void drive(int valor){
        if(this.pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
        } else if(this.gas == 0){
            System.out.println("fail: tanque vazio");
        } else {
            this.km += valor;
            int gasAntes = this.gas;
            this.gas -= valor;
            if(this.gas < 0){
                this.gas = this.gas *(-1);
                int andou = valor - this.gas;
                System.out.println("fail: tanque vazio apos andar " + gasAntes + " km");
                this.km = this.km-this.gas;
                gas = 0;

            }
        }
    }


    public String toString() {
        return String.format("pass: %d, gas: %d, km: %d", pass, gas, km);
    }
}
class Adapter {
    Car car = new Car();

    public void enter() {
        car.enter();
    }

    public void leave() {
        car.leave();
    }

    public void fuel(int gas) {
        car.fuel(gas);
    }

    public void drive(int km) {
        car.drive(km);
    }

    public void show() {
        System.out.println(car.toString());
    }
}


public class Shell {

    public static void main(String[] a) {
        Adapter adp = new Adapter();

        while (true) {
            System.out.print("$");
            var line = input();
            write(line); // comente para executar interativamente
            var args = line.split(" ");
            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("show"))  { adp.show();                           }
            else if (args[0].equals("enter")) { adp.enter();                          }
            else if (args[0].equals("leave")) { adp.leave();                          }
            else if (args[0].equals("drive")) { adp.drive(Integer.parseInt(args[1])); }
            else if (args[0].equals("fuel"))  { adp.fuel(Integer.parseInt(args[1]));  }
            else                              { System.out.println("fail: comando invalido");}
        }
    }
    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static void    write(String value)  { System.out.println(value); }
}