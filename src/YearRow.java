import java.util.ArrayList;
import java.util.HashMap;

public class YearRow {
    public static ArrayList<ArrayList> creatListDataYear(
            HashMap<String, HashMap> dataYear, String year) {
        ArrayList<ArrayList> yearReportRows = new ArrayList<>();
        ArrayList<String> month = (ArrayList<String>)
                dataYear.get(year).get("month");
        ArrayList<Integer> amount = (ArrayList<Integer>)
                dataYear.get(year).get("amount");
        ArrayList<Boolean> isExpense = (ArrayList<Boolean>)
                dataYear.get(year).get("is_expense");
        yearReportRows.add(month);
        yearReportRows.add(amount);
        yearReportRows.add(isExpense);
        return yearReportRows;
    }
}
