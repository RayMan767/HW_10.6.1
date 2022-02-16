import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TotalCalc {
    private String fileName = "";

    public TotalCalc(String fileName) {
        this.fileName = fileName;
    }

    public void makeTotal() throws IOException {
        int i;
        double rezult = 0;
        String str = "";

        // паттерн для поиска double
        Pattern pattern = Pattern.compile("[\\d.]+[\\d]");

        // берем из файла текст
        FileInputStream fis = new FileInputStream(fileName);
        while ((i = fis.read()) != -1) {
            str += (char) i;
        }
        fis.close();

        FileOutputStream fos = new FileOutputStream("src/Total.txt");
        fos.write(str.getBytes(StandardCharsets.UTF_8));

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            rezult += Double.parseDouble(str.substring(start, end));
        }

        fos.write(("\nTotal: " + rezult + " kg.").getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}
