package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.ArrayList;
import java.util.Scanner;
public class CommandBegin extends BaseCommand implements Command {
    static Scanner  scanner  = new Scanner(System.in);
    boolean activityDone = false;
    String[] activity = {"school", "work", "football", "gardening", "birthday", "clubbing"};
    String[] begun = {"you have begun school!",
            "you have begun work!",
            "you have begun football!",
            "you have begun gardening!",
            "you have antended your friend Matts birthday!",
            "you went to Proud Mary!"};
    String[] question = {"you have a break, what do you do in your break?",
            "you are at work, what do you want to do?",
            "what mindset do you have?",
            "your mom need you to help gardening for 7 hours! what do you do?",
            "there is both a big piece of cake and candy at the party. what do you choose?",
            "you need a drink(or many). what do you choose?"};
    String[] choices = {"basket or chillaxing",
            "grind for raise or browse TikTok",
            "loser mindset or ronaldo mindset",
            "help or leave",
            "brunsviger or Kitkat",
            "beer or vodkajuice"};
    String[] choice1 = {"basket", "grind", "loser", "help", "brunsviger", "beer"};
    String[] choice2 = {"chillaxing", "browse", "ronaldo", "leave", "KitKat", "vodkajuice"};
    double[][] setLevel ={{-2,-3,-0.5,-1},{-1.5,-3,-0.5,-1},{-1,-5,-3,-5},{-3,-5,0,0},{3,2,3,1},{1,-3,3,0}};

    String[] nightQuestion = {"Question of the day\n" +
                "Which of these lower your blood sugar?\n" +
                "Physical activity, food and drinks, using insulin, sleeping\n" +
                "Pick 1, 2, 3 or 4\n",
            "Question of the day\n" +
                    "What do you blood sugar level have to be to maintain a normal level?\n" +
                    "4-7 mmml/l, 2-9 mmml/l, 4-9 mmml/l, 2-7 mmml/l\n" +
                    "Pick 1, 2, 3 or 4\n",
            "Question of the day\n" +
                    "How dose alcohol affect your blood sugar?\n" +
                    "It gets higer and you have to use insulin, it falls and you have to eat or drink,\n alcohol hase no affect on on your blood sugar, alcohol can make your blood sugar rise and fall you can therefor not drink alcohol if you have diabetes" +
                    "Pick 1, 2, 3 or 4\n",
            "Question of the day\n" +
                    "Which og these make you blood sugar rise the most?\n" +
                    "Milk (250 ml), almonds (15 g), Iced tea (250 ml), an apple (110 g)\n" +
                    "Pick 1, 2, 3 or 4\n",
            "Question of the day\n" +
                    "How dose insulin affect your blood sugar?\n" +
                    "Insulin signals to the muscles, adipose tissue and lever to consume sugar from the blood. Thereby insulin lower the blood sugar,\n insulin stimulate the production of glucose: it produce glucose in the lever which increases the blood sugar,\n" +
                    " insulin works as a sugerstimulating hormone: It signals to the cells to increase the production of sugar to the blood resulting in an increases of the blood sugar,\n" +
                    " insulin makes the muscles unable to consume sugar while making the lever produce more sugar increasing the blood sugar\n" +
                    "Pick 1, 2, 3 or 4\n",
            "Question of the day\n" +
                    "Which type of carbohydrate have a tendency to affect the blood sugar more dramatically then other types og carbohydrates?\n" +
                    "Complex carbohydrates such as whole grain products, fat has a bigger affect on the blood sugar than carbohydrates,\n simple carbohydrates such as sugar has a tendency to make the blood sugar rise quickly, protein has no affect on the blood sugar\n" +
                    "Pick 1, 2, 3 or 4\n"};
    String[] rightNightChoise = {"1", "1", "2", "4", "1", "3"};
    String[][] wrongNightChoise = {{"2", "3", "4"}, {"2", "3", "4"}, {"1", "3", "4"}, {"1", "2", "3"},{"2","3","4"},{"1","2","4"}};

    CommandBegin() {
        description = "You can begin the following activities when they are available: sleep, school, work, football, gardening, birthday, clubbing";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("begin what? 🤔");
            return;
        }
        beginWhat(parameters[0]);
    }
    public void beginWhat(String activity) {
        int day = DayCount.getDay();

        if (activity.equals(this.activity[day]) && activity.equals(Context.getCurrentActivity())){
            boolean answer = false;
            System.out.println(begun[day]);
            System.out.println(question[day]);
            System.out.println(choices[day]);
            System.out.print("> ");
            String line = scanner.nextLine();

            if(line.equals(this.choice1[day]) || line.equals(this.choice2[day])){
                answer=true;
            }
            while (answer==false){
                System.out.println("this is not a option. Pick " + choices[day]);
                System.out.print("> ");
                line = scanner.nextLine();

                if(line.equals(this.choice1[day]) || line.equals(this.choice2[day])){
                    answer=true;
                }
            }
            if (line.equals(this.choice1[day])) {
                ItemsDescription.setGlucoseLevel(setLevel[day][0]);
                ItemsDescription.setHungerLevel(setLevel[day][1]);
                activityDone = true;
                System.out.println("You have finished today's activity!");
            }
            if (line.equals(this.choice2[day])){
                ItemsDescription.setGlucoseLevel(setLevel[day][2]);
                ItemsDescription.setHungerLevel(setLevel[day][3]);
                activityDone = true;
                System.out.println("You have finished today's activity!");
            }
        }
        if(activity.equals("sleep") && activityDone!=true && activity.equals(Context.getCurrentActivity())){
            System.out.println("you have to finish " + this.activity[day] + " before you can sleep");
        }
        if(activity.equals("sleep") && activityDone==true && activity.equals(Context.getCurrentActivity())){
            System.out.println(nightQuestion[day]);
            System.out.print("> ");
            String line = scanner.nextLine();
            AnswerSaver.saveAnswer("Dag: " + day + " - Svar:" + line);  //Metode til at gemme svar fra brugeren.
            boolean answer=false;

            if(line.equals(rightNightChoise[day])||line.equals(wrongNightChoise[day][0])||line.equals(wrongNightChoise[day][1])||line.equals(wrongNightChoise[day][2])){
                answer=true;
            }

            while (answer==false){
                System.out.println("That is not an option\nPick 1, 2, 3 or 4");
                System.out.print("> ");
                line = scanner.nextLine();

                if(line.equals(rightNightChoise[day])||line.equals(wrongNightChoise[day][0])||line.equals(wrongNightChoise[day][1])||line.equals(wrongNightChoise[day][2])){
                    answer=true;
                }
            }

            if(line.equals(rightNightChoise[day])){
                System.out.println("That is right!");
            }
            if(line.equals(wrongNightChoise[day][0])||line.equals(wrongNightChoise[day][1])||line.equals(wrongNightChoise[day][2])) {
                System.out.println("That is not the right answer...\nIf you keep playing you might learn it");
            }

            DayCount.plusDay(1);
            System.out.println(("it's a new day and the activity of today is: " + this.activity[day+1]));
            activityDone = false;

            ArrayList<String> inventory = Context.getCurrentInventory();
            if(inventory.contains("glucosemeter")){
                inventory.remove("glucosemeter");
            }
        }
        if(!activity.equals(this.activity[day]) && !activity.equals("sleep") || !activity.equals(Context.getCurrentActivity())){
            System.out.println("you can't do this activity");
        }
    }
}