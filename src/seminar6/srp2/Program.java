package seminar6.srp2;
public class Program {


    /**
     * TODO: Домашняя работа (программа 1),
     *  оптимизировать приложение в соответствии с принципом SOLID - SRP
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Укажите заказ:");
        InputHandler input = new InputHandler();
        FileSaver fileSaver = new FileSaver();
        //JsonFileWriter jsonSave = new JsonFileWriter("order");
        Order order = input.inputFromConsole();
        //jsonSave.saveToJson(order);
        fileSaver.saveToJson("test", order);
    }

}
