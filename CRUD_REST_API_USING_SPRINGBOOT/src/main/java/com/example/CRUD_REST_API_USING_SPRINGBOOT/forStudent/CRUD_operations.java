package com.example.CRUD_REST_API_USING_SPRINGBOOT.forStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CRUD_operations {
    private final  Database_Repository Database_Repository;

    @Autowired
    public CRUD_operations (Database_Repository Database_Repository){this.Database_Repository = Database_Repository;}

    public List<student_Basic_Details_Form>getStudent(){
        return Database_Repository.findAll();
    }
    public student_Basic_Details_Form getStudentByRoll(Long Roll_Number)
    {
        student_Basic_Details_Form Student = Database_Repository.findById(Roll_Number)
                .orElseThrow(()-> new  IllegalStateException(
                        "Student with Roll"+Roll_Number+"does not exist"
                ));
        return Student;

    }

    public  void  addNewStudentData (student_Basic_Details_Form Student){


        Optional<student_Basic_Details_Form> StudentOptional=Database_Repository.findByEmail(student_Basic_Details_Form_data.getEmail_Address());
        if (StudentOptional.isPresent()){
            throw new IllegalStateException("Email already exist");
        }
        Database_Repository.save(Student);
    }

    @Transactional
    public void updateData(
            Long Roll_Number,student_Basic_Details_Form updateForm)

    {
        student_Basic_Details_Form CurrentStudent = Database_Repository.findById(Roll_Number)
                .orElseThrow(()->new IllegalStateException(
                        "student with is Roll"+Roll_Number+"already exist"
                ));
        //name
        if (updateForm.getName() != null){
            CurrentStudent.setName(updateForm.getName());
        }
        //dept
        if (updateForm.getDepartment() !=null){
            CurrentStudent.setDepartment(updateForm.getDepartment());
        }
        //shift
        if (updateForm.getShift()!=null){
            CurrentStudent.setShift(updateForm.getShift());

        }
        //group
        if (updateForm.getGroup()!=null){
            CurrentStudent.setGroup(updateForm.getGroup());

        }
        //Session
        if (updateForm.getSession()!=null){
            CurrentStudent.setSession(updateForm.getSession());
        }
        //Contact
        if (updateForm.getContact()!=null){
            CurrentStudent.setContact(updateForm.getContact());
        }
        //Birthdate
        if (updateForm.getBirth_date()!=null){
            CurrentStudent.setBirth_date(updateForm.getBirth_date());
        }
        //admission_year
        if (updateForm.getAdmission_Year()!=null){
            CurrentStudent.setAdmission_Year(updateForm.getAdmission_Year());
        }
        //email
        if (updateForm.getEmail_Address()!=null){
            CurrentStudent.setEmail(updateForm.getEmail_Address());
        }
    }

    public void DeleteStudentData(Long Roll_Number){
        boolean isExist=Database_Repository.existsById(Roll_Number);
        if (!isExist){
            throw new IllegalStateException("student data not found with this "+Roll_Number);
        }
        Database_Repository.deleteById(Roll_Number);
    }
}
