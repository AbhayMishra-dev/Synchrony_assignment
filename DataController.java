package com.example.controller;

import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/{id}")
    public String getData(@PathVariable Long id) {
        return dataService.getDataFromDatabase(id);
    }

    @PostMapping("/{id}")
    public void updateData(@PathVariable Long id, @RequestBody String newData) {
        dataService.updateData(id, newData);
    }
}
