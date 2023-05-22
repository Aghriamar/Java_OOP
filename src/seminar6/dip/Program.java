package seminar6.dip;

public class Program {

    public static void main(String[] args) {

        Report report = new Report();
        report.calculate();
        report.output(new PrintReport2());

    }

}
