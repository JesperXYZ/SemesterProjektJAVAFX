package semesterprojektjavafx.semesterprojektjavafx.domain;/*/* World class for modeling the entire in-game world
* */


class World {
  static Space entry;
  public World() {

    Space houseEntry  = new Space("House entry", new String[]{""}, null);
    Space kitchen   = new Space("The Kitchen", new String[]{"apple", "ice tea", "milk", "almonds"}, null);
    Space bedroom   = new Space("The Bedroom", new String[]{"glucosemeter", "insulininjector"}, "sleep");
    Space garden    = new Space("The Garden", new String[]{""}, "gardening");
    Space work      = new Space("Work", new String[]{""}, "work");
    Space football    = new Space("Football", new String[]{""}, "football");
    Space club      = new Space("Club", new String[]{""}, "clubbing");
    Space birthdayParty = new Space("Birthday party", new String[]{""}, "birthday");
    Space school    = new Space("School", new String[]{""}, "school");
    Space corridor    = new Space("The Corridor", new String[]{""},null);




    houseEntry.addEdge  ("work", work);
    houseEntry.addEdge  ("birthdayParty", birthdayParty);
    houseEntry.addEdge  ("club", club);
    houseEntry.addEdge  ("school", school);
    houseEntry.addEdge  ("football", football);

    houseEntry.addEdge  ("corridor", corridor);


    corridor.addEdge  ("houseEntry", houseEntry);
    corridor.addEdge  ("garden", garden);
    corridor.addEdge  ("kitchen", kitchen);
    corridor.addEdge  ("bedroom", bedroom);


    garden.addEdge    ("corridor",corridor);
    kitchen.addEdge     ("corridor", corridor);
    bedroom.addEdge     ("corridor", corridor);

    work.addEdge    ("home", houseEntry);
    football.addEdge    ("home", houseEntry);
    birthdayParty.addEdge ("home", houseEntry);
    school.addEdge    ("home", houseEntry);
    club.addEdge    ("home", houseEntry);

    this.entry = houseEntry;

  }
  public static Space getEntry() {
    return entry;
  }
}