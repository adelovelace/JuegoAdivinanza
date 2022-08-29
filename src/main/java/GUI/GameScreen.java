package GUI;

import Adivinanza.Adivinanza;
import Game.Game;
import StructureData.DecisionTree;
import StructureData.Node;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import java.util.ArrayList;

public class GameScreen {
    Game game;
    DecisionTree<String> tree;

    public GameScreen(Game game) {
        this.game = game;
        this.tree = game.getTree();
        GameInit(tree.getRoot());
    }

    public void GameInit(Node<String> node) {
        System.out.println("line 22 GameScreen: cantidad de preguntas:"+game.getNumQuestions());
        if (game.getNumQuestions() > 0) {
            VBox gameView = new VBox();
            Styles.setStyleVBox(gameView);
            gameView.setAlignment(Pos.CENTER);
            Label subTitle = new Label(node.getData());
            Styles.setStyleSubtittle(subTitle);
            gameView.getChildren().add(subTitle);
            Button yesButton = new Button("SI");
            Button noButton = new Button("NO");
            Styles.setButton1Style(yesButton);
            Styles.setButton1Style(noButton);
            yesButton.setOnAction(e -> {
                System.out.println("numero de preguntas antes de quitar GAmesScreen (si) 32"+game.getNumQuestions());
                game.setNumQuestions(game.getNumQuestions() - 1);
                GameInit(node.getLeft());
            });
            noButton.setOnAction(e -> {
                System.out.println("numero de preguntas antes de quitar GAmesScreen (no)37"+game.getNumQuestions());
                game.setNumQuestions(game.getNumQuestions() - 1);
                GameInit(node.getRight());
            });
            gameView.getChildren().addAll(yesButton, noButton);
            Adivinanza.root.setCenter(gameView);
        } else {
            finishGame(node);
        }
    }

    public void finishGame(Node<String> node) {
        VBox gameView = new VBox();
        Styles.setStyleVBox(gameView);
        gameView.setAlignment(Pos.CENTER);
        ArrayList<String> answers = tree.getArrayLeaves(node);
        if(answers.size() == 0) {
            Label label = new Label("No Se Que Animal Es");
            Styles.setStyleSubtittle(label);
            gameView.getChildren().add(label);
            gameView.getChildren().add(inputCorrectAnimal());
        }
        if (answers.size() == 1) {
            Label animal = new Label(answers.get(0));
            Label label = new Label("El animal en el que Piensas es: ");
            Styles.setStyleSubtittle(label);
            Styles.setStyleVerification(animal);
            gameView.getChildren().addAll(label, animal);
            Button yesButton = new Button("SI");
            Button noButton = new Button("NO");
            Styles.setButton1Style(yesButton);
            Styles.setButton1Style(noButton);
            gameView.getChildren().addAll(yesButton, noButton);

            yesButton.setOnAction(e -> {
                finalScreen(animal.getText(), false);
            });
            noButton.setOnAction(e -> {
                gameView.getChildren().clear();
                gameView.getChildren().add(inputCorrectAnimal());
            });


        }
        if (answers.size() > 1) {
            Label label = new Label("El animal en el que Piensas es : ");
            Styles.setStyleSubtittle(label);
            gameView.getChildren().add(label);
            for (int i = 0; i < 3 && i< answers.size(); i++) {
                Button animalButton = new Button(answers.get(i));
                Styles.setButton1Style(animalButton);
                animalButton.setOnAction(e -> {
                    finalScreen(animalButton.getText(), true);
                });
                gameView.getChildren().add(animalButton);
            }
            Button loseButton = new Button("No esta en la Lista");
            Styles.setButton1Style(loseButton);
            gameView.getChildren().add(loseButton);
            loseButton.setOnAction(e -> {
                gameView.getChildren().clear();
                gameView.getChildren().add(inputCorrectAnimal());
            });
        }
        Adivinanza.root.setCenter(gameView);
    }

    public VBox inputCorrectAnimal(){
        VBox inputCorrectAnimal = new VBox();
        Styles.setStyleVBox(inputCorrectAnimal);
        Label inputAnimal = new Label("ME HAS VENCIDO \nIntroduce el animal en el que pensabas: ");
        Styles.setStyleSubtittle(inputAnimal);
        TextField animal = new TextField();
        Styles.setStyleTextField(animal);
        Button okButton = new Button("ok");
        Styles.setButton1Style(okButton);
        okButton.setOnAction(e -> {
            finalScreen(animal.getText(), true);
        });
        inputCorrectAnimal.setAlignment(Pos.CENTER);
        inputCorrectAnimal.getChildren().addAll(inputAnimal, animal, okButton);
        return inputCorrectAnimal;
    }
    public void finalScreen(String animal, boolean derrotaPlayer){
        VBox finalPresentation = new VBox();
        Styles.setStyleVBox(finalPresentation);
        finalPresentation.setAlignment(Pos.CENTER);
        String message = "Ahora Tengo Mas Conocimiento Que Antes\n \n Se Mas Acerca del animal "+animal+" \n\n Pronto Nos Volveremos A Encontrar";
        if(derrotaPlayer){
            message += "Y Te Volvere a Ganar";
        }
        Label finalLabel = new Label(message);
        Styles.setStyleVerification(finalLabel);
        Button returnButton = new Button("Te Reto Otra Vez");
        Styles.setButton1Style(returnButton);
        returnButton.setOnAction(e -> {
            Adivinanza.mp.preGame();
        });
        Button exitButton = new Button("Asi Sera!!!!");
        Styles.setButtonBackStyle(exitButton);
        exitButton.setOnAction(e -> {
            Adivinanza.mp.mainMenu();
        });
        finalPresentation.getChildren().addAll(finalLabel, returnButton, exitButton);
        Adivinanza.root.setCenter(finalPresentation);


    }

}


