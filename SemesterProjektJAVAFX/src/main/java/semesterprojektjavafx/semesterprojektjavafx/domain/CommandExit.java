package semesterprojektjavafx.semesterprojektjavafx.domain;/* Command for exiting program
 */

class CommandExit extends BaseCommand implements Command
{
  CommandExit()
  {
    description ="You quit the game";
  }
  @Override
  public void execute (Context context, String command, String parameters[]) {
    context.makeDone();
  }
}
