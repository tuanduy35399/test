package thucHanhSo2;
import java.util.Scanner;
import java.time.LocalDate;
public class Date {
	private int d,m,y;
	private int n=0;
	Date(){
		this.d=1;
		this.m=1;
		this.y=2000;
	}
	public Date(int d, int m, int y) {
		if(hopLe(d,m,y)) {
		this.d=d;
		this.m=m;
		this.y=y;
		}
		else {
			this.d=1;
			this.m=1;
			this.y=2000;
		}
	}
	public void hienThi() {
		System.out.println("Ngay "+d + " thang "+m+" nam "+y);
	}
	public boolean hopLe(int d, int m, int y) {
		try {
			LocalDate date =LocalDate.of(y,m,d);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean hopLe() {
		return hopLe(this.d, this.m, this.y);
	}

	public void nhap() {
		Scanner ip= new Scanner(System.in);
		do {
			System.out.print("Nhập ngày: ");
			d=ip.nextInt();
			System.out.print("Nhập tháng: ");
			m=ip.nextInt();
			System.out.print("Nhập năm: ");
			y=ip.nextInt();
		}
		while(!hopLe());
	}
	public Date ngayHomSau() {
		LocalDate date = LocalDate.of(y,m,d).plusDays(1);
		return new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
	}
	public Date congNgay(int n) {
	        LocalDate date = LocalDate.of(y, m, d).plusDays(n);
	        return new Date(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
	    }
	public static void main(String[] args) {
		Scanner ip= new Scanner(System.in);
		Date obj= new Date();
		obj.nhap();
		obj.hienThi();
		if (obj.hopLe()) {
            System.out.println("Ngày hợp lệ.");
        } else {
            System.out.println("Ngày không hợp lệ.");
        }
		Date tomorrow = obj.ngayHomSau();
		System.out.print("Ngày hôm sau là ");
		tomorrow.hienThi();
		System.out.print("Nhập số ngày muốn cộng ");
		int n= ip.nextInt();
		Date newDate = obj.congNgay(n);
		System.out.print("Sau "+ n + " ngay, ngay moi la ");
		newDate.hienThi();
	}

}

