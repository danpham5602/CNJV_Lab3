package net.codejava.hibernate;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Employee")
    private int Employee;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "manufacture_id")
    private List<Phone> listPhone = new ArrayList<Phone>();


    public List<Phone> getListPhone() {
        return listPhone;
    }
    public void setListPhone(List<Phone> listPhone) {
        this.listPhone = listPhone;
    }

    @Override
    public String toString() {
        return "Manufacture [ID=" + ID + ", Name=" + Name + ", Location=" + Location + ", Employee=" + Employee
                +"]";
    }
    public Manufacture(String name, String location, int employee) {
        super();
        Name = name;
        Location = location;
        Employee = employee;
    }
    public Manufacture() {
        super();
        //TODO Auto-generated constructor stub
    }
    public Manufacture(int iD, String name, String location, int employee) {
        super();
        ID = iD;
        Name = name;
        Location = location;
        Employee = employee;
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
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public int getEmployee() {
        return Employee;
    }
    public void setEmployee(int employee) {
        Employee = employee;
    }

}
