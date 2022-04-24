package com.example.CRUD_REST_API_USING_SPRINGBOOT.forStudent;

import javax.persistence.*;
import java.time.LocalDate;

@Table

@Entity

public class student_Basic_Details_Form {
    @Id
    @SequenceGenerator(
            name ="student_order",
            sequenceName = "Roll_number",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Roll_number"
    )
    @Column(name = "student_roll")
    private long Roll_Number;
    private String Name;
    private String Registration_number;
    private String Department;
    private String Shift;
    private String Group;
    private String Session;
    private String Contact;
    private LocalDate Birth_date;

    @Transient
    private int Age;
    private String Email;
    private String Admission_Year;
    private String Address;


    public student_Basic_Details_Form() {
    }

    public student_Basic_Details_Form(
            long Roll_Number,
            String Name,
            String Registration_number,
            String Department,
            String Shift,
            String Group,
            String Session,
            String Contact,
            LocalDate Birth_date,
            String Email_Address,
            String Admission_Year,
            String Address

    ) {
        this.Roll_Number=Roll_Number;
        this.Name=Name;
        this.Registration_number=Registration_number;
        this.Department=Department;
        this.Shift=Shift;
        this.Group=Group;
        this.Session=Session;
        this.Contact=Contact;
        this.Birth_date=Birth_date;
        this.Email=Email;
        this.Admission_Year=Admission_Year;
        this.Address=Address;


    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAdmission_Year() {
        return Admission_Year;
    }

    public void setAdmission_Year(String admission_Year) {
        Admission_Year = admission_Year;
    }

    public String getEmail_Address() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public LocalDate getBirth_date() {
        return Birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        Birth_date = birth_date;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String session) {
        Session = session;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String shift) {
        Shift = shift;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getRegistration_number() {
        return Registration_number;
    }

    public void setRegistration_number(String registration_number) {
        Registration_number = registration_number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getRoll_Number() {
        return Roll_Number;
    }

    public void setRoll_Number(long roll_Number) {
        Roll_Number = roll_Number;
    }
}





