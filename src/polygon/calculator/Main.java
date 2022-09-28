package polygon.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Polygon.loadOptions();

        do{
            ConsoleManager.printMenu();
            int choice = ConsoleManager.getChoice();

            if (choice == 9){
                ConsoleManager.printExitMessage();
                break;
            }
            else if (Polygon.polygonOptions.get(choice) != null){
                Polygon polygon = Polygon.polygonOptions.get(choice);
                ConsoleManager.printPolygonCalculation(polygon);
            }
            else {
                ConsoleManager.printInvalidOptionMessage();
            }

        } while (true);

    }
}
