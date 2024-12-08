import java.util.*;

class Person {
    private int age;
    private String nome;

    public Person(String nome, int age){
        this.nome = nome;
        this.age = age;

    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.nome;
    }

    public String toString(){
        return String.format("%s:%d", nome, age);
    }
}

class Motorcycle{
    private Person person;
    private int power;
    private int time;

    public Motorcycle(int power){
        if(power == 0){
            this.power = 1;
        } else {
            this.power = power;
        }
        this.time = 0;
        this.person = null;
    }

    public boolean enter(Person person){
        if(this.person != null) {
            System.out.println("fail: busy motorcycle");
            return false;
        } else {
            this.person = person;
            return true;
        }
    }

    public Person leave(){
        if(this.person != null){
            Person personElement = this.person;
            this.person = null;
            return personElement;
        } else {
            System.out.println("fail: empty motorcycle");
            return null;
        }
    }

    public void buy(int time){
        this.time += time;
    }
    public void drive(int time){
        if(this.time == 0){
            System.out.println("fail: buy time first");
        }
        else if(this.person == null){
            System.out.println("fail: empty motorcycle");
        }
        else if(this.person.getAge() > 10){
            System.out.println("fail: too old to drive");
        }

        else {
            if((this.time-time) <=0){
                int valor = this.time - time;
                valor = valor *(-1);
                System.out.printf("fail: time finished after %d minutes%n", valor);
                this.time = 0;
            } else {
                this.time -= time;
            }
        }

    }
    public String honk(){
        String buzina = "P";
        for(int i = 0; i < this.power; i++){
            buzina += "e";
        }
        buzina += "m";
        return buzina;
    }

    public String toString(){
        if(this.person == null){
            return String.format("power:%d, time:%d, person:(empty)", this.power, this.time);

        } else{
            return String.format("power:%d, time:%d, person:(%s)", this.power, this.time, person.toString());
        }
    }
}

class Adapter {
    Motorcycle moto = new Motorcycle(1);
    public void init(int power) {
        moto = new Motorcycle(power);
    }

    public void enter(String name, int age) {
        moto.enter(new Person(name, age));
    }

    public void buy(int price) {
        moto.buy(price);
    }

    public void drive(int km) {
        moto.drive(km);
    }

    public void leave() {
        var person = moto.leave();
        if (person == null) {
            System.out.println("---");
            return;
        }
        System.out.println(person.toString());
    }

    public void honk() {
        System.out.println(moto.honk());
    }

    public void show() {
        System.out.println(moto.toString());
    }
}


public class Shell{
    static Adapter adp = new Adapter();

    public static void main(String[] args) {
        while(true) {
            write("$");
            String line = input();
            args = line.split(" ");
            write(line + "\n");

            if      (args[0].equals("end"))      { break;                                       }
            else if (args[0].equals("show"))     { adp.show();                                  }
            else if (args[0].equals("init"))     { adp.init((int) number(args[1]));             }
            else if (args[0].equals("enter"))    { adp.enter(args[1], (int) number(args[2]));   }
            else if (args[0].equals("buy"))      { adp.buy((int) number(args[1]));              }
            else if (args[0].equals("drive"))    { adp.drive((int) number(args[1]));            }
            else if (args[0].equals("honk"))     { adp.honk();                                  }
            else if (args[0].equals("leave"))    { adp.leave();                                 }
            else                                 { write("fail: comando invalido\n");       }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()            { return scanner.nextLine();      }
    public static void write(String value)  { System.out.print(value);        }
    public static double number(String str) { return Double.parseDouble(str); }
}