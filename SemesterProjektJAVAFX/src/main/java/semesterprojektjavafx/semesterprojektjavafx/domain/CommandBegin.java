package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.ArrayList;
import java.util.Scanner;
public class CommandBegin extends BaseCommand implements Command {
    static Scanner  scanner  = new Scanner(System.in);
    static boolean activityDone = false; //This boolean makes sure the activity of the day is done before the character can begin sleep
    //All arrays are either text that will show when doing an activity, input options or outcomes of the different activities
    static String[] activity = {"school", "work", "football", "gardening", "birthday", "clubbing"};
    static String[] begun = {"You have begun school! \n",
            "You have begun work! \n",
            "You have begun football! \n",
            "You have begun gardening! \n",
            "You have attended your friend Matt's birthday! \n",
            "You went to Proud Mary! \n"};
    static String[] question = {"You have a break. \n What do you do in your break?",
            "You are at work. \n What do you want to do?",
            "There is a scout at your practice! \n what do you do?",
            "Your mom need your help gardening for 7 hours! \n What do you do?",
            "There is both a big piece of cake and candy at the party. \n What do you choose?",
            "You need a drink(or many). \n What do you choose?"};
    String[] choices = {"Be active outside or relax inside",
            "Work hard and physical or see how little you can do in a day",
            "That's not for me or i'm going to be the next ronaldo",
            "Help or Leave",
            "Brownie or Kitkat",
            "Beer or Vodka&Juice"};
    static String[] choice1 = {"Be active outside", "Work hard ", "That life is not for me", "Help!", "Brownie", "Beer"};
    static String[] choice2 = {"Relax inside", "Less is more", "I'm going to be the next Ronaldo!", "leave", "KitKat", "Vodka-Juice"};
    static double[][] setLevel ={{-2,-3,-0.5,-1},{-1.5,-3,-0.5,-1},{-1,-3,-3,-5},{-2,-5,0,0},{2,2,2,1},{1,-3,3,0}};


    static String[] nightQuestion = {"Question of the day\n" +
                "Which of these lower your blood sugar?\n" +
                "Physical activity, food and drinks, public speaking, sleeping\n" +
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
    static String[] rightNightChoise = {"1", "1", "2", "4", "1", "3"};
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


        if (activity.equals(this.activity[day]) && activity.equals(Context.getCurrentActivity())){ //Checks if the input is the right activity of the day and the room
            boolean answer = false; //This boolean is used to make sure the input is one of the options
            System.out.println(begun[day]);
            System.out.println(question[day]);
            System.out.println(choices[day]);
            System.out.print("> ");
            String line = scanner.nextLine();

            if(line.equals(this.choice1[day]) || line.equals(this.choice2[day])){ //Checks if the input is one of the two input options
                answer=true;
            }
            while (answer==false){ //It the input is not one of the two options it will print that it's not an option and make a new scanner
                System.out.println("this is not a option. Pick " + choices[day]);
                System.out.print("> ");
                line = scanner.nextLine();

                if(line.equals(this.choice1[day]) || line.equals(this.choice2[day])){
                    answer=true;
                }
            }
            if (line.equals(this.choice1[day])) { //Changes glucoseLevel and hungerLevel depending on the input
                ItemsDescription.setGlucoseLevel(setLevel[day][0]);
                ItemsDescription.setHungerLevel(setLevel[day][1]);
                activityDone = true;
                System.out.println("You have finished today's activity!");
            }
            if (line.equals(this.choice2[day])){ //Changes glucoseLevel and hungerLevel depending on the input
                ItemsDescription.setGlucoseLevel(setLevel[day][2]);
                ItemsDescription.setHungerLevel(setLevel[day][3]);
                activityDone = true;
                System.out.println("You have finished today's activity!");
            }
        }
        if(activity.equals("sleep") && activityDone!=true && activity.equals(Context.getCurrentActivity())){ //Used if the input is "sleep" but the activity of the day is not finished
            System.out.println("you have to finish " + this.activity[day] + " before you can sleep");
        }
        if(activity.equals("sleep") && activityDone==true && activity.equals(Context.getCurrentActivity())){ //Used if the input is "sleep" and the activity of the dat is finished
            System.out.println(nightQuestion[day]);
            System.out.print("> ");
            String line = scanner.nextLine();
            AnswerSaver.saveAnswer("Dag: " + day + " - Svar:" + line);  //Metode til at gemme svar fra brugeren.
            boolean answer=false; //This boolean is used to make sure the input is one of the options

            if(line.equals(rightNightChoise[day])||line.equals(wrongNightChoise[day][0])||line.equals(wrongNightChoise[day][1])||line.equals(wrongNightChoise[day][2])){ //If the input is one of the options the boolean answers will be true
                answer=true;
            }

            while (answer==false){ //It the input is not one of the options it will print that it's not an option and make a new scanner
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
            if(inventory.contains("glucosemeter")){ //Removes "glucosemeter" from inventory
                inventory.remove("glucosemeter");
            }
        }
        if(!activity.equals(this.activity[day]) && !activity.equals("sleep") || !activity.equals(Context.getCurrentActivity())){ //If the input is not an activity it will print so
            System.out.println("you can't do this activity");
        }
    }

    public static String getActivity(){return activity[DayCount.getDay()];} //Used to get the activity of the day in RoomController.java

    public static String getBegun() {return begun[DayCount.getDay()];} //Used to get the string begun in ActivityController.java

    public static String getQuestion() {return question[DayCount.getDay()];} //Used to get the question to the activity in ActivityController.java

    public static String getChoice1() {return choice1[DayCount.getDay()];} //Used to get one of the two input options for the activity in ActivityController.java

    public static String getChoice2() {return choice2[DayCount.getDay()];} //Used to get the other one of the two input options for the activity ActivityController.java

    public static double getGlucose1(){return setLevel[DayCount.getDay()][0];} //Used to get the change of glucoseLevel on ActivityController.java
    public static double getGlucose2(){return setLevel[DayCount.getDay()][2];}
    public static double getHuger1(){return setLevel[DayCount.getDay()][1];} //Used to get the change of hungerLevel on ActivityController.java
    public static double getHuger2(){return setLevel[DayCount.getDay()][3];}
    public static boolean getActivityDone(){return activityDone;} //Used to know if the activity of the day is done in ActivityController.java
    public static void setActivityDone(boolean value){activityDone = value;} //Used to set activityDone in ActivityController.java

    public static String getRightNightChoice(){return rightNightChoise[DayCount.getDay()];} //Used to get the right answer to the nightQuestion in ActivityController.java
    public static String getNightQuestion() {return nightQuestion[DayCount.getDay()];} //Used to get the nightQuestion in ActivityController.java
}