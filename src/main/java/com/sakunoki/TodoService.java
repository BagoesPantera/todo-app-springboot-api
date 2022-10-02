package com.sakunoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repo;

    public List<Todo> findAll(){
        return repo.findAll();
    }

    public Todo findOne(Integer id){
        return repo.findById(id).get();
    }

    public void create(Todo todo){
        repo.save(todo);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
