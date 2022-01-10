import java.util.ArrayList;
import java.util.HashMap;

public class InformationMonth {
    public static void printInformationMonth(ArrayList<MonthRow> data) {
        HashMap<Integer, String> calendar = Calendar.convertNumberToMmonth();
        String mostProduct = null;
        int sumMostProduct = 0;
        String nameWasteProduct = null;
        int maxWasteProduct = 0;
        for (int i = 0; i < data.size(); i++) {
            System.out.println("Информация за " + calendar.get(i) + ":");
            mostProduct = "";
            nameWasteProduct = "";
            sumMostProduct = 0;
            maxWasteProduct = 0;
            int sumProduct = 0;
            int wasteProduct = 0;
            for (int n = 0; n < data.get(i).itemName.size(); n++) {
                int sum = data.get(i).quantity.get(n) * data.get(i).sumOfOne.get(n);
                String product = data.get(i).itemName.get(n);
                if (!data.get(i).isExpense.get(n)) {
                    sumProduct = sum;
                } else {
                    wasteProduct = sum;
                }
                if (sumMostProduct < sumProduct) {
                    sumMostProduct = sumProduct;
                    mostProduct = product;
                }
                if (maxWasteProduct < wasteProduct) {
                    maxWasteProduct = wasteProduct;
                    nameWasteProduct = product;
                }
            }
            System.out.println("Самый прибыльный товар : " + mostProduct +
                    ". Продано на общую сумму - " + sumMostProduct);
            System.out.println("Самая большая трата вышла на " + nameWasteProduct +
                    ". На общую сумму - " + maxWasteProduct);
        }
    }
}
