package in.rush.aop.service;

import in.rush.aop.pojo.Student;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    @PostConstruct
    private void initStudents(){
        studentList.add(Student.builder().id(1).name("Aarav").school("DPS").city("Pune").build());
        studentList.add(Student.builder().id(2).name("Vihaan").school("DAV").city("Mumbai").build());
        studentList.add(Student.builder().id(3).name("Ishaan").school("Ryan").city("Nagpur").build());
        studentList.add(Student.builder().id(4).name("Advait").school("KV").city("Delhi").build());
        studentList.add(Student.builder().id(5).name("Reyansh").school("St. Xavier").city("Pune").build());
        studentList.add(Student.builder().id(6).name("Vivaan").school("Delhi Public").city("Chennai").build());
        studentList.add(Student.builder().id(7).name("Arjun").school("NPS").city("Bangalore").build());
        studentList.add(Student.builder().id(8).name("Krishna").school("Global").city("Hyderabad").build());
        studentList.add(Student.builder().id(9).name("Kabir").school("Oxford").city("Kolkata").build());
        studentList.add(Student.builder().id(10).name("Rudra").school("City School").city("Ahmedabad").build());
        log.info("{} students added to Database.", studentList.size());
    }


    public List<Student> getStudentList(){
        return studentList;
    }

    public Student getStudentById(int id){
        if (id < 0 || id > studentList.size())  return new Student(-1, "null", "null", "null");
        return studentList.get(id - 1);
    }

    public boolean addStudent(Student newStudent){
        return studentList.add(newStudent);
    }

    public Student deleteStudent(int id){
        if (id < 0 || id > studentList.size())
            return new Student(-1, "null", "null", "null");
        return studentList.remove(id - 1);
    }

}
