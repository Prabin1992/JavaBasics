package com.abc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.demo.Service.StudentService;
import com.abc.demo.dto.StudentCreationDto;
import com.abc.demo.entity.StudentEntity;

@Controller
@RequestMapping("/students")
public class HomeController {

	@Autowired
	StudentService studentService;

	@GetMapping({ "/home", "/" })
	public String home(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name,
			Model model) {
		model.addAttribute("name", name);
		return "home";
	}
	
	@GetMapping("/index")
	public String showMainPage(Model model) {
		
		return "index";
	}

	@GetMapping("/showstudents")
	public String showStudents(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "AllStudent";
	}

	@GetMapping("/create")
	public String showCreateStudentForm(Model model) {
		StudentCreationDto std = new StudentCreationDto();

		for (int i = 1; i <= 3; i++) {
			std.addStudents(new StudentEntity());
		}

		model.addAttribute("form", std);
		return "CreateStudents";
	}

	@GetMapping("/edit")
	public String showEditForm(Model model) {
		List<StudentEntity> stdEntity = new ArrayList<>();
		studentService.findAll().iterator().forEachRemaining(stdEntity::add);

		model.addAttribute("form", new StudentCreationDto(stdEntity));

		return "EditStudents";
	}

	@PostMapping("/save")
	public String saveStudents(@ModelAttribute StudentCreationDto form, Model model) {
		studentService.saveAll(form.getStudents());

		model.addAttribute("students", studentService.findAll());
		return "redirect:/students/showstudents";
	}

}