package polygon.calculator;

import java.util.*;
import java.util.function.Supplier;

public class Polygon {
    static Scanner scanner = new Scanner(System.in);

    String name;
    Supplier<Double> calcArea;

    Polygon(String name, Supplier<Double> calcArea){
        this.name = name;
        this.calcArea = calcArea;
    }

    static List<Polygon> polygons = new ArrayList<>();
    static Map<Integer, Polygon> polygonOptions = new HashMap<>();

    public static void createPolygons(){
        polygons.add(
                new Polygon(
                        "Quadrado",
                        () -> {
                            return Math.pow(getMeasure("Lado"), 2);
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Triângulo",
                        () -> {
                            return getMeasure("Base") * getMeasure("Altura") / 2;
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Trapézio",
                        () -> {
                            return (getMeasure("Base maior") + getMeasure("Base menor")) * getMeasure("Altura") / 2;
                        }
                )
        );

        polygons.add(
                new Polygon(
                        "Losango",
                        () -> {
                            return (getMeasure("Diagonal maior") * getMeasure("Diagonal menor") / 2);
                        }
                )
        );

        /*polygons.add(
                new Polygon(
                        "Triângulo Equilátero",
                        () -> {
                            return (Math.pow(getMeasure("Lado"), 2) * Math.sqrt(3) / 54);
                        }
                )
        );*/
    }

    public static void loadOptions(){
        createPolygons();
        for (int i = 0; i < 9 && i < polygons.size(); i++){
            polygonOptions.put(i+1, polygons.get(i));
        }
    }

    public static void printOptions(){
        polygonOptions.forEach(
                ((integer, polygon) -> System.out.printf("%4d. %s\n", integer, polygon.name))
        );
    }

    static double getMeasure(String measureName){
        System.out.printf("\t%s: ", measureName);
        return scanner.nextDouble();
    }

}
