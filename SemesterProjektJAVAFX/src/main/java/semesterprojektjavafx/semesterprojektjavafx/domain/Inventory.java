package semesterprojektjavafx.semesterprojektjavafx.domain;

import java.util.ArrayList;

public class Inventory {

    public static ArrayList<String> inventoryStorage = new ArrayList<>();


    public static void printInventory() {
        for (int i = 0; i<inventoryStorage.size(); i++)
        {
            String iItem = inventoryStorage.get(i);
            String iDescription = ItemsDescription.getDescription(iItem);
            if (i < inventoryStorage.size()-1)
            {
                System.out.print(iItem);
                System.out.print(" ");
                System.out.print(iDescription);
                System.out.print(", ");
            }
            if (i == inventoryStorage.size()-1)
            {
                System.out.print(iItem);
                System.out.print(" ");
                System.out.print(iDescription);
                System.out.print(" ");
            }
        }
    }

    public static int getInventoryStorage(){
        return inventoryStorage.size();
    }
}
