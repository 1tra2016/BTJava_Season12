package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private static int auto_id = 1;

    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private OrderStatus status;

    public Order() {
        this.orderId = auto_id++;
        this.status = OrderStatus.PENDING;
    }

    public Order(String customerName, String phoneNumber, String address,
                 float orderAmount, OrderStatus status) {
        this.orderId = auto_id++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public float getOrderAmount() { return orderAmount; }
    public OrderStatus getStatus() { return status; }

    public void setStatus(OrderStatus status) { this.status = status; }

    public void inputData(Scanner sc) {
        while (true) {
            System.out.print("Nhập tên khách hàng: ");
            customerName = sc.nextLine();
            if (customerName.length() >= 2 && customerName.length() <= 100) break;
            System.out.println("Tên phải từ 2-100 ký tự");
        }

        Pattern phonePattern = Pattern.compile("^(0)[0-9]{9}$");
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phoneNumber = sc.nextLine();
            if (phonePattern.matcher(phoneNumber).matches()) break;
            System.out.println("Số điện thoại có 10 chữ số, bắt đầu bằng số 0");
        }

        while (true) {
            System.out.print("Nhập địa chỉ: ");
            address = sc.nextLine();
            if (!address.trim().isEmpty()) break;
            System.out.println("Địa chỉ không được rỗng");
        }

        while (true) {
            try {
                System.out.print("Nhập giá trị đơn hàng: ");
                orderAmount = Float.parseFloat(sc.nextLine());
                if (orderAmount > 0) break;
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Giá trị phải > 0");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | KH: %s | SĐT: %s | Giá trị: %.2f | Trạng thái: %s", orderId, customerName, phoneNumber, orderAmount, status
        );
    }
}
