package main.mvc.controllers;

import main.mvc.entities.Student;
import main.mvc.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(name="/admin")
    public ModelAndView workWithStudents(){
        ModelAndView model = new ModelAndView("/admin/main");
        model.addObject("mainText","Admin part of work with students");
        model.addObject("studentsList",studentsService.getAllStudents());
        return model;
    }

    @RequestMapping(name="/admin", method= RequestMethod.POST)
    public ModelAndView createStudent(@RequestParam String pib, @RequestParam int course){
        System.out.println("New student add");
        Student newStudent = new Student();
        newStudent.setPib(pib);
        newStudent.setCourse(course);
        studentsService.addStudent(newStudent);

        ModelAndView model = new ModelAndView("/admin/main");
        model.addObject("mainText","Added student!");
        model.addObject("studentsList",studentsService.getAllStudents());
        return model;
    }
}