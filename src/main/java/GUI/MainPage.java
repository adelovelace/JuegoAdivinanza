package GUI;

import Document.DocumentController;
import Game.Game;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Adivinanza.Adivinanza;
import javafx.geometry.*;
import javafx.scene.layout.VBox;

import static Adivinanza.Adivinanza.root;

public class MainPage {


    public MainPage() {
       mainMenu();
    }
    public void mainMenu(){
        VBox mainMenu = new VBox();
        Label subTitle = new Label("Te Atreves a Desafiar al Hechicero?");
        Styles.setStyleSubtittle(subTitle);
        Styles.setStyleVBox(mainMenu);
        Button playButton = new Button("Desafiar Al Hechicero");
        Styles.setButton1Style(playButton);
        playButton.setOnAction(e -> {
            preGame();
        });
        Button addDoc = new Button("Agregar Libros Sagrados");
        Styles.setButton1Style(addDoc);
        addDoc.setOnAction(e -> {
            addDoc();
        });
        Button exitButton = new Button("Salir");
        Styles.setButtonBackStyle(exitButton);
        exitButton.setOnAction(e -> {
            System.exit(0);
        });
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.getChildren().addAll(subTitle,playButton, addDoc, exitButton);
        root.setCenter(mainMenu);
    }
    public void addDoc() {
        VBox addDoc = new VBox();
        Styles.setStyleVBox(addDoc);
        Label subTitle = new Label("Agrega Los Libros Sagrados");
        Styles.setStyleSubtittle(subTitle);
        Button addDocButton = new Button("Agregar Preguntas");
        Styles.setButton1Style(addDocButton);
        addDocButton.setOnAction(e -> {
            DocumentController.saveQuestions();
        });
        Button addDocButton2 = new Button("Agregar Respuestas");
        addDocButton2.setOnAction(e -> {
            DocumentController.saveAnswers();
        });
        Styles.setButton1Style(addDocButton2);
        Button exitButton = new Button("Regresar");
        Styles.setButtonBackStyle(exitButton);
        exitButton.setOnAction(e -> {
            mainMenu();
        });
        addDoc.setAlignment(Pos.CENTER);
        addDoc.getChildren().addAll(subTitle,addDocButton,addDocButton2, exitButton);
        root.setCenter(addDoc);
    }
    public void preGame(){
        Game game = new Game();
        GridPane preGame = new GridPane();
        Styles.setStyleGridPane(preGame);
        Button selectQuestions = new Button("Seleccionar Pregunta");
        Styles.setButton1Style(selectQuestions);
        ComboBox<String> questions = new ComboBox<>();
        Styles.setStyleComboBox(questions);
        questions.getItems().addAll("+");
        questions.getItems().addAll(DocumentController.readQuestions());

        Button selectAnswers = new Button("Seleccionar Respuesta");
        Styles.setButton1Style(selectAnswers);
        ComboBox<String> answers = new ComboBox<>();
        Styles.setStyleComboBox(answers);
        answers.getItems().addAll("+");
        answers.getItems().addAll(DocumentController.readAnswers());

        answers.setOnAction(e -> {
            String selected = answers.getValue();
            System.out.println(selected);
            if(selected.equals("+")){
                DocumentController.saveAnswers();
            }
            else {
                game.setAnswersFile(selected);
            }
        });

        Button backButton = new Button("Regresar");
        Styles.setButtonBackStyle(backButton);
        Button playButton = new Button("Desafiar!");
        Styles.setButton1Style(playButton);
        playButton.setDisable(true);
        Button updateButton = new Button("Actualizar Libros");
        Styles.setButton1Style(updateButton);
        Label error = new Label("");

        selectAnswers.setOnAction(e -> {
            answers.setVisible(false);
            if (!questions.isVisible() && !answers.isVisible()) {
                playButton.setDisable(false);
            }
        });
        questions.setOnAction(e -> {
            String selected = questions.getValue();
            System.out.println(selected);
            if(selected.equals("+")){
                DocumentController.saveQuestions();
            }
            else {
                game.setQuestionsFile(selected);
            }
        });
        selectQuestions.setOnAction(e -> {
            questions.setVisible(false);
            if (!questions.isVisible() && !answers.isVisible()) {
                playButton.setDisable(false);
            }
        });
        updateButton.setOnAction(e -> {
            preGame();
        });
        backButton.setOnAction(e -> {
            mainMenu();
        });
        playButton.setOnAction(e -> {
            if(game.isReady()){
                preQuest(game);
            }
            else {
                error.setText("No Has Cargado Los Archivos Sagrados Correctamente: \n Actualiza y vuelve a Agregarlos");
                Styles.setStyleCaution(error);
            }

        });
        preGame.add(selectQuestions, 0, 0);
        preGame.add(questions, 1, 0);
        preGame.add(selectAnswers, 0, 1);
        preGame.add(answers, 1, 1);
        preGame.add(updateButton, 0, 2);
        preGame.add(playButton, 1, 2);
        preGame.add(backButton, 2, 2);
        preGame.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        Styles.setStyleVBox(vBox);
        Label subTitle = new Label("Selecciona Los Libros Sagrados de Preguntas Y respuestas\nLuego Presiona Los Botones Correctamente Para Jugar ");
        Styles.setStyleSubtittle(subTitle);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(subTitle,error,preGame);
        root.setCenter(vBox);
    }

public void preQuest(Game game){
        VBox caution = new VBox();
        Styles.setStyleVBox(caution);
        caution.setAlignment(Pos.CENTER);
        Label cautionLabel = new Label("Verifica que los Libros Sagrados sean los correctos");
        Label cautionLabel3 = new Label("Si no lo haces, no podras contra el Hechicero");
        Label questionLabel = new Label("Libro Sagrado de Preguntas: " + game.getQuestionsFile().getName());
        Label answerLabel = new Label("Libro Sagardo de Respuestas: " + game.getAnswersFile().getName());
        Styles.setStyleCaution(cautionLabel);
        Styles.setStyleSubtittle(cautionLabel3);
        Styles.setStyleVerification(questionLabel);
        Styles.setStyleVerification(answerLabel);
        Button yesButton = new Button("Enfrentar!");
        Styles.setButton1Style(yesButton);
        Button backButton = new Button("Regresar");
        Styles.setButtonBackStyle(backButton);
        backButton.setOnAction(e -> {
            preGame();
        });
        yesButton.setOnAction(e -> {
            startGame(game);
        });
        caution.getChildren().addAll(cautionLabel, cautionLabel3, questionLabel, answerLabel, yesButton, backButton);
        root.setCenter(caution);
    }
    public void startGame(Game game){
        game.prepareGame();
        GridPane startGame = new GridPane();
        startGame.setAlignment(Pos.CENTER);
        Label docsCharged = new Label("Eres Valiente, has cargado los Libros Sagrados\nAhora Piensa en Un Animal");

        Label selectQuestNumber = new Label("Te Permitire Seleccionar el Numero de Preguntas: ");
        Styles.setStyleSubtittle(docsCharged);
        Styles.setStyleSubtittle(selectQuestNumber);
        Button backButton = new Button("Regresar");
        Styles.setButtonBackStyle(backButton);
        Button playButton = new Button("Llego La Hora!");
        backButton.setOnAction(e -> {
            preGame();
        });
        Styles.setButton1Style(playButton);
        playButton.setDisable(true);
        ComboBox<Integer> numberQuestionsField = new ComboBox();
        Styles.setStyleComboBox(numberQuestionsField);
        numberQuestionsField.getItems().addAll(game.getArrayLevels());
        startGame.add(docsCharged, 0, 0);
        startGame.add(selectQuestNumber, 0, 1);
        startGame.add(numberQuestionsField, 1, 1);
        startGame.add(playButton, 1, 2);
        startGame.add(backButton, 0, 2);
        numberQuestionsField.setOnAction(e -> {
            game.setNumQuestions(numberQuestionsField.getValue());
            System.out.println("MainPageline168: "+numberQuestionsField.getValue());
            playButton.setDisable(false);
            playButton.setOnAction(e2 -> {
                new GameScreen(game);
            });
        });
        Adivinanza.root.setCenter(startGame);
    }


}