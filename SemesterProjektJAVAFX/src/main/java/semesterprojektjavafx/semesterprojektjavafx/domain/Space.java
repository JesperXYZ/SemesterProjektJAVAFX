package semesterprojektjavafx.semesterprojektjavafx.domain;/* Space class for modeling spaces (rooms, caves, ...)
 */

import java.util.Set;
public class Space extends Node {
  String[] itemlist;
  String activity;
  
  Space (String name, String[] itemlist, String activity) {
    super(name);
    this.itemlist = itemlist;
    this.activity = activity;
  }


  public void welcome () {
    System.out.println("----------------------------------------");
    System.out.println("\nYou are now at: "+name+"\n");
    if(activity== null){
      System.out.println("no activity here");
      System.out.println("");
    }
    else {
      System.out.println("activity here: "+activity);
    }
    if(itemlist[0]=="")
    {
      System.out.println("The room has no items available");
      System.out.println("");
    }
    else
    {
      System.out.println("The room has the following items:");
      for (int i = 0; i < itemlist.length; i++) {
        System.out.println(" - "+itemlist[i]);
      }
      System.out.println("");
    }
    System.out.println("Your current hunger level is: "+ItemsDescription.getHungerLevel());

    Set<String> exits = edges.keySet();
    System.out.println("\nCurrent exits are:");
    for (String exit: exits) {
      System.out.println(" - "+exit);
    }
  }
  
  public void goodbye () {
  }
  
  @Override
  public Space followEdge (String direction) {
    return (Space) (super.followEdge(direction));
  }
}
