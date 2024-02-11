import java.util.Scanner;

public class WeatherStationRunner {
    private static WeatherStationUI gui;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Please specify which GUI you would like to launch the application with (t for TextUI, a for AWTUI, s for SwingUI): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "t":
                gui = new TextUI();
                break;
            // case "a":
            // gui = new AWTUI();
            // break;
            case "s":
                gui = new SwingUI();
                break;
            default:
                gui = new SwingUI();
                break;
        }

        WeatherStation ws = new WeatherStation(gui);
        Thread thread = new Thread(ws);
        thread.start();
        scanner.close();
    }
}
