package Document;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Doc<E> {

    String path;
    ArrayList<E> wordsArray = new ArrayList<E>();


    public Doc(String filePath){
        this.path = filePath;
    }

    public ArrayList<E> readDoc() {



        File file = new File(this.path);
        if (!file.exists()) {
            System.out.println("The file doens't exist!");
            return this.wordsArray;
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.wordsArray.add((E) line);
//                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            return wordsArray;
        }
        return wordsArray;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<E> getWordsArray() {
        return wordsArray;
    }

    public void setWordsArray(ArrayList<E> wordsArray) {
        this.wordsArray = wordsArray;
    }
}


