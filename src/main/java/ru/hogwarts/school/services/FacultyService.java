package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.FacultyNotExistException;
import ru.hogwarts.school.models.Faculty;
import ru.hogwarts.school.models.Student;


import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();

    private Long numberId = 0l;

    public Faculty create(String name, String color) {
        Faculty faculty = new Faculty(numberId, name, color);
        faculties.put(numberId, faculty);
        numberId++;
        return faculty;
    }

    public Faculty read(Long id) {
        existValidator(id);
        Faculty faculty = faculties.get(id);
        return faculty;
    }

    public Faculty update(Long id, String name, String color) {
        Faculty faculty = new Faculty(id, name, color);
        existValidator(id);
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty delete(Long id) {
        existValidator(id);
        Faculty faculty = faculties.get(id);
        faculties.remove(id);
        return faculty;
    }

    private void existValidator(Long id) {
        if (!faculties.containsKey(id)) {
            throw new FacultyNotExistException();
        }
    }

    public Collection<Faculty> filterByColor(String color) {
        List<Faculty> result = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (faculty.getColor() == color) {
                result.add(faculty);
            }
        }
        return result;
    }

}
