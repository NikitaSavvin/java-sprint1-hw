import java.util.HashMap;

public class Calendar {
    public static HashMap<String, String> calendar() {
        HashMap<String, String> calendar = new HashMap<>();
        calendar.put("01", "Январь");
        calendar.put("02", "Февраль");
        calendar.put("03", "Март");
        calendar.put("04", "Апрель");
        calendar.put("05", "Май");
        calendar.put("06", "Июнь");
        calendar.put("07", "Июль");
        calendar.put("08", "Август");
        calendar.put("09", "Сентябрь");
        calendar.put("10", "Октябрь");
        calendar.put("11", "Ноябрь");
        calendar.put("12", "Декабрь");
        return calendar;
    }
}
