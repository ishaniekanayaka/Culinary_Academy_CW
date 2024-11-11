package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Student {

    @Id
    private String student_id;
    private String name;
    private String address;
    private String contact;
    private LocalDate date;

    @ManyToOne
    private User user;


}
