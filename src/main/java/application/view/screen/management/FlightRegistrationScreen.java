package application.view.screen.management;

import application.controller.ManagementController;
import application.view.InputView;
import application.view.OutputView;

public class FlightRegistrationScreen {
    private static final String INPUT_FLIGHT_ID = "항공편 ID를 입력해 주세요. ";
    private static final String INPUT_DEPARTURE_AIRPORT_REPRESENTATION = "출발하는 공항의 축악어를 입력해 주세요. ";
    private static final String INPUT_ARRIVAL_AIRPORT_REPRESENTATION = "도착하는 공항의 축악어를 입력해 주세요. ";
    private static final String INPUT_DEPARTURE_TIME = "출발 시간을 입력해 주세요. ";
    private static final String INPUT_ARRIVAL_TIME = "도착 시간을 입력해 주세요. ";
    private static final String INPUT_PRICE = "항공편 가격을 입력해 주세요.";

    public static void interact() {
        int flightId = inputFlightId();
        String departureRepresentation = inputDepartureRepresentation();
        String arrivalRepresentation = inputArrivalRepresentation();
        String departureTime = inputDepartureTime();
        String arrivalTime = inputArrivalTime();
        int price = inputPrice();

        ManagementController.addFlight(flightId, departureRepresentation, arrivalRepresentation,
                departureTime, arrivalTime, price);
    }

    private static int inputFlightId() {
        OutputView.print(INPUT_FLIGHT_ID);
        return Integer.parseInt(InputView.readLine());
    }

    private static String inputDepartureRepresentation() {
        OutputView.print(INPUT_DEPARTURE_AIRPORT_REPRESENTATION);
        return InputView.readLine();
    }

    private static String inputArrivalRepresentation() {
        OutputView.print(INPUT_ARRIVAL_AIRPORT_REPRESENTATION);
        return InputView.readLine();
    }

    private static String inputDepartureTime() {
        OutputView.print(INPUT_DEPARTURE_TIME);
        return InputView.readLine();
    }

    private static String inputArrivalTime() {
        OutputView.print(INPUT_ARRIVAL_TIME);
        return InputView.readLine();
    }

    private static int inputPrice() {
        OutputView.print(INPUT_PRICE);
        return Integer.parseInt(InputView.readLine());
    }
}
