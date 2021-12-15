import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessingFiles {
    public static HashMap<String, ArrayList<String>> processingMonthlyFiles() {
        File dir = new File("resources");
        List<File> files = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                files.add(file);
        }
        HashMap<String, ArrayList<String>> fileDateMY = new HashMap<>();
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList> listDateMY = new ArrayList<>();
        ArrayList<String> pathMount = new ArrayList<>();
        for (File stringFile : files) {
            path.add(String.valueOf(stringFile));
        }
        for (int i = 0; i < path.size(); i++) {
            ArrayList<String> dateMY = new ArrayList<>();
            String timeInterval = path.get(i).substring(10, 11);
            if (timeInterval.equals("m")) {
                String numYear = path.get(i).substring(12, 16);
                String numMouth = path.get(i).substring(16, 18);
                pathMount.add(path.get(i));
                dateMY.add(numMouth);
                dateMY.add(numYear);
            }
            listDateMY.add(dateMY);
        }
        for (int i = 0; i < pathMount.size(); i++) {
            fileDateMY.put(pathMount.get(i), listDateMY.get(i));
        }
        return fileDateMY;
    }

    public static HashMap<String, String> processingYearlyFiles() {
        File dir = new File("resources");
        List<File> files = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                files.add(file);
        }
        ArrayList<String> path = new ArrayList<>();
        HashMap<String, String> fileDateYear = new HashMap<>();
        for (File stringFile : files) {
            path.add(String.valueOf(stringFile));
        }
        for (int i = 0; i < path.size(); i++) {
            String timeInterval = path.get(i).substring(10, 11);
            if (timeInterval.equals("y")) {
                String numYear = path.get(i).substring(12, 16);
                fileDateYear.put(path.get(i), numYear);
            }
        }
        return fileDateYear;
    }
}
