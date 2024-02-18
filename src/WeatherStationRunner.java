import java.util.Scanner;

public class WeatherStationRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please specify which GUI you would like to launch the application with (t for TextUI or s for SwingUI): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        WeatherStation ws = new WeatherStation();
        switch (choice) {
            case "t":
                new TextUI(ws);
                break;
            case "s":
                new SwingUI(ws);
                break;
            default:
                new SwingUI(ws);
                break;
        }

        Thread thread = new Thread(ws);
        thread.start();
        scanner.close();
    }
}
