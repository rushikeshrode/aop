package in.rush.aop.controller;

import in.rush.aop.pojo.Student;
import in.rush.aop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("all")
    public ResponseEntity<?> retrieveAllStudents(){
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> retrieveStudentById(@PathVariable int id){
        Student studentById = studentService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id){
        Student student = studentService.deleteStudent(id);
        if (student.getId() == -1)
            throw new RuntimeException("Student not Found at : " + id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("add")
    public ResponseEntity<?> addStudent(@RequestBody Student newStudent){
        if (studentService.addStudent(newStudent)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }
}
