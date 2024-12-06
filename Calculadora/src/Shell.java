
import java.text.DecimalFormat;

class Calculator {

    int battery=0;
    int batteryMax=0;
    float display=0;

    public Calculator(int batteryMax){
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0;

    }
    void chargeBattery(int value){
        if((battery + value) <= batteryMax){
            battery += value;
        } else {
            battery = batteryMax;
        }
    }

    void sum(int a, int b){
        if(battery <= 0){
            System.out.println("fail: bateria insuficiente");
        }else {
            display = a+b;
            battery -= 1;
        }
    }

    void division(int a, int b){
        if(battery <= 0){
            System.out.println("fail: bateria insuficiente");
        }else if(b == 0) {
            System.out.println("fail: divisao por zero");
            battery -= 1;
        } else {
            display = (float)a/b;
            battery -=1;
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("display = %s, battery = %d", df.format(this.display), this.battery);
    }
}

import java.util.*;


class Adapter {
    private Calculator calc = new Calculator(0);
    //
    void init() {
        calc = new Calculator(0);
    }

    void show() {
        System.out.println(calc.toString());
    }

    void init(int batteryMax) {
        calc = new Calculator(batteryMax);
    }

    void charge(int value) {
        calc.chargeBattery(value);
    }

    void sum(int a, int b) {
        calc.sum(a, b);
    }

    void div(int a, int b) {
        calc.division(a, b);
    }
}


public class Shell {
    static Adapter adp = new Adapter();

    public static void main(String[] _args) {
        while (true) {
            System.out.print("$");
            var line = input();
            var args = line.split(" ");
            write(line);

            if      (args[0].equals("end"   )) { break;                                                 }
            else if (args[0].equals("show"  )) { adp.show();                                            }
            else if (args[0].equals("init"  )) { adp.init((int) number(args[1]));                       }
            else if (args[0].equals("charge")) { adp.charge((int) number(args[1]));                     }
            else if (args[0].equals("sum"   )) { adp.sum((int) number(args[1]), (int) number(args[2])); }
            else if (args[0].equals("div"   )) { adp.div((int) number(args[1]), (int) number(args[2])); }
            else                               { write("fail: comando invalido");                 }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String input() { return scanner.nextLine(); }
    private static double number(String value) { return Double.parseDouble(value); }
    private static void write(String value) { System.out.println(value); }
}