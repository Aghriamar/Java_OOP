package seminar7.adapter;

public class Program {

    public static void main(String[] args) {

        ST500Info st500Info_1 = new ST500Info(44331);
        MS200 ms200_1 = new MS200(11554);

        MeteoStore meteoStore = new MeteoStore();

        meteoStore.save(ms200_1);
        meteoStore.save(new AdapterST500Info(st500Info_1));

    }

}
