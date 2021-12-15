import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public static HashMap<String, HashMap> creatDataMonthlyReport() {
        HashMap<String, HashMap> dataMount = new HashMap<>();
        HashMap<String, ArrayList<String>> dataM = ProcessingFiles.processingMonthlyFiles();
        for (String path : dataM.keySet()) {
            String fileContents = Unpacking.readFileContentsOrNull(path);
            String[] lines = fileContents.split("\\r\\n");
            HashMap<String, ArrayList> data = new HashMap<>();
            ArrayList<ArrayList> valuesTitle = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            String[] title = lines[0].split(",");
            for (int i = 0; i < title.length; i++) {
                titles.add(title[i]);
            }
            ArrayList<Boolean> isExpense = new ArrayList<>();
            ArrayList<String> itemName = new ArrayList<>();
            ArrayList<Integer> quantity = new ArrayList<>();
            ArrayList<Integer> sumOfOne = new ArrayList<>();
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                itemName.add(lineContents[0]);
                isExpense.add(Boolean.parseBoolean(lineContents[1]));
                quantity.add(Integer.parseInt(lineContents[2]));
                sumOfOne.add(Integer.parseInt(lineContents[3]));
            }
            valuesTitle.add(itemName);
            valuesTitle.add(isExpense);
            valuesTitle.add(quantity);
            valuesTitle.add(sumOfOne);
            for (int i = 0; i < title.length; i++) {
                data.put(titles.get(i), valuesTitle.get(i));
            }
            dataMount.put(dataM.get(path).get(0), data);
        }
        return dataMount;
    }
}
