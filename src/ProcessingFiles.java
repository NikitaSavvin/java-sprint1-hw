import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessingFiles {
    public static HashMap<String, ArrayList> processingMonthlyFiles() {
        File dir = new File("resources");
        List<File> files = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                files.add(file);
        }

        HashMap<String, ArrayList> fileDateMY = new HashMap<>();
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList> listDateMY = new ArrayList<>();
        ArrayList<String> pathMount = new ArrayList<>();

        for (File stringFile : files) {
            path.add(String.valueOf(stringFile));
        }
        for (int i =0; i < path.size(); i++) {
            ArrayList<String> dateMY = new ArrayList<>();
            String[] separationFullFile = path.get(i).split("\\\\");
            String[] separationFile = separationFullFile[1].split("");
            if(separationFile[0].contains("m")){
                pathMount.add(path.get(i));
                String numMouth = separationFile[6] + separationFile[7];
                String numYear = separationFile[2] + separationFile[3] + separationFile[4] + separationFile[5];
                //dateMY.add(nameMount.get(numMouth));
                dateMY.add(numMouth);

                dateMY.add(numYear);

            }
            listDateMY.add(dateMY);
        }
        for(int i = 0; i < pathMount.size(); i++){
                fileDateMY.put(pathMount.get(i), listDateMY.get(i));
        }
        //System.out.println(fileDateMY.get("resources\\m.202103.csv"));
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
        for (int i =0; i < path.size(); i++) {
            String[] separationFullFile = path.get(i).split("\\\\");
            String[] separationFile = separationFullFile[1].split("");
            if (separationFile[0].contains("y")) {
                String numYear = separationFile[2] + separationFile[3] + separationFile[4] + separationFile[5];
                fileDateYear.put(path.get(i), numYear);
            }
        }
        //System.out.println(fileDateYear.get("resources\\y.2021.csv"));
        return fileDateYear;
    }
}
