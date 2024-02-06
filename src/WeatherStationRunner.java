import java.util.Scanner;

public class WeatherStationRunner {
    static WeatherStationUI gui;

    public WeatherStationRunner() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine().trim().toLowerCase();
        gui = new WeatherStationUI() {

            @Override
            public void update(int reading) {
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
            }

        };

        WeatherStation ws = new WeatherStation(gui);
        Thread thread = new Thread(ws);
        thread.start();
        scanner.close();
    }
}