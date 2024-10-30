import java.time.*;
import java.time.temporal.ChronoUnit;

public class FlightBookingSystem {

    public static void main(String[] args) {

        LocalDate bookingDate = LocalDate.now();
        LocalDate flightDate = LocalDate.of(2024, 12, 15);
        long daysUntilFlight = ChronoUnit.DAYS.between(bookingDate, flightDate);
        System.out.println("Days until flight: " + daysUntilFlight);

        LocalTime departureTime = LocalTime.of(14, 30);
        Duration flightDuration = Duration.ofHours(5).plusMinutes(45);
        LocalTime arrivalTime = departureTime.plus(flightDuration);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);

        LocalDateTime departureDateTime = LocalDateTime.of(flightDate, departureTime);
        LocalDateTime arrivalDateTime = departureDateTime.plus(flightDuration);
        System.out.println("Departure Date and Time: " + departureDateTime);
        System.out.println("Arrival Date and Time: " + arrivalDateTime);

        Instant takeoffInstant = departureDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("Takeoff Instant (UTC): " + takeoffInstant);

        Period layover = Period.ofDays(1);
        LocalDateTime nextFlightDeparture = arrivalDateTime.plus(layover);
        System.out.println("Next Flight Departure Date and Time: " + nextFlightDeparture);

        Duration totalFlightTime = flightDuration.plus(Duration.ofHours(8));
        System.out.println("Total Flight Time (with layover): " + totalFlightTime.toHours() + " hours");

        ZoneId departureZone = ZoneId.of("America/New_York");
        ZoneId arrivalZone = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDepartureDateTime = departureDateTime.atZone(departureZone);
        ZonedDateTime zonedArrivalDateTime = arrivalDateTime.atZone(arrivalZone);
        System.out.println("Zoned Departure Date and Time: " + zonedDepartureDateTime);
        System.out.println("Zoned Arrival Date and Time: " + zonedArrivalDateTime);

        long hoursBetweenFlights = ChronoUnit.HOURS.between(arrivalDateTime, nextFlightDeparture);
        System.out.println("Hours between flights: " + hoursBetweenFlights);
    }
}
