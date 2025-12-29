import ra.business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentBusiness business = new AppointmentBusiness();

        while (true) {
            System.out.println("\n******** QUẢN LÝ LỊCH HẸN ********");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn");
            System.out.println("5. Xóa lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> business.addAppointment(sc);
                case 2 -> business.displayAppointments();
                case 3 -> business.searchByPatientName(sc);
                case 4 -> business.updateAppointment(sc);
                case 5 -> business.deleteAppointment(sc);
                case 6 -> business.statistic();
                case 7 -> {
                    System.out.println("Kết thúc chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
