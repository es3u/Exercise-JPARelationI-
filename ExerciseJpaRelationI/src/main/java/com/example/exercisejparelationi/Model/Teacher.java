package com.example.exercisejparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Check(constraints = "age >15")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "name can not be null")
    @Column(unique = true , columnDefinition = "varchar(10) not null")
    @Size(max = 10)
    private String name;

    @NotNull(message = "age can not be null")
    @Column(columnDefinition = "int not null")
//    @Size(min = 15)
    private Integer age;

    @NotEmpty(message = "email can not be null")
    @Column(columnDefinition = "varchar(50)")
    @Email
    private String email;

    @NotNull(message = "salary can not be null")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
}
