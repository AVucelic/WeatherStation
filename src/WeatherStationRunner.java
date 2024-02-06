import java.util.Scanner;

public class WeatherStationRunner {
    WeatherStationUI gui = null;
    public WeatherStationRunner() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine().trim().toLowerCase();
        switch (choice) {
            case "t":

                break;
            case "a":
                break;
            case "s":
                break;
            default:
                break;
        }

        WeatherStation ws = new WeatherStation();
        Thread thread = new Thread(ws);
        thread.start();
        scanner.close();
    }
}