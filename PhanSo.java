package thucHanhSo2;
import java.util.Scanner;
public class PhanSo {

	private int tu, mau;
	PhanSo() {
		this.tu=0;
		this.mau=1;
	}
	public PhanSo(int tu, int mau) {
		this.tu= tu;
		this.mau=mau;
		this.rutGon();
	}
	public boolean checkMau() {
		if(mau==0) return false;
		return true;
	}
	public void nhapPhanSo() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập tử số ");
		tu= ip.nextInt();
		System.out.print("Nhập mẫu số ");
		do{
			mau= ip.nextInt();
			if(!checkMau()) System.out.print("Mẫu số không hợp lệ. Vui lòng nhập lại mẫu số ");
		}while(!checkMau());
	}
	public PhanSo rutGon() {
		int ucln = (int)UCLN(Math.abs(this.tu),Math.abs(this.mau));
		tu/=ucln;
		mau/=ucln;
		return this;
	}
	//In giá trị tham số
	public void hienThi() {
		rutGon();
		if(tu==0) System.out.println(0);
		else if(mau==1) {
			System.out.println(tu);
		}
		else System.out.println(tu+" / " +mau);
	}
	public int UCLN(int a, int b) {
		if(b==0) return a;
		return UCLN(b, a%b);
	}
	//Làm thay đổi giá trị phân số
	public void nghichDao() {
		rutGon();
		if(this.tu==0) System.out.println(0);
		else if(this.mau==1) {
			System.out.println(this.tu);
		}
		else System.out.println(this.tu+" / " +this.mau);

	}
	public PhanSo giaTriNghichDao() {
		rutGon();
		return new PhanSo(this.mau, this.tu);
	}
	public double realValue() {
		return (double)this.tu/this.mau;
	}
	public boolean lonHon(PhanSo a) {
		double phanSo= this.tu/this.mau;
		double phanSoA= a.tu/a.mau;
		return (phanSo > phanSoA)? true: false;
	}
	
	
//	public PhanSo cong(PhanSo a) {
//		int TU = ((this.tu * a.mau) +(a.tu* this.mau));
//		int MAU= (this.mau*a.mau);
//		int ucln= (int)UCLN(TU,MAU);
//		return new PhanSo(TU/ucln,MAU/ucln);
//	}
	
	
	
	
	public static void main(String[] args) {
		PhanSo ps= new PhanSo();
		ps.nhapPhanSo();
		System.out.println("Phân số là ");
		ps.hienThi();
		PhanSo psNghichDao = ps.giaTriNghichDao();
		System.out.println("Nghịch đảo của phân số đó là ");
		psNghichDao.hienThi();
		System.out.println("Double check phân số là ");
		ps.hienThi();
		System.out.println("Giá trị thực của phân số đó là "+ ps.realValue());
		System.out.println("Nhập 1 phân số a để so sánh ");
		PhanSo a= new PhanSo();
		a.nhapPhanSo();
		System.out.println("Phân số hiện tại có lớn hơn phân số a không? ");
		if(ps.lonHon(a)) {
			System.out.println("TRUE");
		}
		else System.out.println("FALSE");
//		PhanSo Tong = ps.cong(a);
//		Tong.hienThi();
	}

}
