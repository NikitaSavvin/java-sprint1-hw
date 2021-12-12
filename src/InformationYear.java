import java.util.ArrayList;
import java.util.HashMap;

public class InformationYear {
    public static void informationYear() {
        HashMap<String, String> calendar = Calendar.calendar();
        HashMap<String, HashMap> dataYears = YearlyReport.yearlyReport();
        ArrayList<String> withoutDublicateMoutn = new ArrayList<>();
        HashMap<String, ArrayList<? extends Integer>> withoutDublicateMoutnIndex = new HashMap<>();
        ArrayList<String> month;
        ArrayList<Integer> amount;
        ArrayList<Boolean> isExpense;
        HashMap<String, ArrayList<? extends Integer>> dublicate = new HashMap<>();
        HashMap<String, Integer> report = new HashMap<>();
        ArrayList<Integer> spends = new ArrayList<>();
        ArrayList<Integer> gains = new ArrayList<>();
        for (String year : dataYears.keySet()) {
            int profit = 0;
            System.out.println("Рассматривается " + year + " год");
            month = (ArrayList<String>) dataYears.get(year).get("month");
            amount = (ArrayList<Integer>) dataYears.get(year).get("amount");
            isExpense = (ArrayList<Boolean>) dataYears.get(year).get("is_expense");
            for (String numMount : month) {
                ArrayList<Integer> dubleIndex = new ArrayList<>();
                if (!withoutDublicateMoutn.contains(numMount)) {
                    withoutDublicateMoutn.add(numMount);
                }
                int firstIndex = month.indexOf(numMount);
                int lastIndex = month.lastIndexOf(numMount);
                dubleIndex.add(firstIndex);
                dubleIndex.add(lastIndex);
                dublicate.put(numMount, dubleIndex);
            }
            for (String numMount : withoutDublicateMoutn) {
                withoutDublicateMoutnIndex.put(numMount, dublicate.get(numMount));
            }
            for (String numMount : withoutDublicateMoutnIndex.keySet()) {
                for (Integer index : withoutDublicateMoutnIndex.get(numMount)) {
                    if (isExpense.get(index)) {
                        profit -= amount.get(index);

                    } else {
                        profit += amount.get(index);
                    }
                }
                report.put(numMount, profit);
            }
            for (String mount : report.keySet()) {
                System.out.println("За " + calendar.get(mount) + " Прибыль составила - "
                        + report.get(mount));
            }
            for (int i = 0; i < isExpense.size(); i++) {
                if (isExpense.get(i)) {
                    spends.add(amount.get(i));
                } else {
                    gains.add(amount.get(i));
                }
            }
            int spend = 0;
            int gain = 0;
            for (int i = 0; i < spends.size(); i++) {
                spend += spends.get(i);
            }
            for (int i = 0; i < gains.size(); i++) {
                gain += gains.get(i);
            }
            double mediumSpends = spend / spends.size();
            double mediumGains = gain / gains.size();
            System.out.println("Средний расход составил - " + mediumSpends);
            System.out.println("Средний доход составил - " + mediumGains);
        }
    }
}
