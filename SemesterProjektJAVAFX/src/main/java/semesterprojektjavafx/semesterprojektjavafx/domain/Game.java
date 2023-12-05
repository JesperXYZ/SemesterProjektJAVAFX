package semesterprojektjavafx.semesterprojektjavafx.domain;/* Main class for launching the game
 */

import java.util.Scanner;

public class Game {
  static World world    = new World();
  public static Context  context  = new Context(world.getEntry());
  static Command  fallback = new CommandUnknown();
  static Registry registry = new Registry(context, fallback);
  static Scanner  scanner  = new Scanner(System.in);
  
  private static void initRegistry () {
    Command cmdExit = new CommandExit();
    registry.register("quit", cmdExit);
    registry.register("go", new CommandGo());
    registry.register("help", new CommandHelp(registry));
    registry.register("grab", new CommandPickUp());
    registry.register("consume", new CommandConsume());
    registry.register("begin", new CommandBegin());
    registry.register("check", new CommandCheck());
    registry.register("use", new CommandUse());
  }
  
  public static void main (String args[]) {
    System.out.println("\n    WELCOME TO \nMASTERING DIABETES!\n");
    System.out.println("\nThis game is about controlling blood sugar and dealing with various dilemmas");
    System.out.println("If your blood sugar gets too low or high, it's game over!");
    System.out.println("type in 'help' to see the different commands");
    
    initRegistry();
    context.getCurrent().welcome();
    
    while (context.isDone()==false) {
      boolean hungerLevelLow = false, hugerLevelHigh=false, glucoseLevelLow=false, glucoseLevelHigh=false;
      boolean win = false;
      while (context.isDone()==false && win==false && hungerLevelLow==false && hugerLevelHigh==false && glucoseLevelLow==false && glucoseLevelHigh==false) {
        System.out.print("\nWhat would you like to do?\n> ");
        String line = scanner.nextLine();
        registry.dispatch(line);
        if (ItemsDescription.hungerLevel <= 0) {hungerLevelLow = true;}
        if(ItemsDescription.hungerLevel > 10) {hugerLevelHigh = true;}
        if(ItemsDescription.getGlucoseLevel() <=3){glucoseLevelLow = true;}
        if(ItemsDescription.getGlucoseLevel() >=8){glucoseLevelHigh = true;}

        if (DayCount.getDay() == 6) {win = true;}
      }
      if(hungerLevelLow==true){
        System.out.println("You did not eat enough so you starved");
        Context.makeDone();
      }
      if(hugerLevelHigh==true){
        System.out.println("You ate more than you could");
        Context.makeDone();
      }
      if(glucoseLevelLow==true){
        System.out.println("Your glucose level got too low");
        Context.makeDone();
      }
      if(glucoseLevelHigh==true){
        System.out.println("Your glucose level got too high");
        Context.makeDone();
      }
      if(win==true) {
        System.out.println("You have mastered diabetes!");
        Context.makeDone();
      }
    }
    System.out.println("Game Over");
  }
}
