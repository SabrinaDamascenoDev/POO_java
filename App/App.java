import java.util.*;

enum CarModel {
    CELTA(10), COROLLA(20);

    private final double pricePerHour;

    CarModel(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}

abstract class Vehicle {
    protected String id_veiculo;
    protected boolean isRented;

    public Vehicle(String id_veiculo) {
        this.id_veiculo = id_veiculo;
        this.isRented = false;
    }

    public String getId() {
        return id_veiculo;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }

    public void returnVehicle() {
        isRented = false;
    }

    public abstract double calculateRentalCost(int hours);
}

class Car extends Vehicle {
    private CarModel model;
    private int wearLevel;
    private static final int MAX_WEAR = 500;

    public Car(String id_veiculo, CarModel model) {
        super(id_veiculo);
        this.model = model;
        this.wearLevel = 0;
    }

    @Override
    public double calculateRentalCost(int hours) {
        return model.getPricePerHour() * hours;
    }

    public void applyWear(int hours) {
        this.wearLevel += hours * 2;
    }

    public boolean isAvailable() {
        return !isRented && wearLevel < MAX_WEAR;
    }

    @Override
    public String toString() {
        String status = wearLevel >= MAX_WEAR ? " (Indisponivel)" : "";
        return "Carro: ID=" + id_veiculo + ", Modelo=" + model + ", Preco/Hora=" + model.getPricePerHour() + ", Alugado=" + isRented + ", Desgaste=" + wearLevel + status;
    }
}

class ElectricBike extends Vehicle {
    private int battery;

    public ElectricBike(String id_veiculo) {
        super(id_veiculo);
        this.battery = 100;
    }

    @Override
    public void rent() {
        if (battery > 0) {
            super.rent();
        } else {
            System.out.println("Bicicleta sem bateria! Recarregue antes de alugar.");
        }
    }

    public void chargeBattery() {
        if (!isRented) {
            battery = 100;
            System.out.println("Bateria recarregada!");
        } else {
            System.out.println("Não é possível carregar uma bicicleta alugada!");
        }
    }

    @Override
    public double calculateRentalCost(int hours) {
        return 0;
    }

    @Override
    public String toString() {
        return "Bike Eletrica: ID=" + id_veiculo + ", Bateria=" + battery + "%, Alugado=" + isRented;
    }
}

class Locadora {
    private ArrayList<Vehicle> vehicles;

    public Locadora() {
        this.vehicles = new ArrayList<>();
    }

    public void addCar(String id, String modelStr) {
        CarModel model = CarModel.valueOf(modelStr.toUpperCase());
        vehicles.add(new Car(id, model));
    }

    public void addBike(String id) {
        vehicles.add(new ElectricBike(id));
    }

    public void rentCar(String id, int hours) {
        for (Vehicle v : vehicles) {
            if (v instanceof Car && v.getId().equals(id)) {
                Car car = (Car) v;
                if (car.isAvailable()) {
                    car.rent();
                    car.applyWear(hours);
                    System.out.println("Custo: R$" + car.calculateRentalCost(hours));
                } else {
                    System.out.println("Carro nao disponivel.");
                }
                return;
            }
        }
        System.out.println("Carro nao encontrado.");
    }

    public void rentBike(String id) {
        for (Vehicle v : vehicles) {
            if (v instanceof ElectricBike && v.getId().equals(id)) {
                v.rent();
                return;
            }
        }
        System.out.println("Bicicleta nao encontrada.");
    }

    public void chargeBattery(String id) {
        for (Vehicle v : vehicles) {
            if (v instanceof ElectricBike && v.getId().equals(id)) {
                ((ElectricBike) v).chargeBattery();
                return;
            }
        }
        System.out.println("Bicicleta nao encontrada.");
    }

    public void returnVehicle(String id) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id) && v.isRented()) {
                v.returnVehicle();
                System.out.println("Veiculo retornado.");
                return;
            }
        }
        System.out.println("Veiculo nao encontrado ou nao alugado.");
    }

    public void show() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
