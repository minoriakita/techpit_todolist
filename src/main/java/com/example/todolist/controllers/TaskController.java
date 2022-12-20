package com.example.todolist.controllers;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

 import com.example.todolist.models.Task;
 import com.example.todolist.repository.TaskRepository;

@Controller
public class TaskController {

    // TaskクラスのフィールドをFinalにする。
    private final TaskRepository repository;
    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    // public String index(){
    // public String index(@ModelAttribute Task task){
    public String index(@ModelAttribute Task task, Model model){
    // 一覧用データの用意
    model.addAttribute("tas", repository.findAll());
        return "task/index";
    }
    
    @PostMapping("/create")
    // public String create(@RequestParam String name, Model model){
    // public String create(@ModelAttribute Task task){
    // public String create(@Validated @ModelAttribute Task task, BindingResult result) {
    public String create(@Validated @ModelAttribute Task task, BindingResult result, Model model){

        // バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            model.addAttribute("task", repository.findAll());
            return "task/index";
        }

        repository.saveAndFlush(task);
        // return "task/create";
        return "redirect:/";
    }

    // 初期データの投入
    @GetMapping("/delete/{id}")
    public String remove(@PathVariable long id){
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("task", repository.findById(id));
        return "task/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, @Validated @ModelAttribute Task task, BindingResult result){
        if (result.hasErrors()){
            return "task/edit"; 
        }
        repository.save(task);
        return "redirect:/";
    }

    @PostConstruct
    public void dataInit(){
        Task work = new Task();
        work.setTitle("仕事");
        work.setDetail("出社");
        repository.saveAndFlush(work);

        Task trip = new Task();
        trip.setTitle("旅行");
        trip.setDetail("岡山");
        repository.saveAndFlush(trip);
    }

}
