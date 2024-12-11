package com.example.exercisejparelationi.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @Id
    private Integer teacher_id ;

    @NotEmpty(message = "area can not be null")
    @Size(max = 20)
    private String area ;

    @NotEmpty(message = "building Number can not be null")
    @Size(max = 4)
    private String building_Number ;

    @NotEmpty(message = "street can not be null")
    @Size(max = 20)
    private String street ;

}
