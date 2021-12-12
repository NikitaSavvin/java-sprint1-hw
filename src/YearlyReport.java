import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    public static HashMap<String, HashMap> yearlyReport() {
        HashMap<String, HashMap> dataYear = new HashMap<>();
        HashMap<String, String> dataY = ProcessingFiles.processingYearlyFiles();
        for (String path : dataY.keySet()) {
            String fileContents = Unpacking.readFileContentsOrNull(path);
            String[] lines = fileContents.split("\\r\\n");

            HashMap<String, ArrayList> data = new HashMap<>();
            ArrayList<ArrayList> valuesTitle = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();

            String[] title = lines[0].split(",");

            for (int i = 0; i < title.length; i++) {
                titles.add(title[i]);
            }
            ArrayList<String> month = new ArrayList<>();
            ArrayList<Integer> amount = new ArrayList<>();
            ArrayList<Boolean> isExpense = new ArrayList<>();

            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                month.add(lineContents[0]);
                amount.add(Integer.parseInt(lineContents[1]));
                isExpense.add(Boolean.parseBoolean(lineContents[2]));
            }
            valuesTitle.add(month);
            valuesTitle.add(amount);
            valuesTitle.add(isExpense);

            for(int i = 0; i< title.length; i++){
                data.put(titles.get(i), valuesTitle.get(i));
            }
            dataYear.put(dataY.get(path), data);
        }
        return dataYear;
    }
}
