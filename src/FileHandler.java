import java.io.*;
import java.util.*;

class FileHandler {
    // Export products to a CSV file
    public static void exportProducts(List<Product> products, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        for (Product product : products) {
            fileWriter.write(product.toCsvRow() + "\n");
        }
        fileWriter.close();
    }

    // Import products from a CSV file
    public static List<Product> importProducts(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");
            Product product = new Product(values[0], values[1], values[2], Integer.parseInt(values[3]), Double.parseDouble(values[4]));
            products.add(product);
        }
        bufferedReader.close();
        return products;
    }

    // Export purchase history for a customer
    public static void exportPurchaseHistory(List<Purchase> purchases, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        for (Purchase purchase : purchases) {
            fileWriter.write(purchase.toCsvRow() + "\n");
        }
        fileWriter.close();
    }

}