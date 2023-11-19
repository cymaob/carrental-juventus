package ch.juventus.se.carrental.business;

public class AbstractVehicle implements Vehicle{
    protected int id;
    protected String brand;
    protected String model;
    protected double pricePerDay;

    /**
     * @return Gibt die ID zurück
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @return Gibt die Marke zurück
     */
    @Override
    public String getBrand() {
        return brand;
    }

    /**
     * @return gibt das Modell zurück
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * @return Gibt den Preis pro Tag zurück
     */
    @Override
    public double getPricePerDay() {
        return pricePerDay;
    }
}
