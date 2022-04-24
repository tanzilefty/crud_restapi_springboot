package com.example.CRUD_REST_API_USING_SPRINGBOOT.forStudent;
import java.util.ArrayList;
import java.util.List;


public class utilities {

    public static student_Basic_Details_Form_data SingleObjToJson(student_Basic_Details_Form Student) {
        return new student_Basic_Details_Form_data(
                Student.getRoll_Number(),
                Student.getName(),
                Student.getRegistration_number(),
                Student.getDepartment(),
                Student.getShift(),
                Student.getGroup(),
                Student.getSession(),
                Student.getContact(),
                Student.getBirth_date(),
                Student.getEmail_Address(),
                Student.getAdmission_Year(),
                Student.getAddress()


        );


    }

    public static List<student_Basic_Details_Form_data> MultiObjToJson(List<student_Basic_Details_Form> StudntForm) {
        List<student_Basic_Details_Form_data> ReturnList = new ArrayList<>();
        for (student_Basic_Details_Form Student : StudntForm) {
            student_Basic_Details_Form_data student = new student_Basic_Details_Form_data(
                    Student.getRoll_Number(),
                    Student.getName(),
                    Student.getRegistration_number(),
                    Student.getDepartment(),
                    Student.getShift(),
                    Student.getGroup(),
                    Student.getSession(),
                    Student.getContact(),
                    Student.getBirth_date(),
                    Student.getEmail_Address(),
                    Student.getAdmission_Year(),
                    Student.getAddress()
            );
            ReturnList.add(student);

        }
        return ReturnList;
    }

}




