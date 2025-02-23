import java.util.*;
class LopHoc {
    private String maLop;
    private String tenLop;
    private List<SinhVien> danhSachSinhVien;

    public LopHoc(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.danhSachSinhVien = new ArrayList<>();
    }

    public void themSinhVien(SinhVien sv) {
        danhSachSinhVien.add(sv);
    }

    public String getMaLop() {
        return maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public int getSoSinhVien() {
        return danhSachSinhVien.size();
    }


    public int demSinhVienTheoRank(char rank) {
        int count = 0;
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getRank() == rank) {
                count++;
            }
        }
        return count;
    }

    public void hienThiThongTinLop() {
        System.out.println("Mã lớp: " + maLop);
        System.out.println("Tên lớp: " + tenLop);
        System.out.println("Tổng số sinh viên: " + danhSachSinhVien.size());
    }

    public void hienThiDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Lớp chưa có sinh viên nào.");
            return;
        }

        System.out.println("\n=== DANH SÁCH SINH VIÊN LỚP " + tenLop + " ===");
        System.out.printf("%-5s %-15s %-15s %-12s %-20s %-10s %-10s\n",
                "STT", "Họ", "Tên", "Ngày sinh", "Địa chỉ", "Lớp", "Điểm TB (Xếp loại)");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        int stt = 1;
        for (SinhVien sv : danhSachSinhVien) {
            System.out.printf("%-5d %s\n", stt++, sv);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    public void hienThiThongKe() {
        System.out.println("\n=== THỐNG KÊ SINH VIÊN THEO RANK ===");
        System.out.println("Rank A: " + demSinhVienTheoRank('A') + " sinh viên");
        System.out.println("Rank B: " + demSinhVienTheoRank('B') + " sinh viên");
        System.out.println("Rank C: " + demSinhVienTheoRank('C') + " sinh viên");
        System.out.println("Rank D: " + demSinhVienTheoRank('D') + " sinh viên");
        System.out.println("Rank F: " + demSinhVienTheoRank('F') + " sinh viên");
    }
}
