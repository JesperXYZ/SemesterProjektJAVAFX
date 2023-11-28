package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.ArrayList;

public class CommandUse extends BaseCommand implements Command{
    CommandUse() {
        description = "You can use the following items when they are in your inventory: insulininjector, glucosemeter";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("Use what? 🤔");
            return;
        }
        useWhat(parameters[0]);

    }

    public void useWhat(String item){
        ArrayList<String> iInventory = Context.getCurrentInventory();
        if (iInventory.contains(item) && item.equals("insulininjector")) {
            System.out.println("you have used "+item);
            System.out.println("your glucoselevel will now drop");
            ItemsDescription.impactGlucoseLevel(item);
            ItemsDescription.impactHungerLevel(item);
            return;
        }
        if (iInventory.contains(item) && item.equals("glucosemeter")) {
            System.out.println("you have used "+item);
            System.out.println("your current glucoselevel is: "+ItemsDescription.getGlucoseLevel() + "mmml/l");
            return;
        }
        else
        {
            System.out.println("You are confused, you do not have a usable item called "+item+" 😩");
        }
    }
}