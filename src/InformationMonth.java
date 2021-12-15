import java.util.ArrayList;
import java.util.HashMap;

public class InformationMonth {

    public static void printInformationMonth(HashMap<String, HashMap> dataMount) {
        HashMap<String, String> calendar = Calendar.convertNumberToMmonth();
        for (String numMount : dataMount.keySet()) {
            System.out.println("Информация за " + calendar.get(numMount) + ":");
            String mostProduct = "";
            String nameWasteProduct = "";
            int sumMostProduct = 0;
            int maxWasteProduct = 0;
            ArrayList<ArrayList> monthReportRows = MonthRow.creatListDataMount(dataMount, numMount);
            for (int i = 0; i < monthReportRows.get(1).size(); i++) {
                int sumProduct = 0;
                int wasteProduct = 0;
                if (!((boolean) monthReportRows.get(1).get(i))) {
                    sumProduct = (Integer) monthReportRows.get(2).get(i) *
                            (Integer) monthReportRows.get(3).get(i);
                } else {
                    wasteProduct = (Integer) monthReportRows.get(2).get(i) *
                            (Integer) monthReportRows.get(3).get(i);
                }
                if (sumMostProduct < sumProduct) {
                    sumMostProduct = sumProduct;
                    mostProduct = (String) monthReportRows.get(0).get(i);
                }
                if (maxWasteProduct < wasteProduct) {
                    maxWasteProduct = wasteProduct;
                    nameWasteProduct = (String) monthReportRows.get(0).get(i);
                }
            }
            System.out.println("Самый прибыльный товар : " + mostProduct +
                    ". Продано на общую сумму - " + sumMostProduct);
            System.out.println("Самая большая трата вышла на " + nameWasteProduct +
                    ". На общую сумму - " + maxWasteProduct);
        }

    }
}
