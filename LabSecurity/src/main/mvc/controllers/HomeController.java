package main.mvc.controllers;

import main.mvc.entities.Student;
import main.mvc.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    public static final int STUDENTS_ON_THE_PAGE = 25;
    @Autowired
    private StudentsService studentsService;


    @RequestMapping({"/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("mainText", "Hello World");
        model.addAttribute("studentsList", studentsService.getAllStudents());
        return "home";
    }

    @GetMapping("students/{id}")
    public ModelAndView showOneStudent(@PathVariable int id) {
        Student student = studentsService.getStudentById(id);
        ModelAndView model = new ModelAndView("home");
        model.addObject("mainText", student.getPib() + ", course: " + student.getCourse());
        return model;
    }
}