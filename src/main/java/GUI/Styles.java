package GUI;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Styles {
    static Insets basicInsets = new Insets(10, 10, 10, 10);
    public static void setButton1Style(Button button) {
        button.setStyle("-fx-background-color: #00bfff; -fx-text-fill: #ffffff;" +
                "-fx-font-size: 20px; -fx-font-weight: bold;" +
                "-fx-border-color: #00bfff; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                "-fx-padding: 5px;" +
                "-fx-pref-width: 250px; -fx-pref-height: 50px;" +
                "-fx-background-radius: 5px;");
        button.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                button.setStyle("-fx-background-color: #ffffff; -fx-text-fill:#00bfff ;" +
                        "-fx-font-size: 20px; -fx-font-weight: bold;" +
                        "-fx-border-color: #00bfff; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                        "-fx-padding: 5px;" +
                        "-fx-pref-width: 250px; -fx-pref-height: 50px;" +
                        "-fx-background-radius: 5px; ");
            } else {
                button.setStyle("-fx-text-fill:#ffffff ;  -fx-background-color:#00bfff;" +
                        "-fx-font-size: 20px; -fx-font-weight: bold;" +
                        "-fx-border-color: #00bfff; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                        "-fx-padding: 5px;" +
                        "-fx-pref-width: 250px; -fx-pref-height: 50px;" +
                        "-fx-background-radius: 5px;");
            }
        });
    }

    public static void setButtonBackStyle(Button button) {
        button.setStyle("-fx-background-color: #e00440; -fx-text-fill: #ffffff;" +
                "-fx-font-size: 20px; -fx-font-weight: bold;" +
                "-fx-border-color: #e00440; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                "-fx-padding: 5px;" +
                "-fx-pref-width: 200px; -fx-pref-height: 50px;" +
                "-fx-background-radius: 5px;");
        button.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                button.setStyle("-fx-background-color: #ffffff; -fx-text-fill:#e00440 ;" +
                        "-fx-font-size: 20px; -fx-font-weight: bold;" +
                        "-fx-border-color: #e00440; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                        "-fx-padding: 5px;" +
                        "-fx-pref-width: 200px; -fx-pref-height: 50px;" +
                        "-fx-background-radius: 5px; ");
            } else {
                button.setStyle("-fx-text-fill:#ffffff ;  -fx-background-color:#e00440;" +
                        "-fx-font-size: 20px; -fx-font-weight: bold;" +
                        "-fx-border-color: #e00440; -fx-border-width: 2px; -fx-border-radius: 5px;" +
                        "-fx-padding: 5px;" +
                        "-fx-pref-width: 200px; -fx-pref-height: 50px;" +
                        "-fx-background-radius: 5px;");
            }
        });
    }

    public static void setStyleVBox(VBox vBox) {
        vBox.setPadding(basicInsets);
        vBox.setSpacing(10);
    }
    public static void setStyleGridPane(GridPane gridPane) {
        gridPane.setPadding(basicInsets);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

    }
    public static void setStyleSubtittle(Label label){
        label.setFont(Font.loadFont("file:src/fonts/Angel Wish.otf", 40));
        label.setStyle("-fx-text-fill: #ffffff; -fx-text-alignment: center;");
    }
    public static void setStyleCaution(Label label){
        label.setFont(Font.loadFont("file:src/fonts/Angel Wish.otf", 45));
        label.setStyle("-fx-text-fill: #e00440; -fx-text-alignment: center;-fx-stroke: gold; -fx-stroke-width: 2px;");
    }
    public static void setStyleVerification(Label label){
        label.setFont(Font.loadFont("file:src/fonts/Angel Wish.otf", 40));
        label.setStyle("-fx-text-fill: gold; -fx-text-alignment: center;-fx-stroke: #e00440; -fx-stroke-width: 2px;");
    }
    public static void setStyleComboBox(ComboBox comboBox){
        comboBox.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ffffff;-fx-text-alignment: center;");
    }
    public static void setStyleTextField(TextField tf){
        tf.setMaxSize(300, 30);
        tf.setFont(Font.loadFont("file:src/fonts/Angel Wish.otf", 22));
        tf.setStyle("-fx-text-fill: #000000; -fx-text-alignment: center;");
    }
}
