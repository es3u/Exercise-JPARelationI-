package com.example.exercisejparelationi.Repository;

import com.example.exercisejparelationi.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);

    Address findAddressByTeacherId(Integer teacherId);
}
