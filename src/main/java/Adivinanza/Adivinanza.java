package Adivinanza;

import GUI.MainPage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Adivinanza extends Application {
    public static BorderPane root = new BorderPane();
    public static MainPage mp = new MainPage();

    public BorderPane getRoot() {
        return root;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        File icono = new File("src/assets/icon.jpg");
        File ak = new File("src/assets/hechicero.png");
        File bg = new File("src/assets/bg.jpg");
        Scene scene = new Scene(getRoot(), 800, 600);
        primaryStage.setTitle("Adivinanza");
        Label label = new Label("El Hechicero Sabe En Que Animal Piensas");
        label.setStyle("-fx-text-fill: white;-fx-text-alignment: center;");
        label.setFont(Font.loadFont("file:src/fonts/The Centurion.otf", 72));
        HBox hbox = new HBox(label);
        hbox.setAlignment(Pos.CENTER);
        root.setTop(hbox);
        try {
            primaryStage.getIcons().add(new Image(new FileInputStream(icono.getAbsolutePath())));
            Image image = new Image(new FileInputStream(bg.getAbsolutePath()));
            root.setBackground(new Background (new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            VBox vb = new VBox();
            vb.setAlignment(Pos.BOTTOM_LEFT);
            root.setLeft(vb);
            vb.getChildren().add(new ImageView( new Image(new FileInputStream(ak.getAbsolutePath()))));
        } catch (Exception e) {
            System.out.println("No se pudo cargar el icono");
        }

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}

