package semesterprojektjavafx.semesterprojektjavafx.domain;

public class DayCount {
    static int day = 0;

    public static int getDay(){
        return day;
    }

    public static void plusDay(int newDay){
        day += newDay;
    }
    public static void restDay(){day=0;}
}