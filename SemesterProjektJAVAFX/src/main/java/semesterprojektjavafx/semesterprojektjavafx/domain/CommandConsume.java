package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.ArrayList;

public class CommandConsume extends BaseCommand implements Command {

    CommandConsume() {
        description = "You can consume the following items when they are in your inventory: apple, ice tea, milk, almonds";
    }

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("Consume what? 🤔");
            return;
        }
        consumeWhat(parameters[0]);

    }

    public void consumeWhat(String item) {

        ArrayList<String> iInventory = Context.getCurrentInventory();
        String iItem = item;

        if (iItem.equals("glucosemeter") || iItem.equals("insulininjector")) {
            System.out.println("You are confused and tried to eat " + iItem);
            return;
        }

        if (iInventory.contains(iItem)) {
        iInventory.remove(iItem);
        System.out.println("you have consumed "+iItem);
        System.out.print("Your inventory now contains:");
        Inventory.printInventory();
        ItemsDescription.impactGlucoseLevel(iItem);
        ItemsDescription.impactHungerLevel(iItem);
        return;
        }

        System.out.println("You are confused, there is no item called "+item+" in your inventory 😩");
    }
}
