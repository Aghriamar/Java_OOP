package seminar6.srp2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для записи в файл в формате JSON.
 */
public class JsonFileWriter {
    /**
     * Имя файла JSON
     */
    private String fileName;

    /**
     * Конструктор класса.
     * @param fileName имя файла JSON.
     */
    public JsonFileWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * аписывает объект Order в формате JSON в файл.
     * @param order объект типа Order, который нужно записать в файл.
     */
    public void saveToJson(Order order) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+order.getProduct()+"\",\n");
            writer.write("\"qnt\":"+order.getQnt()+",\n");
            writer.write("\"price\":"+order.getPrice()+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
