package lk.ijse.DTO;

import lk.ijse.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String student_id;
    private String name;
    private String address;
    private String contact;
    private User userId;
    private LocalDate date;

    public StudentDTO(String student_id, String name){
        this.student_id = student_id;
        this.name = name;
    }
}
