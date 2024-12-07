import java.util.*;

class Time{
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second){
        if(hour > 23){
            System.out.println("fail: hora invalida");
        } else {
            this.hour = hour;
        }
        if(minute > 59){
            System.out.println("fail: minuto invalido");
        } else {
            this.minute = minute;
        }
        if(second > 59){
            System.out.println("fail: segundo invalido");
        } else {
            this.second = second;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public int getSecond(){
        return this.second;
    }

    public void setHour(int valor){
        if(valor > 23){
            System.out.println("fail: hora invalida");
        } else {
            this.hour = valor;
        }
    }
    public void setMinute(int valor){
        if(valor > 59){
            System.out.println("fail: minuto invalido");
        } else {
            this.minute = valor;
        }
    }
    public void setSecond(int valor){
        if(valor > 59){
            System.out.println("fail: segundo invalido");
        } else {
            this.second = valor;
        }
    }
    void nextSecond(){
        this.second +=1;
        if(this.second > 59){
            this.second = this.second - 60;
            this.minute += 1;
        }
        if(this.minute > 59){
            this.minute = this.minute - 60;
            this.hour += 1;
        }
        if(this.hour > 23){
            this.hour = this.hour - 24;
        }
    }
    public String toString(){
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}

class Adapter {
    private Time time = new Time(0, 0, 0);
    public void init(int hour, int minute, int second) {
        time = new Time(hour, minute, second);
    }

    public void setHour(int hour) {
        time.setHour(hour);
    }

    public void setMinute(int minute) {
        time.setMinute(minute);
    }

    public void setSecond(int second) {
        time.setSecond(second);
    }

    public void nextSecond() {
        time.nextSecond();
    }

    public void show() {
        System.out.println(time);
    }
}

public class Shell {
    public static void main(String[] a) {
        Adapter stu = new Adapter();

        label:
        while (true) {
            System.out.print("$");

            var line = input();
            write(line);

            var args = line.split(" ");


            switch (args[0]) {
                case "show":
                    stu.show();
                    break;
                case "init":
                    stu.init((int) number(args[1]), (int) number(args[2]), (int) number(args[3]));
                    break;
                case "set":
                    stu.setHour((int) number(args[1]));
                    stu.setMinute((int) number(args[2]));
                    stu.setSecond((int) number(args[3]));
                    break;
                case "next":
                    stu.nextSecond();
                    break;
                case "end":
                    break label;
                default:
                    write("fail: comando invalido");
                    break;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}