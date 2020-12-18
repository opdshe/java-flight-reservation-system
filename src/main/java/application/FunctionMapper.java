package application;

import application.view.screen.exception.NotSupportedScreenException;
import application.view.screen.management.*;
import application.view.screen.mypage.BalanceInquiryScreen;
import application.view.screen.mypage.DepositScreen;
import application.view.screen.mypage.MyPageScreen;
import application.view.screen.mypage.TicketCancelScreen;
import application.view.screen.reservation.AllFlightInquiryScreen;
import application.view.screen.reservation.FlightReservationScreen;
import application.view.screen.reservation.ReservationScreen;
import application.view.screen.reservation.SpecifiedFlightInquiryScreen;

import java.util.HashMap;
import java.util.Map;

public class FunctionMapper {
    public static final Map<String, Runnable> MAIN_FUNCTION_MAPPER = new HashMap<>();
    public static final Map<String, Runnable> RESERVATION_FUNCTION_MAPPER = new HashMap<>();
    public static final Map<String, Runnable> MANAGEMENT_FUNCTION_MAPPER = new HashMap<>();
    public static final Map<String, Runnable> MY_PAGE_FUNCTION_MAPPER = new HashMap<>();

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String BACK = "B";
    private static final String QUIT = "Q";

    static {
        MAIN_FUNCTION_MAPPER.put(ONE, ReservationScreen::interact);
        MAIN_FUNCTION_MAPPER.put(TWO, MyPageScreen::interact);
        MAIN_FUNCTION_MAPPER.put(THREE, ManagementScreen::interact);
        MAIN_FUNCTION_MAPPER.put(QUIT, Status::terminate);
    }

    static {
        RESERVATION_FUNCTION_MAPPER.put(ONE, AllFlightInquiryScreen::interact);
        RESERVATION_FUNCTION_MAPPER.put(TWO, SpecifiedFlightInquiryScreen::interact);
        RESERVATION_FUNCTION_MAPPER.put(THREE, FlightReservationScreen::interact);
        RESERVATION_FUNCTION_MAPPER.put(BACK, () -> {
        });
    }

    static {
        MY_PAGE_FUNCTION_MAPPER.put(ONE, TicketCancelScreen::interact);
        MY_PAGE_FUNCTION_MAPPER.put(TWO, BalanceInquiryScreen::interact);
        MY_PAGE_FUNCTION_MAPPER.put(THREE, DepositScreen::interact);
        MY_PAGE_FUNCTION_MAPPER.put(BACK, () -> {
        });
    }

    static {
        MANAGEMENT_FUNCTION_MAPPER.put(ONE, CityRegistrationScreen::interact);
        MANAGEMENT_FUNCTION_MAPPER.put(TWO, CityRemovalScreen::interact);
        MANAGEMENT_FUNCTION_MAPPER.put(THREE, AirportRegistrationScreen::interact);
        MANAGEMENT_FUNCTION_MAPPER.put(FOUR, AirportRemovalScreen::interact);
        MANAGEMENT_FUNCTION_MAPPER.put(FIVE, FlightRegistrationScreen::interact);
        MANAGEMENT_FUNCTION_MAPPER.put(BACK, () -> {
        });
    }

    public static Runnable matchFunction(Map<String, Runnable> mapper, String command) {
        return mapper.entrySet().stream()
                .filter(entry -> entry.getKey().equals(command))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(NotSupportedScreenException::new);
    }
}
