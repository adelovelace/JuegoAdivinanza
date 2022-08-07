package Game;

import StructureData.DecisionTree;
import java.util.Scanner;

public class Game {
    public static DecisionTree chargeInfo(){
        DecisionTree DTree = new DecisionTree("Es vertebrado?");
        DTree.root.addYes(new DecisionTree("Tiene 2 patas?"));
        DTree.root.addNo(new DecisionTree("Tiene 2 patas?"));
        return DTree;
    }
    public static int pregame(){
        int num =0;
        System.out.println("Bienvenido al juego de adivinar animales");
        System.out.println("Para empezar, piensa en un animal");
        System.out.println("Te realizare preguntas, debes responder con yes o no");
        System.out.println("Escribe la cantidad de preguntas que quieres responder:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            while(!input.chars().allMatch( Character::isDigit )) {
                try {
                    num = Integer.parseInt(input);
                    return num;
                } catch (Exception e) {
                    System.out.println("Por favor, ingrese un numero");
                    input = scanner.nextLine();
                }
            }
            return num;
    }


}
