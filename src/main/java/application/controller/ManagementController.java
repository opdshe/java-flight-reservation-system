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
}
