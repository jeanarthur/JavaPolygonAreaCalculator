package polygon.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Polygon.loadOptions();

        do{

            Polygon.printOptions();
            System.out.println("9. Sair\n");

            System.out.print("Digite o número da opção desejada: ");
            int choice = scanner.nextInt();

            if (choice == 9){
                System.out.println("Programa encerrado!");
                break;
            }
            else if (Polygon.polygonOptions.get(choice) != null){
                Polygon polygon = Polygon.polygonOptions.get(choice);
                System.out.printf("\n --- Digite as seguintes medidas do %s --- \n", polygon.name);
                System.out.printf(
                        "A área do %s é igual a: %.2f\n",
                        polygon.name, polygon.calcArea.get()
                );
                System.out.println("===============================================");
            }
            else {
                System.out.println("Opção inválida! Por favor, digite uma opção correta!\n");
            }

        } while (true);

    }

}
