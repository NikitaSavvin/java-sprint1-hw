import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public static ArrayList<MonthRow> creatDataMonthlyReport() {
        HashMap<String, ArrayList<String>> dataM = ProcessorFiles.processMonthlyFiles();
        ArrayList<MonthRow> data = new ArrayList<>();
        for (String path : dataM.keySet()) {
            ArrayList<String> itemName = new ArrayList<>();
            ArrayList<Boolean> isExpense = new ArrayList<>();
            ArrayList<Integer> quantity = new ArrayList<>();
            ArrayList<Integer> sumOfOne = new ArrayList<>();
            String fileContents = ReadFiles.readFileContentsOrNull(path);
            String[] lines = fileContents.split("\\n");
            MonthRow monthRow = null;
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                itemName.add(lineContents[0]);
                isExpense.add(Boolean.parseBoolean(lineContents[1]));
                quantity.add(Integer.parseInt(lineContents[2]));
                sumOfOne.add(Integer.parseInt(lineContents[3]));
                monthRow = new MonthRow(itemName, isExpense, quantity, sumOfOne);
            }
            data.add(monthRow);
        }
        return data;
    }
}
