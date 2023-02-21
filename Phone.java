package net.codejava.hibernate;


import javax.inject.Singleton;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MobilePhone")
public class Phone {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name = "Name",nullable = false,length = 128)
	
	private String Name;
	
	@Column(name = "Price",nullable = false)
	private int Price;
	
	@Column(name = "Color",nullable = false)
	private String Color;
	
	@Column(name = "Country",nullable = false,length = 128)
	private String Country;
	
	@Column(name = "Quantity",nullable = false)
	private int Quantity;
	
	@ManyToOne
	@JoinColumn(name = "manufacture_id",nullable = false)
	private Manufacture manufacture_id;
	
	
	public Manufacture getManufacture_id() {
		return manufacture_id;
	}
	public void setManufacture_id(Manufacture manufacture_id) {
		this.manufacture_id = manufacture_id;
	}
	public Phone(int iD, String name, int price, String color, String country, int quantity) {
		super();
		ID = iD;
		Name = name;
		Price = price;
		Color = color;
		Country = country;
		Quantity = quantity;
	}
	public Phone(String name, int price, String color, String country, int quantity) {
		super();
		Name = name;
		Price = price;
		Color = color;
		Country = country;
		Quantity = quantity;
	}
	public Phone() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Phone [ID=" + ID + ", Name=" + Name + ", Price=" + Price + ", Color=" + Color + ", Country=" + Country
				+ ", Quantity=" + Quantity + ", manufacture_id=" + manufacture_id + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
