package seminar6.srp2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для сохранения данных в файлы различных форматов.
 */
public class FileSaver {

    /**
     * Метод сохранения содержимого в файл.
     * @param fileName имя файла.
     * @param content содержимое для сохранения.
     */
    public void saveToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод сохранения объекта Order в формате JSON.
     * @param fileName имя файла.
     * @param order экземпляр Order для сохранения.
     */
    public void saveToJson(String fileName, Order order) {
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

    /**
     * Метод сохранения объекта Order в формате XML.
     * @param fileName имя файла.
     * @param order экземпляр Order для сохранения.
     */
    public void saveToXml(String fileName, Order order) {
        // Реализация сохранения в формате XML
    }
}
