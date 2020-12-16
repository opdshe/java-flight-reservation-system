package application.flight.domain;

public class Route {
    private final Airport source;
    private final Airport dest;

    public Route(Airport source, Airport dest) {
        this.source = source;
        this.dest = dest;
    }

    public String getSourceCity() {
        return source.getCity().getName();
    }

    public String getDestCity() {
        return dest.getCity().getName();
    }
}
