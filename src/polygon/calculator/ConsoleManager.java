package polygon.calculator;

import java.util.Scanner;

public class ConsoleManager {

    static Scanner scanner = new Scanner(System.in);

    public static final String TEXT_RED = "\u001B[31m";
    //public static final String TEXT_BLACK = "\u001B[30m";
    //public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    //public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    //public static final String TEXT_YELLOW = "\u001B[33m";
    //public static final String TEXT_WHITE = "\u001B[37m";

    public static void printMenu(){
        System.out.println(TEXT_BLUE + "=============== Calculadora de Polígonos ==================" + TEXT_RESET);
        Polygon.printOptions();
        System.out.printf("%4d. Sair\n", 9);
        System.out.println(TEXT_BLUE + "===========================================================" + TEXT_RESET);
    }

    public static int getChoice(){
        try {
            System.out.print("Digite o número da opção desejada: ");
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            return 0;
        }
    }

    public static void printExitMessage(){
        System.out.println(TEXT_RED + "\n Programa encerrado!" + TEXT_RESET);
    }

    public static void printPolygonCalculation(Polygon polygon){
        System.out.print(TEXT_CYAN);
        System.out.printf("\n --- Digite a(s) seguinte(s) medida(s) do %s ---\n", polygon.name);
        System.out.print(TEXT_RESET);
        System.out.printf("\tA área do %s é igual a: %.2f\n", polygon.name, polygon.calcArea.get());
        System.out.print(TEXT_CYAN);
        System.out.println(" " + ":".repeat(45 + polygon.name.length()) + "\n");
        System.out.print(TEXT_RESET);
    }

    public static void printInvalidOptionMessage(){
        System.out.println(TEXT_RED +"Opção inválida! Por favor, digite uma opção correta!" + TEXT_RESET);
    }

}
