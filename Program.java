package net.codejava.hibernate;

// Chỉ được chạy 1 lần chạy lần 2 sẽ bị lặp câu lệnh và xảy ra lỗi
// Nếu muốn thử hãy thêm // trước những câu lệnh của add và set để kiểm tra những chức năng còn lại
// Vì id là tăng dần và tự động nên khi chạy id sẽ thay đổi liên tục.
// Muốn chạy hãy vào cơ sỡ dữ liệu localhostPHP để tạo 2 bảng Manufacture và mobilephone với thuộc tính như ở lớp Phone.java và Manufacture.java
// Tạo bảng với khóa ngoại và khóa chính,....
// Chúc bạn may mắn!!!!!
public class Program {
	public static void main(String[] args) {
		
		ManufactureDAO b = new ManufactureDAO();
		 
		 Manufacture m1 = new Manufacture("USPhone","US",5879);
		 Manufacture m2 = new Manufacture("VNPhone", "VN", 5000);
		 Manufacture m3 = new Manufacture("TLPhone", "TL", 6544);
		 Manufacture m4 = new Manufacture("KRPhone", "KR", 3248);
		 b.add(m1);
		 b.add(m2);
		 b.add(m3);
		 b.add(m4);
//		 System.out.println(b.get(1).toString());
		 for(Manufacture manufacture : b.getAll()) {
	        	System.out.println(manufacture.toString());
	        }
		 System.out.println("All manufacturers have more than 100 employee: " + b.check100Employee());
		 System.out.println("Employee count: " + b.SumOfEmployee());
		 try {
				System.out.println("The last manufacture in us: " + b.lastUS());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		PhoneDAO a = new PhoneDAO();
		
		Phone p1 = new Phone("Iphone 13 pro max",35000000,"Purple","America",98);
		Phone p2 = new Phone("Samsung S22 Ultra",25000000,"Pink","Korea",2);
		Phone p3 = new Phone("Oppo A35",1500000,"Green","China",1);
		Phone p4 = new Phone("Xaomi S35",1500000,"Blue","China",1);
		p1.setManufacture_id(m1);
		p2.setManufacture_id(m1);
		p3.setManufacture_id(m3);
		p4.setManufacture_id(m2);
		a.add(p1);
		a.add(p2);
		a.add(p4);
		a.add(p3);
//		System.out.println(a.get(5));
//		Phone phoneUpdate = a.get(2);
//		phoneUpdate.setName("Bphone 50");
//		a.update(phoneUpdate);
		for(Phone phone:a.getAll()) {
			System.out.println(phone.toString());
		}
		 System.out.println(a.HighestCharge().toString());
		 for(Phone phone:a.sortByName()) {
			 System.out.println(phone.toString());
		 }
		 System.out.println("Have a phone costs 50M:"+a.check50M());
		 System.out.println(a.check());
		 
	}
}
