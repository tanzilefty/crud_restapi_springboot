package com.example.CRUD_REST_API_USING_SPRINGBOOT.forStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  Database_Repository extends JpaRepository<student_Basic_Details_Form,Long>{

    /* this interface is responsible for data access from database */

    // select * from student where email = <givenEmail>;
    /*
     * Optional is a new container type that wraps a single value, if the value is available.
     * So it's meant to convey the meaning that the value might be absent.
     */

    Optional<student_Basic_Details_Form> findByEmail(String Email);
}
