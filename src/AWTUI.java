// /*
// * Initial Author
// * Michael J. Lutz
// *
// * Other Contributers
// *
// * Acknowledgements
// */

// /*
// * AWT UI class used for displaying the information from the
// * associated weather station object.
// * This is an extension of JFrame, the outermost container in
// * a AWT application.
// */

// import java.awt.*;
// import java.awt.event.*;
// import java.util.EnumMap;

// public class AWTUI extends Frame implements WeatherStationUI {

// TemperatureSensor sensor = new TemperatureSensor();

// // store label values in this map
// private EnumMap<TemperatureUnit, Label> labelMap;
// /*
// * A Font object contains information on the font to be used to
// * render text.
// */
// private static Font labelFont = new Font(Font.SERIF, Font.PLAIN, 72);

// /*
// * Create and populate the AWTUI JFrame with panels and labels to
// * show the temperatures.
// */
// public AWTUI() {
// super("Weather Station - AWTUI");
// // initializes map
// labelMap = new EnumMap<>(TemperatureUnit.class);

// /*
// * WeatherStation frame is a grid of 1 row by an indefinite number
// * of columns.
// */
// setLayout(new GridLayout(1, 0));

// labelMap = new EnumMap<>(TemperatureUnit.class);
// this.setLayout(new GridLayout(1, 0));
// Panel panel = null;
// Label label = null;
// for (TemperatureUnit unit : TemperatureUnit.values()) {
// panel = createPanel(unit);
// label = createLabel(unit.name(), panel);
// labelMap.put(unit, label);
// label.setFont(new Font(Font.SERIF, Font.PLAIN, 72));
// this.add(panel, label);
// }
// /*
// * Set up the window's default close operation and pack its elements.
// */
// addWindowListener(
// new WindowAdapter() {
// public void windowClosing(WindowEvent windowEvent) {
// handleClosing();
// }
// });

// /*
// * Pack the components in this frame and make the frame visible.
// */
// pack();
// setVisible(true);
// }

// public void handleClosing() {
// System.out.println("Closing the application....");
// System.exit(0);
// }

// /**
// * Sets the labels
// *
// * @param unit
// * @param value
// */
// private void setLabel(TemperatureUnit unit, double value) {
// labelMap.get(unit).setText(String.format("%6.2f", value));
// }

// /***
// * Creates a Panel/ sets the label and
// *
// * @param {TemperatureUnit} unit - The Type of Unit used for to show
// temperature
// * @return The panel that will be added to the view
// */
// public Panel createPanel(TemperatureUnit unit) {
// Panel panel = new Panel(new GridLayout(2, 1));
// createLabel(" " + unit + " ", panel);
// return panel;
// }

// /*
// * Create a Label with the initial value <title>, place it in
// * the specified <panel>, and return a reference to the Label
// * in case the caller wants to remember it.
// */
// private Label createLabel(String title, Panel panel) {
// Label label = new Label(title);
// label.setAlignment(Label.CENTER);
// label.setFont(labelFont);
// panel.add(label);

// return label;
// }

// /**
// * Update values for the AWTUI interface
// *
// * @param reading - the value for the sensor that is currently reading
// */
// @Override
// public void update(int reading) {
// for (TemperatureUnit unit : TemperatureUnit.values()) {
// setLabel(unit, unit.get(reading));
// }
// }
// }
