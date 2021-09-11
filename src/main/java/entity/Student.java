package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name= "tbl_student")
public class Student {
    @Id
    @GeneratedValue
    private long StudentID;

    @Column(name= "first_name")
    private String fistName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;
}
