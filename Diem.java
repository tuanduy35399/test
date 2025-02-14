package thucHanhSo2;
import java.util.Scanner;
public class Diem {
	private int x;
	private int y;
	Diem() {}
	public Diem(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void nhapDiem() {
		Scanner ip= new Scanner(System.in);
		x= ip.nextInt();
		y= ip.nextInt();
	}
	public void hienThi() {
		System.out.println("("+x+"," +y+")");
	}
	public void doiDiem(int dx, int dy) {
		x+=dx;
		y+=dy;
	}
	public int giaTriX() {
		return x;
	}
	public int giaTriY() {
		return y;
	}
	public float khoangCach() {
		return (float)Math.sqrt(x*x + y*y);
	}
	public float khoangCach(Diem d) {
		return (float)Math.sqrt(Math.pow((d.x - this.x), 2) + Math.pow((d.y - this.y), 2));
	}
}
class SDDiem {
	public static void main(String[] args) {
		Diem A = new Diem(3,4);
		A.hienThi();
		Diem B = new Diem();
		B.nhapDiem();
		B.hienThi();
		Diem C = new Diem(-B.giaTriX(),-B.giaTriY());
		C.hienThi();
		System.out.println(B.khoangCach());
		System.out.println(A.khoangCach(B));
	}
}
