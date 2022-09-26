package polygon.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class Polygon {
    static Scanner scanner = new Scanner(System.in);

    String name;
    Supplier<Double> calcArea;

    Polygon(String name, Supplier<Double> calcArea){
        this.name = name;
        this.calcArea = calcArea;
    }

    static Map<Integer, Polygon> polygonOptions = new HashMap<>();

    public static void loadOptions(){
        polygonOptions.put(1,
                new Polygon(
                        "Quadrado",
                        () -> {
                            return Math.pow(getMeasure("Lado"), 2);
                        }
                )
        );

        polygonOptions.put(2,
                new Polygon(
                        "Triângulo",
                        () -> {
                            return getMeasure("Base") * getMeasure("Altura") / 2;
                        }
                )
        );

        polygonOptions.put(3,
                new Polygon(
                        "Trapézio",
                        () -> {
                            return (getMeasure("Base maior") + getMeasure("Base menor")) * getMeasure("Altura") / 2;
                        }
                )
        );

        polygonOptions.put(4,
                new Polygon(
                        "Losango",
                        () -> {
                            return (getMeasure("Diagonal maior") * getMeasure("Diagonal menor") / 2);
                        }
                )
        );
    }

    public static void printOptions(){
        polygonOptions.forEach(
                ((integer, polygon) -> System.out.printf("%d. %s\n", integer, polygon.name))
        );
    }

    static double getMeasure(String measureName){
        System.out.printf("%s: ", measureName);
        return scanner.nextDouble();
    }

}
