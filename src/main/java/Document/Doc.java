package Document;
import StructureData.DecisionTree;

import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Doc {
    public static boolean readDoc(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<String> words = new ArrayList<String>(Arrays.asList(line.split(" ")));
                String animal = words.remove(0);
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void fillAnswerDecisionTree(DecisionTree DTree, ArrayList<String> words, String answer) {
        String question = words.remove(0);
        if (words.size() == 0) {
            return;
        }
        if (question.equals("yes")) {
            fillAnswerDecisionTree(DTree.root.getYes(), words, answer);
        } else {
            fillAnswerDecisionTree(DTree.root.getNo(), words, answer);
        }
        DTree.root.addAnswer(answer);
    }
    public static void fillQuestionDecisionTree(DecisionTree DTree, String question){

        //
    }

    }


