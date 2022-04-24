package com.example.CRUD_REST_API_USING_SPRINGBOOT.forStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "app/home")
class Landing_page{
    @GetMapping
    public ResponseEntity<String> Landing_page(){
        return new ResponseEntity<>(
                "***  welcome to our api service......**",
                HttpStatus.OK
        );
    }
}


@RestController
@RequestMapping(path = "app/student")
public class api_messages_and_path {



    private CRUD_operations CRUD_operations;


    @Autowired
    public api_messages_and_path(CRUD_operations CRUD_operations) { this.CRUD_operations=CRUD_operations;}



    @GetMapping
    public ResponseEntity<List<student_Basic_Details_Form_data>> getStudent()
    {

        List<student_Basic_Details_Form>StudentList=CRUD_operations.getStudent();

          List<student_Basic_Details_Form_data>ReturnList= utilities.MultiObjToJson(StudentList);
          return new ResponseEntity<>(ReturnList,HttpStatus.OK);

    }
    @GetMapping(path = "{Roll_Number}")
    public ResponseEntity<student_Basic_Details_Form_data>getStudentById(@PathVariable("Roll_Number") Long Roll_Number)
    {
        student_Basic_Details_Form Student =CRUD_operations.getStudentByRoll(Roll_Number);

        student_Basic_Details_Form_data student =utilities.SingleObjToJson(Student);
        return new ResponseEntity<>(student,HttpStatus.FOUND);

    }
        @PostMapping
                public ResponseEntity<String>NewStudent(@RequestBody student_Basic_Details_Form Student)
        {
            CRUD_operations.addNewStudentData(Student);
            return new ResponseEntity<>("Successfully Created",
                    HttpStatus.CREATED);
        }


    @PutMapping(path = "{Roll_Number}")
    public ResponseEntity<String>UpdateData(
            @PathVariable("Roll_Number") Long Roll_Number,
            @RequestBody student_Basic_Details_Form Student
    )
    {
        CRUD_operations.updateData(Roll_Number,Student);
        return new ResponseEntity<>("sucessfully updated",HttpStatus.OK);

    }

    @DeleteMapping(path = "{Roll_Number}")
    public ResponseEntity<String>DeleteData(@PathVariable("Roll_Number") Long Roll_Number)
    {
        CRUD_operations.DeleteStudentData(Roll_Number);
        return new ResponseEntity<>(
                "successfully deleted",HttpStatus.OK
        );

    }


}

