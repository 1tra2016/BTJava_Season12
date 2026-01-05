package ra.business;

import ra.entity.Order;
import ra.entity.OrderStatus;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Scanner sc) {
        Order order = new Order();
        order.inputData(sc);
        orders.add(order);
        System.out.println("Thêm đơn hàng thành công");
    }

    public void displayOrdersDesc() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống");
            return;
        }
        orders.sort(new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return Float.compare(o2.getOrderAmount(), o1.getOrderAmount());
            }
        });

        System.out.println("===== DANH SÁCH ĐƠN HÀNG (GIẢM DẦN THEO GIÁ TRỊ) =====");
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public void updateStatus(int id, Scanner sc) {
        Order order = findById(id);
        if (order == null) {
            System.out.println("Không tìm thấy đơn hàng");
            return;
        }
        while (true) {
            System.out.println("Chọn trạng thái đơn hàng: ");
            System.out.println("1.PENDING");
            System.out.println("2.SHIPPED");
            System.out.println("3.DELIVERED");
            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    order.setStatus(OrderStatus.PENDING);
                    System.out.println("Cập nhật thành công");
                    return;
                case "2":
                    order.setStatus(OrderStatus.SHIPPED);
                    System.out.println("Cập nhật thành công");
                    return;
                case "3":
                    order.setStatus(OrderStatus.DELIVERED);
                    System.out.println("Cập nhật thành công");
                    return;
                default:
                    System.out.println("Lựa chọn không tồn tại");
                    break;
            }
        }
    }

    public void deleteOrder(int id) {
        Order order = findById(id);
        if (order == null) {
            System.out.println("Không tìm thấy đơn");
            return;
        }
        if (order.getStatus() != OrderStatus.PENDING) {
            System.out.println("Chỉ xóa được đơn Pending");
            return;
        }
        orders.remove(order);
        System.out.println("Đã xóa đơn hàng");
    }

    public void searchByCustomer(String name) {
        boolean found = false;
        for (Order o : orders) {
            if (o.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(o);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Không tìm thấy đơn hàng phù hợp");
        }
    }

    public void statistics() {
        int totalOrders = orders.size();
        float totalRevenue = 0;

        int pendingCount = 0;
        int shippedCount = 0;
        int deliveredCount = 0;

        Order maxOrder = null;

        for (Order o : orders) {
            if (o.getStatus() == OrderStatus.PENDING) {
                pendingCount++;
            } else if (o.getStatus() == OrderStatus.SHIPPED) {
                shippedCount++;
            } else if (o.getStatus() == OrderStatus.DELIVERED) {
                deliveredCount++;
                totalRevenue += o.getOrderAmount();
            }

            if (maxOrder == null || o.getOrderAmount() > maxOrder.getOrderAmount()) {
                maxOrder = o;
            }
        }

        System.out.println("===== THỐNG KÊ =====");
        System.out.println("Tổng số đơn hàng: " + totalOrders);
        System.out.println("Tổng doanh thu (Delivered): " + totalRevenue);
        System.out.println("Số đơn Pending: " + pendingCount);
        System.out.println("Số đơn Shipped: " + shippedCount);
        System.out.println("Số đơn Delivered: " + deliveredCount);

        if (maxOrder != null) {
            System.out.println("Đơn hàng có giá trị lớn nhất:");
            System.out.println(maxOrder);
        } else {
            System.out.println("Chưa có đơn hàng nào");
        }
    }

    private Order findById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        return null;
    }
}
