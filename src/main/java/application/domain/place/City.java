package application.domain.place;

public class City {
    private final String name;

    public City(String name) {
        CityValidator.validateRegistration(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
