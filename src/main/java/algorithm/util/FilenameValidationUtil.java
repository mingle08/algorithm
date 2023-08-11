package algorithm.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilenameValidationUtil {

    public static String checkFilename(List<String> list, String filename, Date date) {

        // 1 file size
        
        int cnt = 0;
        // 2 regex
        for (String str : list) {
            if(!filename.matches(str.replace("YYYYMMDD", "\\d{8}")
            .replace("nn", "\\d{2}"))) {
                cnt++;
            };
        }

        if (cnt == list.size()) {
            return "invalid file name";
        }

        // 3 check date in filename
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
        String nowStr = sdf.format(date);
        if (!nowStr.equals(filename.substring("ABC".length(), 
        "ABC".length() + "yyyyMMdd".length()))) {
            return "invalid file date";
        }

        // 4 query database, if duplicated file

        return null;
    }

    public static void main(String[] args) {
        String str1 = "ABCYYYYMMDD1100nn.csv";
        String str2 = "ABCYYYYMMDD2300nn.csv";
        List<String> regexList = new ArrayList<>();
        regexList.add(str1);
        regexList.add(str2);

        String filename = "ABC20230811230001.csv";
        Date now = new Date();
        String errorDesc = checkFilename(regexList, filename, now);

        if (errorDesc == null) {
            System.out.println("00");
        } else {
            System.out.println(errorDesc);
        }

    }
}
