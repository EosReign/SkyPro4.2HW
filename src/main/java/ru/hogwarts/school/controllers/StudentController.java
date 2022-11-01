package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path ="/{name}/{age}")// POST https://localhost:8080/students
    public Student createStudent(@PathVariable String name,
                                 @PathVariable int age) {
        return studentService.create(name, age);
    }

    @PostMapping(path = "/{id}")
    public Student readStudent(@PathVariable Long id) {
        return studentService.read(id);
    }

    @PutMapping(path = "/{id}/{name}/{age}")
    public Student updateStudent(@PathVariable Long id,
                                 @PathVariable String name,
                                 @PathVariable int age) {
        return studentService.update(id, name, age);
    }

    @DeleteMapping(path = "/{id}") // DELETE https://localhost:8080/students/23
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @PostMapping(path = "/age/{age}")
    public Collection<Student> filterStudent(@PathVariable int age) {
        return studentService.filterByAge(age);
    }
}
