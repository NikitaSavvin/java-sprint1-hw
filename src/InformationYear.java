import java.util.ArrayList;
import java.util.HashMap;

public class InformationYear {
    public static void printInformationYear(HashMap<String, HashMap> dataYear) {
        HashMap<String, String> calendar = Calendar.convertNumberToMmonth();
        ArrayList<String> withoutDublicateMoutn = new ArrayList<>();
        HashMap<String, ArrayList> withoutDublicateMoutnIndex = new HashMap<>();
        HashMap<String, ArrayList> dublicate = new HashMap<>();
        HashMap<String, Integer> report = new HashMap<>();
        ArrayList<Integer> spends = new ArrayList<>();
        ArrayList<Integer> gains = new ArrayList<>();
        for (String year : dataYear.keySet()) {
            int profit = 0;
            System.out.println("Рассматривается " + year + " год");
            ArrayList<ArrayList> yearReport = YearRow.creatListDataYear(dataYear, year);
            for (Object numMount : yearReport.get(0)) {
                ArrayList<Integer> dubleIndex = new ArrayList<>();
                if (!withoutDublicateMoutn.contains(numMount)) {
                    withoutDublicateMoutn.add((String) numMount);
                }
                int firstIndex = yearReport.get(0).indexOf(numMount);
                int lastIndex = yearReport.get(0).lastIndexOf(numMount);
                dubleIndex.add(firstIndex);
                dubleIndex.add(lastIndex);
                dublicate.put((String) numMount, dubleIndex);
            }
            for (String numMount : withoutDublicateMoutn) {
                withoutDublicateMoutnIndex.put(numMount, dublicate.get(numMount));
            }
            for (String numMount : withoutDublicateMoutnIndex.keySet()) {
                for (Object index : withoutDublicateMoutnIndex.get(numMount)) {
                    if ((Boolean) yearReport.get(2).get((Integer) index)) {
                        profit -= (Integer) yearReport.get(1).get((Integer) index);
                    } else {
                        profit += (Integer) yearReport.get(1).get((Integer) index);
                    }
                }
                report.put(numMount, profit);
            }
            for (String mount : report.keySet()) {
                System.out.println("За " + calendar.get(mount) +
                        " Прибыль составила - " + report.get(mount));
            }
            for (int i = 0; i < yearReport.get(2).size(); i++) {
                if ((Boolean) yearReport.get(2).get(i)) {
                    spends.add((Integer) yearReport.get(1).get(i));
                } else {
                    gains.add((Integer) yearReport.get(1).get(i));
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
