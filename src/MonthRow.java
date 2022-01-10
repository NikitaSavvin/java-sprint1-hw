import java.util.ArrayList;

public class MonthRow {
    ArrayList<String> itemName;
    ArrayList<Boolean> isExpense;
    ArrayList<Integer> quantity;
    ArrayList<Integer> sumOfOne;

    MonthRow(
            ArrayList<String> itemName, ArrayList<Boolean> isExpense,
            ArrayList<Integer> quantity, ArrayList<Integer> sumOfOne
    ) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}