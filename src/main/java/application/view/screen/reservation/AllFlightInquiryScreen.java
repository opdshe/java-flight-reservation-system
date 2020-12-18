package application.view.screen.reservation;

import application.controller.FlightController;

public class AllFlightInquiryScreen {
    private static final String SCREE_NAME = "모든 항공편 조회 화면";

    public static void interact() {
        FlightController.printAll();
    }
}
