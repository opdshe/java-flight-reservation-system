package application.controller;

import application.service.ManagementService;

public class ManagementController {
    private ManagementController() {
    }

    public static void addCity(String name) {
        ManagementService.addCity(name);
    }

    public static void deleteCity(String name) {
        ManagementService.deleteCity(name);
    }

    public static void addAirport(String cityName, String representation) {
        ManagementService.addAirport(cityName, representation);
    }

    public static void deleteAirport(String representation) {
        ManagementService.deleteAirport(representation);
    }

    public static void addFlight(int flightId, String departureRepresentation, String arrivalRepresentation,
                                 String departureTime, String arrivalTime, int price) {
        ManagementService.addFlight(flightId, departureRepresentation, arrivalRepresentation,
                departureTime, arrivalTime, price);
    }
}
