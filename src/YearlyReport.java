import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public static ArrayList<YearRow> creatDataYearlyReport() {
        HashMap<String, String> dataY = ProcessorFiles.processYearlyFiles();
        ArrayList<YearRow> data = new ArrayList<>();
        for (String path : dataY.keySet()) {
            ArrayList<String> month = new ArrayList<>();
            ArrayList<Integer> amount = new ArrayList<>();
            ArrayList<Boolean> isExpense = new ArrayList<>();
            String fileContents = ReadFiles.readFileContentsOrNull(path);
            String[] lines = fileContents.split("\\n");
            YearRow yearRow = null;
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                month.add(lineContents[0]);
                amount.add(Integer.parseInt(lineContents[1]));
                isExpense.add(Boolean.parseBoolean(lineContents[2]));
                yearRow = new YearRow(month, amount, isExpense);
            }
            data.add(yearRow);
        }
        return data;
    }
}
