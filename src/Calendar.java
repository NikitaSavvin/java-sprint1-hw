import java.util.HashMap;

public class Calendar {
    public static HashMap<Integer, String> convertNumberToMmonth() {
        HashMap<Integer, String> calendar = new HashMap<>();
        calendar.put(0, "Январь");
        calendar.put(1, "Февраль");
        calendar.put(2, "Март");
        calendar.put(3, "Апрель");
        calendar.put(4, "Май");
        calendar.put(5, "Июнь");
        calendar.put(6, "Июль");
        calendar.put(7, "Август");
        calendar.put(8, "Сентябрь");
        calendar.put(9, "Октябрь");
        calendar.put(10, "Ноябрь");
        calendar.put(11, "Декабрь");
        return calendar;
    }
}
