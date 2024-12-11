package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id ;

    @Column(columnDefinition ="varchar(20) not null")

    private String area ;

    @Column(columnDefinition = "varchar(20) not null")
    private String street ;

    @Column(columnDefinition = "varchar(4)")
    private String buildingNumber ;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher ;
}
