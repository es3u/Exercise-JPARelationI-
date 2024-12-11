package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/getAllTeachers")
    public ResponseEntity getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok().body(teachers);
    }

    @PostMapping("/addTeacher")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok().body("teacher added");
    }
    @PutMapping("/updatedTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id ,@RequestBody@Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.ok().body("teacher updated");
    }

    @DeleteMapping("/deletedTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().body("teacher deleted");
    }

    @GetMapping("/findTeacher/{id}")
    public ResponseEntity findTeacherById(@PathVariable Integer id){
       Teacher teacher = teacherService.getTeacherById(id);
       return ResponseEntity.ok().body(teacher);
    }


}
