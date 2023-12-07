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
            if (!answersFile.exists()) {
                answersFile.createNewFile();
            }

            pw = new PrintWriter(new FileWriter(answersFile, true));
            // ,true laver det til append tilstand som gør at den gamle fil ikke overrides, og dermed tilføjer svar til den gamle fil.
            pw.println("Brugernes svar: " + answer);
            pw.close();
            System.out.println("Answer saved");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving answer: " + e.getMessage()); // Print a user-friendly error message
        }
    }
}
