package seventh.lesson.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import seventh.lesson.homework.entity.Student;
import seventh.lesson.homework.service.StudentService;


@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String studentsPage(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping({"/add"})
    public String create(Model model) {
        model.addAttribute("add", true);
        model.addAttribute("student", new Student());
        return "student";
    }

    @GetMapping({"/edit/{id}"})
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("edit", true);
        model.addAttribute("student", studentService.findById(id));
        return "student";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable("id") Integer id) {
        studentService.remove(id);
        return "redirect:/";
    }

}
