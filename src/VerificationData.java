import java.util.ArrayList;
import java.util.HashMap;

public class VerificationData {
    public static void verificationData(){
        HashMap<String, String> calendar = Calendar.calendar();
        HashMap<ArrayList, HashMap> dataMounts = MonthlyReport.monthlyReport();
        HashMap<String, HashMap> dataYears = YearlyReport.yearlyReport();
        ArrayList<String> itemName = new ArrayList<>();
        ArrayList<Boolean> isExpense = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();
        ArrayList<Integer> sumOfOone= new ArrayList<>();
        ArrayList<String> month;
        ArrayList<Integer> amount;
        ArrayList<Boolean> incomeAnswer = new ArrayList<>();
        ArrayList<Boolean> wasteAnswer = new ArrayList<>();

        for(ArrayList dateMount : dataMounts.keySet()){
            itemName = (ArrayList<String>) dataMounts.get(dateMount).get("item_name");
            isExpense = (ArrayList<Boolean>) dataMounts.get(dateMount).get("is_expense");
            quantity = (ArrayList<Integer>) dataMounts.get(dateMount).get("quantity");
            sumOfOone = (ArrayList<Integer>) dataMounts.get(dateMount).get("sum_of_one");
            int income = 0;
            int waste = 0;
            for(int i = 0; i <isExpense.size(); i++) {
                if (!isExpense.get(i)) {
                    income += quantity.get(i) * sumOfOone.get(i);
                } else{
                    waste += quantity.get(i) * sumOfOone.get(i);
                }
            }
            for(String year : dataYears.keySet()){
                month = (ArrayList<String>) dataYears.get(year).get("month");
                amount = (ArrayList<Integer>) dataYears.get(year).get("amount");
                isExpense = (ArrayList<Boolean>) dataYears.get(year).get("is_expense");
                for(int i =0; i < month.size(); i++) {
                    if (month.get(i).equals(dateMount.get(0)) && isExpense.get(i).equals(false)) {
                        if (!(income == amount.get(i))) {
                            System.out.println("Данные по доходу за " + calendar.get(month.get(i)) + " не совпадают");
                        } else{
                            incomeAnswer.add(true);
                        }
                    } else if (month.get(i).equals(dateMount.get(0)) && isExpense.get(i).equals(true)) {
                        if (!(waste == amount.get(i))) {
                            System.out.println("Данные по расходам за " + calendar.get(month.get(i)) + " не совпадают");
                        } else{
                            wasteAnswer.add(true);
                        }
                    }

                }
            }
            }
            if(!(incomeAnswer.contains(false)&&wasteAnswer.contains(false))){
                System.out.println("Успешное завершение операции");
            }
    }
}
