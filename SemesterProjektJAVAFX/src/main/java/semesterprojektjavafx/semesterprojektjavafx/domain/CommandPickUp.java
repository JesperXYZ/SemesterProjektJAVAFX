package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.Objects;

public class CommandPickUp extends BaseCommand implements Command{

    CommandPickUp () {description = "You can grab the items available in the room and place them in your inventory";}

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1))
        {
            System.out.println("Grab what? 🤔");
            return;
        }
        grabWhat(parameters[0]);
    }
    public static void grabWhat(String item) {

        String[] iInventory = Context.getCurrentAvailableItems();
        String iItem = item;

        int ix;
        for (ix = 0; ix<iInventory.length; ix++)
        {
            if (Objects.equals((iInventory[ix]), iItem)) {
                Inventory.inventoryStorage.add((iInventory[ix]));
                System.out.println("You grabbed "+iInventory[ix]);
                System.out.print("Your inventory now contains:");
                Inventory.printInventory();
                System.out.println("");
                return;
            }

        }
        System.out.println("You are confused, there is no item available called "+item+" 😩");
    }
}
