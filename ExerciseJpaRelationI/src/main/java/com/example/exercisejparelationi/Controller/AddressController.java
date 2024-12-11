package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/getAll")
    public ResponseEntity getAllAddress() {
       List list = addressService.getAll();
       return ResponseEntity.ok().body(list);
    }
    @PostMapping("/saveAddress")
    public ResponseEntity save(@RequestBody@Valid AddressDTO addressDTO) {
        addressService.saveAddress(addressDTO);
        return ResponseEntity.ok().body("address is added ");
    }
    @PutMapping("/updateAddress")
    public ResponseEntity update(@RequestBody@Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok().body("address is updated");
    }
    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok().body("address is deleted");
    }


    @GetMapping("/findByIdTeacher/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        Address address = addressService.getTeacherById(id);
        return ResponseEntity.ok().body(address);

    }


}
