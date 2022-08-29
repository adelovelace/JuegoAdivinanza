package Game;

import Document.Doc;
import StructureData.DecisionTree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Doc questionsFile;
    private Doc answersFile;
    private DecisionTree<String> tree;
    private int maxLevel;
    private int numQuestions;


    public Game() {
        this.tree = new DecisionTree<>();
    }
    public boolean isReady(){
        return this.questionsFile != null && this.answersFile != null;
    }

    public DecisionTree<String> getTree() {
        return tree;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public ArrayList<Integer> getArrayLevels(){
        ArrayList<Integer> arrayLevels = new ArrayList<>();
        for (int i = 1; i < this.maxLevel; i++) {
            arrayLevels.add(i);
        }
        return arrayLevels;
    }

    public void setQuestionsFile(String filePath) {
        this.questionsFile = new Doc("src/documents/questions/"+filePath);
    }

    public void setAnswersFile(String filePath) {
        this.answersFile = new Doc("src/documents/answers/"+filePath);
    }
    public Doc getQuestionsFile() {
        return questionsFile;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public Doc getAnswersFile() {
        return answersFile;
    }

    public void prepareGame() {
        this.questionsFile.readDoc();
        this.answersFile.readDoc();
        this.tree.addQuestion(this.questionsFile.getWordsArray());
        this.tree.addAnswers(this.answersFile.getWordsArray(),this.tree);
        this.maxLevel = this.tree.levelCalc(this.tree.getRoot());
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    //    public static DecisionTree chargeInfo(){
//
//        DecisionTree DTree = new DecisionTree("Es Mamifero?");
//
//        return DTree;
//    }
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

//    public static void main(String[] args) {
//
//
//        Doc questions = new Doc("/Users/andrea/Documents/Espol/1T-2022/Estructura/Proyecto/2Parcial/preguntas.txt");
//        questions.readDoc();
//
//        Doc answers = new Doc("/Users/andrea/Documents/Espol/1T-2022/Estructura/Proyecto/2Parcial/respuestas.txt");
//        answers.readDoc();
//
//        DecisionTree <String> decisionTree = new DecisionTree();
//
//        for (int i =0; i < questions.getWordsArray().size(); i++) {
//            System.out.println(questions.getWordsArray().get(i));
//        }
//
//        decisionTree.addQuestion(questions.getWordsArray());
//        System.out.println(decisionTree.breadthTraversal());
//
//
//        for (int i =0; i < answers.getWordsArray().size(); i++) {
//            System.out.println(answers.getWordsArray().get(i));
////            decisionTree.addAnswers(answers.getWordsArray(),decisionTree);
//
//        }
//
////        System.out.println(decisionTree.breadthTraversal());
//
//
//
//
//
//    }



}
