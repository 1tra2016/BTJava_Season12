package ra.entity;

import java.util.Scanner;

public class Product {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
        this.productId = autoId++;
    }

    public Product(String productName, float price, String category, int quantity) {
        this.productId = autoId++;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {return productId;}

    public String getProductName() {return productName;}
    public void setProductName(String productName) {this.productName = productName;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}

    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public void inputData(Scanner scanner, Product[] products, int currentIndex) {
        while (true) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Tên sản phẩm phải từ 10-50 ký tự");
                continue;
            }
            boolean exists = false;
            for (int i = 0; i < currentIndex; i++) {
                if (products[i].getProductName().equalsIgnoreCase(name)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Tên sản phẩm đã tồn tại!");
            } else {
                this.productName = name;
                break;
            }
        }

        while (true) {
            System.out.print("Nhập giá: ");
            if(scanner.hasNextDouble()) {
                float p = Float.parseFloat(scanner.nextLine());
                if (p > 0) {
                    this.price = p;
                    break;
                }
            }
            System.out.println("Phải nhập số lớn hơn 0");
        }

        // Danh mục
        while (true) {
            System.out.print("Nhập danh mục: ");
            String cate = scanner.nextLine();
            if (cate.length() <= 200) {
                this.category = cate;
                break;
            }
            System.out.println("Danh mục tối đa 200 ký tự");
        }

        while (true) {
            System.out.print("Nhập số lượng: ");
            if(scanner.hasNextDouble()) {
                int q = Integer.parseInt(scanner.nextLine());
                if (q >= 0) {
                    this.quantity = q;
                    break;
                }
            }
            System.out.println("Số lượng >= 0");
        }
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Price: " + price + ", Category: " + category + ", Quantity: " + quantity;
    }
}
