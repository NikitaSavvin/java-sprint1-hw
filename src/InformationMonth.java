import java.util.ArrayList;
import java.util.HashMap;

public class InformationMonth {

    public static void informationMonth() {
        HashMap<String, String> calendar = Calendar.calendar();
        HashMap<ArrayList, HashMap> dataMounts = MonthlyReport.monthlyReport();
        ArrayList<String> itemName;
        ArrayList<Boolean> isExpense;
        ArrayList<Integer> quantity;
        ArrayList<Integer> sumOfOone;

        for (ArrayList dateMount : dataMounts.keySet()) {
            System.out.println("Информация за " + calendar.get(dateMount.get(0)) + ":");
            itemName = (ArrayList<String>) dataMounts.get(dateMount).get("item_name");
            isExpense = (ArrayList<Boolean>) dataMounts.get(dateMount).get("is_expense");
            quantity = (ArrayList<Integer>) dataMounts.get(dateMount).get("quantity");
            sumOfOone = (ArrayList<Integer>) dataMounts.get(dateMount).get("sum_of_one");
            String mostProduct = "";
            String nameWasteProduct = "";
            int sumMostProduct = 0;
            int maxWasteProduct = 0;
            for (int i = 0; i < isExpense.size(); i++) {
                int sumProduct = 0;
                int wasteProduct = 0;
                if (!isExpense.get(i)) {
                    sumProduct = quantity.get(i) * sumOfOone.get(i);
                } else {
                    wasteProduct = quantity.get(i) * sumOfOone.get(i);
                }
                if (sumMostProduct < sumProduct) {
                    sumMostProduct = sumProduct;
                    mostProduct = itemName.get(i);
                }
                if (maxWasteProduct < wasteProduct) {
                    maxWasteProduct = wasteProduct;
                    nameWasteProduct = itemName.get(i);
                }
            }

            System.out.println("Самый прибыльный товар : " + mostProduct +
                    ". Продано на общую сумму - " + sumMostProduct);
            System.out.println("Самая большая трата вышла на " + nameWasteProduct +
                    ". На общую сумму - " + maxWasteProduct);
        }

    }
}
