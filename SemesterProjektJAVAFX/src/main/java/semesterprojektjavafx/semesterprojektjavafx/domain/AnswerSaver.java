package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AnswerSaver {

    public static void saveAnswer(String answer) {
        File answersFile = new File("answers.txt");
        PrintWriter pw;

        try {
            if (!answersFile.exists()) { //If there is no file it creates a file
                answersFile.createNewFile();
            }

            pw = new PrintWriter(new FileWriter(answersFile, true));
            // ,true makes it append which makes sure to old file do not get overridden and instead adds it to the old file
            pw.println("Brugernes svar: " + answer);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
