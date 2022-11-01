package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(path ="/{name}/{color}")// POST https://localhost:8080/Facultys
    public Faculty createFaculty(@PathVariable String name,
                                 @PathVariable String color) {
        return facultyService.create(name, color);
    }

    @PostMapping(path = "/{id}")// READ
    public Faculty readFaculty(@PathVariable Long id) {
        return facultyService.read(id);
    }

    @PutMapping(path = "/{id}/{name}/{color}") //UPDATE
    public Faculty updateFaculty(@PathVariable Long id,
                                 @PathVariable String name,
                                 @PathVariable String color) {
        return facultyService.update(id, name, color);
    }

    @DeleteMapping(path = "/{id}") // DELETE https://localhost:8080/Facultys/23
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.delete(id);
    }

    @PostMapping(path = "/color/{color}")
    public Collection<Faculty> filterStudent(@PathVariable String color) {
        return facultyService.filterByColor(color);
    }
}
