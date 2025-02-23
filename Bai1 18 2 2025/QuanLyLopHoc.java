class QuanLyLopHoc {
    private static QuanLyLopHoc instance;
    private java.util.Map<String, LopHoc> danhSachLop;
    private java.util.Scanner scanner;

    private QuanLyLopHoc() {
        danhSachLop = new java.util.HashMap<>();
        scanner = new java.util.Scanner(System.in);
    }

    public static QuanLyLopHoc getInstance() {
        if (instance == null) {
            instance = new QuanLyLopHoc();
        }
        return instance;
    }

    // Thêm lớp mới
    public void themLop() {
        System.out.print("Nhập mã lớp: ");
        String maLop = scanner.nextLine();
        
        if (danhSachLop.containsKey(maLop)) {
            System.out.println("Lớp này đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập tên lớp: ");
        String tenLop = scanner.nextLine();
        
        LopHoc lopMoi = new LopHoc(maLop, tenLop);
        danhSachLop.put(maLop, lopMoi);
        
        System.out.println("Đã thêm lớp mới thành công!");
    }

    // Thêm sinh viên vào lớp
    public void themSinhVien() {
        if (danhSachLop.isEmpty()) {
            System.out.println("Chưa có lớp nào được tạo. Vui lòng tạo lớp trước!");
            return;
        }

        // Hiển thị danh sách lớp
        hienThiDanhSachLop();
        
        System.out.print("Nhập mã lớp muốn thêm sinh viên: ");
        String maLop = scanner.nextLine();
        
        if (!danhSachLop.containsKey(maLop)) {
            System.out.println("Mã lớp không tồn tại!");
            return;
        }
        
        // Nhập thông tin sinh viên
        System.out.println("=== NHẬP THÔNG TIN SINH VIÊN MỚI ===");
        System.out.print("Họ: ");
        String firstName = scanner.nextLine();
        System.out.print("Tên: ");
        String lastName = scanner.nextLine();
        System.out.print("Ngày sinh (dd/mm/yyyy): ");
        String birthdate = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        
        // Tạo sinh viên mới
        SinhVien svMoi = new SinhVien(firstName, lastName, birthdate, address, maLop);
        
        // Nhập điểm các môn học
        System.out.println("=== NHẬP ĐIỂM CÁC MÔN HỌC ===");
        DiemMonHoc diemMonHoc = svMoi.getDiemMonHoc();
        
        System.out.print("Điểm Lập trình hướng đối tượng: ");
        diemMonHoc.setLapTrinhHuongDoiTuong(nhapDiem());
        
        System.out.print("Điểm Quản lý dự án: ");
        diemMonHoc.setQuanLyDuAn(nhapDiem());
        
        System.out.print("Điểm Học Máy: ");
        diemMonHoc.setHocMay(nhapDiem());
        
        System.out.print("Điểm Cơ sở dữ liệu: ");
        diemMonHoc.setCoSoDuLieu(nhapDiem());
        
        System.out.print("Điểm Lập trình ứng dụng cho TBDĐ: ");
        diemMonHoc.setLapTrinhUngDungTBDD(nhapDiem());
        
        // Thêm sinh viên vào lớp
        danhSachLop.get(maLop).themSinhVien(svMoi);
        System.out.println("Đã thêm sinh viên thành công!");
    }
    
    // Phương thức hỗ trợ nhập điểm với validation
    private double nhapDiem() {
        double diem = -1;
        while (diem < 0 || diem > 10) {
            try {
                diem = Double.parseDouble(scanner.nextLine());
                if (diem < 0 || diem > 10) {
                    System.out.print("Điểm phải nằm trong khoảng từ 0-10. Nhập lại: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Điểm không hợp lệ! Vui lòng nhập lại: ");
                diem = -1;
            }
        }
        return diem;
    }

    // Hiển thị danh sách lớp
    public void hienThiDanhSachLop() {
        if (danhSachLop.isEmpty()) {
            System.out.println("Hiện chưa có lớp nào được tạo.");
            return;
        }

        System.out.println("\n=== DANH SÁCH LỚP ===");
        System.out.printf("%-10s %-20s %-15s\n", "Mã lớp", "Tên lớp", "Số sinh viên");
        System.out.println("------------------------------------------");
        
        for (LopHoc lop : danhSachLop.values()) {
            System.out.printf("%-10s %-20s %-15d\n", 
                    lop.getMaLop(), lop.getTenLop(), lop.getSoSinhVien());
        }
        System.out.println("------------------------------------------");
    }

    // Quản lý thông tin một lớp cụ thể
    public void quanLyLop() {
        if (danhSachLop.isEmpty()) {
            System.out.println("Hiện chưa có lớp nào được tạo.");
            return;
        }

        hienThiDanhSachLop();
        
        System.out.print("Nhập mã lớp muốn xem chi tiết: ");
        String maLop = scanner.nextLine();
        
        if (!danhSachLop.containsKey(maLop)) {
            System.out.println("Mã lớp không tồn tại!");
            return;
        }
        
        LopHoc lop = danhSachLop.get(maLop);
        lop.hienThiThongTinLop();
        lop.hienThiDanhSachSinhVien();
        lop.hienThiThongKe();
    }
    
    // Menu chính của chương trình
    public void hienThiMenu() {
        while (true) {
            System.out.println("\n=== CHƯƠNG TRÌNH QUẢN LÝ LỚP HỌC CNTT ===");
            System.out.println("1. Thêm lớp mới");
            System.out.println("2. Thêm sinh viên vào lớp");
            System.out.println("3. Xem danh sách lớp");
            System.out.println("4. Xem chi tiết lớp và thống kê");
            System.out.println("0. Thoát chương trình");
            System.out.print("Lựa chọn của bạn: ");
            
            int luaChon;
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }
            
            switch (luaChon) {
                case 1:
                    themLop();
                    break;
                case 2:
                    themSinhVien();
                    break;
                case 3:
                    hienThiDanhSachLop();
                    break;
                case 4:
                    quanLyLop();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}