import java.util.ArrayList;
import java.util.HashMap;

public class MonthRow {
    public static ArrayList<ArrayList> creatListDataMount(
            HashMap<String, HashMap> dataMount, String numMount) {
        ArrayList<ArrayList> monthReportRows = new ArrayList<>();
        ArrayList<String> itemName = (ArrayList<String>)
                dataMount.get(numMount).get("item_name");
        ArrayList<Boolean> isExpense = (ArrayList<Boolean>)
                dataMount.get(numMount).get("is_expense");
        ArrayList<Integer> quantity = (ArrayList<Integer>)
                dataMount.get(numMount).get("quantity");
        ArrayList<Integer> sumOfOone = (ArrayList<Integer>)
                dataMount.get(numMount).get("sum_of_one");
        monthReportRows.add(itemName);
        monthReportRows.add(isExpense);
        monthReportRows.add(quantity);
        monthReportRows.add(sumOfOone);
        return monthReportRows;
    }
}
