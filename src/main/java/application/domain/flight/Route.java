package application.domain.flight;

import application.domain.place.Airport;

public class Route {
    private final Airport source;
    private final Airport dest;

    public Route(Airport source, Airport dest) {
        this.source = source;
        this.dest = dest;
    }

    public boolean isCorrespondRoute(String source, String dest) {
        return source.equals(getSourceCity()) && dest.equals(getDestCity());
    }

    public String getSourceCity() {
        return source.getCity().getName();
    }

    public String getDestCity() {
        return dest.getCity().getName();
    }
}
