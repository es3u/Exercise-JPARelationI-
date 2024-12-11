package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.ApiException.ApiException;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.AddressRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

        public List<Teacher> getAllTeachers() {
            return teacherRepository.findAll();
        }
        public void addTeacher(Teacher teacher) {
            teacherRepository.save(teacher);
        }
        public void updateTeacher(Integer id ,Teacher teacher) {
            Teacher teacher1 = teacherRepository.findTeacherById(id);
            if(teacher1 == null) {
                throw new ApiException("teacher not found");
            }
            teacher1.setName(teacher.getName());
            teacher1.setEmail(teacher.getEmail());
            teacher1.setAge(teacher.getAge());
            teacher1.setSalary(teacher.getSalary());
            teacherRepository.save(teacher1);
        }

        public void deleteTeacher(Integer id) {
            Teacher teacher1 = teacherRepository.findTeacherById(id);
            Address address = addressRepository.findAddressById(id) ;
            if(address == null) {
                throw new ApiException("address not found");
            }
            if(teacher1 == null) {
                throw new ApiException("teacher not found");

            }
            teacher1.setAddress(null);
            teacherRepository.delete(teacher1);
            addressRepository.delete(address);
        }

        public Teacher getTeacherById(Integer id) {
            Teacher teacher =  teacherRepository.findTeacherById(id);

            if (teacher == null) {
                throw new ApiException("teacher not found");
            }
            return teacher;
        }
}
