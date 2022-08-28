package Document;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.LinkedList;

public class DocumentController {

    public static void saveDocument(String type) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {

                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream("src/documents/"+type +"/"+type+"-"+ file.getName());
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void saveAnswers(){
        saveDocument("answers");
    }
    public static void saveQuestions(){
        saveDocument("questions");
    }
    public static LinkedList readDirectory(String type){
        LinkedList<String> files = new LinkedList<>();
        File folder = new File("src/documents/"+type+"/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files.add(listOfFiles[i].getName());
            }
        }
        return files;

    }
    public static LinkedList readAnswers(){
        return readDirectory("answers");
    }
    public static LinkedList readQuestions(){
        return readDirectory("questions");
    }
}
