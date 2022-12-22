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

 import com.example.todolist.models.Tasks;
import com.example.todolist.repository.TasksRepository;



@Controller
public class TasksController {

    // TaskクラスのフィールドをFinalにする。
    private final TasksRepository repository;
    public TasksController(TasksRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    // public String index(){
    // public String index(@ModelAttribute Task tasks){
    public String index(@ModelAttribute Tasks tasks, Model model){
    // 一覧用データの用意
    model.addAttribute("task", repository.findAll());
        return "tasks/index";
    }
    
    @PostMapping("/create")
    // public String create(@RequestParam String name, Model model){
    // public String create(@ModelAttribute Task tasks){
    // public String create(@Validated @ModelAttribute Task tasks, BindingResult result) {
    public String create(@Validated @ModelAttribute Tasks tasks, BindingResult result, Model model){

        // バリデーションエラーがある場合はindex.htmlを表示
        if (result.hasErrors()) {
            model.addAttribute("task", repository.findAll());
            return "tasks/index";
        }

        repository.saveAndFlush(tasks);
        // return "tasks/create";
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
        model.addAttribute("tasks", repository.findById(id));
        return "tasks/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, @Validated @ModelAttribute Tasks tasks, BindingResult result){
        if (result.hasErrors()){
            return "tasks/edit"; 
        }
        repository.save(tasks);
        return "redirect:/";
    }

    @PostConstruct
    public void dataInit(){
        Tasks work = new Tasks();
        // work.setDate(2022/12/22);
        work.setTitle("work");
        work.setDetail("remote work");
        repository.saveAndFlush(work);

        Tasks trip = new Tasks();
        // trip.setDate(2022/12/22);
        trip.setTitle("trip");
        trip.setDetail("go to tokyo");
        repository.saveAndFlush(trip);
    }

}
