package in.rush.aop.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Teacher {

    private int id;
    private String name;
    private String subject;
    private String school;

}
