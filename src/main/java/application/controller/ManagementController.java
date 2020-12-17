package application.controller;

import application.service.ManagementService;

public class ManagementController {
    private ManagementController() {
    }

    public static void addCity(String name) {
        ManagementService.addCity(name);
    }
}
