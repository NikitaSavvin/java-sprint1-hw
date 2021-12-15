import java.util.ArrayList;
import java.util.HashMap;

public class VerificationData {
    public static void verificationData(HashMap<String, HashMap> dataMount,
                                        HashMap<String, HashMap> dataYear) {
        HashMap<String, String> calendar = Calendar.convertNumberToMmonth();
        ArrayList<Boolean> incomeAnswer = new ArrayList<>();
        ArrayList<Boolean> wasteAnswer = new ArrayList<>();
        for (String numMount : dataMount.keySet()) {
            ArrayList<ArrayList> monthReportRows = MonthRow.creatListDataMount(dataMount, numMount);
            int income = 0;
            int waste = 0;
            for (int i = 0; i < monthReportRows.get(1).size(); i++) {
                if (!((Boolean) monthReportRows.get(1).get(i))) {
                    income += (Integer) monthReportRows.get(2).get(i) *
                            (Integer) monthReportRows.get(3).get(i);
                } else {
                    waste += (Integer) monthReportRows.get(2).get(i) *
                            (Integer) monthReportRows.get(3).get(i);
                }
            }
            for (String year : dataYear.keySet()) {
                ArrayList<ArrayList> yearReport = YearRow.creatListDataYear(dataYear, year);
                for (int i = 0; i < yearReport.get(0).size(); i++) {
                    if (yearReport.get(0).get(i).equals(numMount) &&
                            yearReport.get(2).get(i).equals(false)) {
                        if (!(income == (Integer) yearReport.get(1).get(i))) {
                            System.out.println("Данные по доходу за " +
                                    calendar.get(yearReport.get(0).get(i)) + " не совпадают");
                            incomeAnswer.add(false);
                        } else {
                            incomeAnswer.add(true);
                        }
                    } else if (yearReport.get(0).get(i).equals(numMount) &&
                            yearReport.get(2).get(i).equals(true)) {
                        if (!(waste == (Integer) yearReport.get(1).get(i))) {
                            System.out.println("Данные по расходам за " +
                                    calendar.get(yearReport.get(0).get(i)) + " не совпадают");
                            incomeAnswer.add(false);
                        } else {
                            wasteAnswer.add(true);
                        }
                    }
                }
            }
        }
        if (!(incomeAnswer.contains(false) | wasteAnswer.contains(false))) {
            System.out.println("Успешное завершение операции");
        }
    }
}
