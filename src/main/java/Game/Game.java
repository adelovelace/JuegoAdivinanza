package Game;

import StructureData.DecisionTree;
import java.util.Scanner;

public class Game {
    public static DecisionTree chargeInfo(){
        DecisionTree DTree = new DecisionTree("Es Mamifero?");
//        DTree.root.addYes(new DecisionTree("Es Carnivoro?"));
//        DTree.root.addNo(new DecisionTree("Es Carnivoro?"));
//        DTree.root.getYes().root.addYes(new DecisionTree("Se para en 4 patas?"));
//        DTree.root.getYes().root.addNo(new DecisionTree("Se para en 4 patas?"));
//        DTree.root.getNo().root.addYes(new DecisionTree("Se para en 4 patas?"));
//        DTree.root.getNo().root.addNo(new DecisionTree("Se para en 4 patas?"));
//        DTree.root.getYes().root.getYes().root.getYes().root.addAnswer("leon");
//        DTree.root.getYes().root.getYes().root.getNo().root.addAnswer("ballena");
//        DTree.root.getYes().root.getNo().root.getYes().root.addAnswer("venado");
//        DTree.root.getYes().root.getNo().root.getNo().root.addAnswer("Animal no encontrado");
//        DTree.root.getNo().root.getYes().root.getYes().root.addAnswer("Cocodrilo");
//        DTree.root.getNo().root.getYes().root.getNo().root.addAnswer("Tiburon");
//        DTree.root.getNo().root.getNo().root.getYes().root.addAnswer("Animal no encontrado");
//        DTree.root.getNo().root.getNo().root.getNo().root.addAnswer("Animal no encontrado");
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
