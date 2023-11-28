package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.Set;

public class CommandCheck extends BaseCommand implements Command {

    CommandCheck() {description = "You can check the following things for their status/availability: inventory, day, activities, location";}

    @Override
    public void execute(Context context, String command, String[] parameters) {
        if (guardEq(parameters, 1)) {
            System.out.println("Check what? 🤔");
            return;
        }
        checkWhat(parameters[0]);
    }
    public void checkWhat (String check) {

        String iCheck = check;

        if (iCheck.equals("inventory")) {
            Inventory.printInventory();
        }
        if (iCheck.equals("day")) {
            System.out.println(DayCount.getDay() + 1);
        }
        if (iCheck.equals("location") || iCheck.equals("exits")) {
            System.out.println("You are currently at: " + Context.getCurrent().getName());
            System.out.println("Your current exits are: ");
            Set<String> exits = Context.getCurrent().edges.keySet();
            for (String exit : exits) {
                System.out.print(exit + "\n");
            }
        }
        if (iCheck.equals("hunger")) {
            System.out.println("Your current hunger level is: " + ItemsDescription.getHungerLevel());
        }

        if (iCheck.equals("activities")) {
            int iDay = DayCount.getDay();
            if (iDay == 0)
            {
                System.out.println("The activity available today is: school");
            }
            if (iDay == 1)
            {
                System.out.println("The activity available today is: work");
            }
            if (iDay == 2)
            {
                System.out.println("The activity available today is: football");
            }
            if (iDay == 3)
            {
                System.out.println("The activity available today is: gardening");
            }
            if (iDay == 4)
            {
                System.out.println("The activity available today is: birthday");
            }
            if (iDay == 5)
            {
                System.out.println("The activity available today is: clubbing");
            }
        }
    }
}