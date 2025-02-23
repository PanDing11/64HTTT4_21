public class Bai1 {
    public static void main(String[] args) {
        QuanLyLopHoc quanLy = QuanLyLopHoc.getInstance();
        
        // Hỏi người dùng có muốn tạo dữ liệu mẫu ngay từ đầu không
        System.out.println("Chương trình Quản lý lớp học CNTT");
        System.out.print("Bạn có muốn tạo sẵn dữ liệu mẫu không? (Y/N): ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String answer = scanner.nextLine();
        
        if (answer.equalsIgnoreCase("Y")) {
            quanLy.taoDuLieuMau();
        }
        
        quanLy.hienThiMenu();
    }
}
