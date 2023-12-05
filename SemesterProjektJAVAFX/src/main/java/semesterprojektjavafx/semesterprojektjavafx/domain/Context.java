package semesterprojektjavafx.semesterprojektjavafx.domain;/* Context class to hold all context relevant to a session.
 */

import java.util.ArrayList;

public class Context {
  static Space current;
  static boolean done = false;
  
  public Context(Space node) {current = node;}
  
  public static Space getCurrent() {
    return current;
  }

  public static String[] getCurrentAvailableItems() {
    return current.itemlist;
  }

  public static ArrayList<String> getCurrentInventory(){ return Inventory.inventoryStorage;}

  public static String
  getCurrentActivity(){
    return current.activity;
  }

  public void transition (String direction) {
    Space next = current.followEdge(direction);
    if (next==null) {
      System.out.println("You are confused, and walk in a circle looking for '"+direction+"'. In the end you give up 😩");
    } else {
      current.goodbye();
      current = next;
      current.welcome();
    }
  }
  
  public static void makeDone () {
    done = true;
  }
  
  public static boolean isDone() {
    return done;
  }

}

