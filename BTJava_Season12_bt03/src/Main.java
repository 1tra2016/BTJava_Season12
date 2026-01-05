import ra.business.OrderBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderBusiness business = new OrderBusiness();

        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị đơn hàng (giảm dần)");
            System.out.println("3. Cập nhật trạng thái");
            System.out.println("4. Xóa đơn hàng");
            System.out.println("5. Tìm theo tên khách hàng");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" : business.addOrder(sc);
                case "2" : business.displayOrdersDesc();
                case "3" :
                    System.out.print("Nhập ID: ");
                    business.updateStatus(Integer.parseInt(sc.nextLine()),sc);
                case "4" :
                    System.out.print("Nhập ID: ");
                    business.deleteOrder(Integer.parseInt(sc.nextLine()));
                case "5" :
                    System.out.print("Nhập tên KH: ");
                    business.searchByCustomer(sc.nextLine());
                case "6" : business.statistics();
                case "0" : System.exit(0);
                default : System.out.println("Lựa chọn không tồn tại");
            }
        }
    }
}
