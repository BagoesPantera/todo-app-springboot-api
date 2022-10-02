package com.sakunoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/todo")
    public List<Todo> findAll(){
        return service.findAll();
    }

    @GetMapping("/todo/{id}")
    public Todo findOne(@PathVariable Integer id){
        return service.findOne(id);
    }

}
