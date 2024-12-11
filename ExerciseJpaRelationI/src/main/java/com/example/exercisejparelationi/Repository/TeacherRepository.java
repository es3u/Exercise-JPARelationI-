package com.example.exercisejparelationi.Repository;

import com.example.exercisejparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findTeacherById(Integer id);
}
