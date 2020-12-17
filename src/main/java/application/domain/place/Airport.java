package application.domain.place;

public class Airport {
    private final City city;
    private final String representation;

    public Airport(City city, String representation) {
        AirportValidator.validateRegistration(representation);
        this.city = city;
        this.representation = representation;
    }

    public City getCity() {
        return city;
    }

    public String getRepresentation() {
        return representation;
    }
}
