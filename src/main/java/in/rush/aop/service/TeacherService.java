package in.rush.aop.service;

import in.rush.aop.pojo.Teacher;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeacherService {

    List<Teacher> teacherList = new ArrayList<>();

    @PostConstruct
    private void initTeachers() {
        teacherList.add(Teacher.builder().id(1).name("Mr. Sharma").subject("Math").school("DPS").build());
        teacherList.add(Teacher.builder().id(2).name("Ms. Rao").subject("Science").school("DAV").build());
        teacherList.add(Teacher.builder().id(3).name("Mr. Nair").subject("English").school("Ryan").build());
        teacherList.add(Teacher.builder().id(4).name("Mrs. Iyer").subject("History").school("KV").build());
        teacherList.add(Teacher.builder().id(5).name("Mr. Kulkarni").subject("Physics").school("St. Xavier").build());
        teacherList.add(Teacher.builder().id(6).name("Ms. Das").subject("Chemistry").school("Delhi Public").build());
        teacherList.add(Teacher.builder().id(7).name("Mr. Mehta").subject("Biology").school("NPS").build());
        teacherList.add(Teacher.builder().id(8).name("Ms. Sen").subject("Computer").school("Global").build());
        teacherList.add(Teacher.builder().id(9).name("Mr. Gupta").subject("Geography").school("Oxford").build());
        teacherList.add(Teacher.builder().id(10).name("Mrs. Reddy").subject("Economics").school("City School").build());
        log.info(teacherList.size() + " teachers added to Database ::");
    }

    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    public Teacher getTeacherById(int id){
        return teacherList.get(id - 1);
    }

    public boolean addTeacher(Teacher newTeacher){
        return teacherList.add(newTeacher);
    }

    public Teacher deleteTeacher(int id){
        return teacherList.remove(id - 1);
    }


}
