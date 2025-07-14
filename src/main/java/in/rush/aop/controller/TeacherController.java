package in.rush.aop.controller;

import in.rush.aop.pojo.Teacher;
import in.rush.aop.service.StudentService;
import in.rush.aop.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("all")
    public ResponseEntity<?> retrieveAllStudents(){
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> retrieveTeacherById(@PathVariable int id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable int id){
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }

    @PostMapping("add")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher newTeacher){
        boolean b = teacherService.addTeacher(newTeacher);
        if (b)  return new ResponseEntity<>(HttpStatus.CREATED);
        else return ResponseEntity.badRequest().build();
    }



}
