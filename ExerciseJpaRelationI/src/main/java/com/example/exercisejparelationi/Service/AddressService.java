package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.ApiException.ApiException;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.AddressRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }
    public void saveAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuilding_Number(),teacher);
        addressRepository.save(address);


    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new ApiException("address not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuilding_Number());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer teacher_id) {
        Address address = addressRepository.findAddressById(teacher_id);
        if (address == null) {
            throw new ApiException("address not found");
        }
        addressRepository.delete(address);
    }

    public Address getTeacherById(Integer teacher_id) {
        Address address = addressRepository.findAddressByTeacherId(teacher_id);
        if (address == null) {
            throw new ApiException("address not found");
        }
        return address;
    }


}
