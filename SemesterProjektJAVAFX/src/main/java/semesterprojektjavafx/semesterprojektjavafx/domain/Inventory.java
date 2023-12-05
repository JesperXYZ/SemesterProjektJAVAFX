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
                System.out.print(iItem);        //Printer item navnet
                System.out.print(" ");          //Printer et mellemrum
                System.out.print(iDescription); //Printer antallet/mængden af den specifikke item
                System.out.print(", ");         //Printer et mellemrum og et komma
            }
            if (i == inventoryStorage.size()-1) //Printer item+desc uden komma til sidst
            {
                System.out.print(iItem);        //Printer item navnet
                System.out.print(" ");          //Printer et mellemrum
                System.out.print(iDescription); //Printer antallet/mængden af den specifikke item
                System.out.print(" ");         //Printer et mellemrum
            }
        }
    }
}
