package com.sakunoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/todo")
    public List<Todo> findAll(){
        return service.findAll();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        try{
            Todo todo = service.findOne(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo")
    public String create(@RequestBody Todo todo) {
        service.create(todo);
        return "Data added successfully";
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> update(@RequestBody Todo todo, @PathVariable Integer id){
        try {
            Todo todoExist = service.findOne(id);
            todoExist.setTitle(todo.getTitle());
            todoExist.setDescription(todo.getDescription());
            service.create(todoExist);

            return new ResponseEntity<>("Data updated successfully",HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            Todo todo = service.findOne(id);
            service.delete(id);
            return new ResponseEntity<>("Data deleted successfully", HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
        }
    }
}
