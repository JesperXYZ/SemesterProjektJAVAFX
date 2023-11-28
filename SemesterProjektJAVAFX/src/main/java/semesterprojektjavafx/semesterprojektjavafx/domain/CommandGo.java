package semesterprojektjavafx.semesterprojektjavafx.domain;/* Command for transitioning between spaces
 */

class CommandGo extends BaseCommand implements Command {
  CommandGo () {
    description = "You can go to your current locations exits, use 'check location' to see your current locations exits";
  }
  
  @Override
  public void execute (Context context, String command, String[] parameters) {
    if (guardEq(parameters, 1)) {
      System.out.println("I don't seem to know where that is 🤔");
      return;
    }
    context.transition(parameters[0]);
  }
}
