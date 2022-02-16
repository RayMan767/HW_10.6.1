import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TotalCalc total = new TotalCalc("src/ list.txt");

        total.makeTotal();
    }
}
