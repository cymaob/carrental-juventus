package ch.juventus.se.carrental.business;

public class Car extends AbstractVehicle{
    protected int doors;
    protected int seats;
    protected String transmission;
    protected String chassis;

    public Car(int doors, int seats, String transmission, String chassis) {
        this.doors = doors;
        this.seats = seats;
        this.transmission = transmission;
        this.chassis = chassis;
    }
}
