package semesterprojektjavafx.semesterprojektjavafx.domain;

public class ItemsDescription {
    //GlucoseLevel skal være mellem 4 og 7
    static double glucoseLevel = 5;
    //HungerLevel skal være mellem 0 og 10
    static double hungerLevel = 5;

    public static double impactGlucoseLevel(String item) {
        if (item.equals("milk")) {
            glucoseLevel += 1;
            return glucoseLevel;
        }
        if (item.equals("almonds")) {
            glucoseLevel += 0.2;
            return glucoseLevel;
        }
        if (item.equals("ice tea")) {
            glucoseLevel += 0.2;
            return glucoseLevel;
        }
        if (item.equals("apple")) {
            glucoseLevel += 2;
            return glucoseLevel;
        }
        if (item.equals("insulininjector")) {
            glucoseLevel -= 2;
            return glucoseLevel;
        }

        return 0;
    }

    public static void impactHungerLevel(String item) {
        if (item.equals("milk")) {
            hungerLevel += 2;
        }
        if (item.equals("almonds")) {
            hungerLevel += 3;
        }
        if (item.equals("ice tea")) {
            hungerLevel += 1;
        }
        if (item.equals("apple")) {
            hungerLevel += 3;
        }
    }

    public static String getDescription(String item) {
        if (item.equals("milk") ) {
            return "(250 ml)";
        }
        if (item.equals("almonds") ){
            return "(15 g)";
        }
        if (item.equals("ice tea")) {
            return "(250 ml)";
        }
        if (item.equals("apple")) {
            return "(110 g)";
        }
        if (item.equals("glucosemeter")) {
            return "";
        }
        if (item.equals("insulininjector")) {
            return "(1)";
        }
        else return null;
    }

    public static double getGlucoseLevel(){
        return glucoseLevel;
    }

    public static void setGlucoseLevel(double i){
        glucoseLevel += i;
    }

    public static String getHungerLevel(){
        if (hungerLevel<=2)
        return "Very hungry";
        if (2< hungerLevel && hungerLevel <= 5) {
            return "Hungry";
        }
        if (5 < hungerLevel && hungerLevel <= 8)
            return "Full";
        if (8<hungerLevel)
            return "Very full";

        return null;
    }

    public static void setHungerLevel(double i){
        hungerLevel += i;
    }
}