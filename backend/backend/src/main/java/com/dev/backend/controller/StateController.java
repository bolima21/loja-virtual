package com.dev.backend.controller;

import com.dev.backend.entity.State;
import com.dev.backend.service.StateService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateController {
    @Autowired
    private StateService stateService;
    @GetMapping("/")
    public List<State> searchAll(){
        return stateService.searchAll();

    }
    @PostMapping("/")
    public State insert(@RequestBody State state){
        return stateService.insert(state);

    }

    @PutMapping("/")
    public State update(@RequestBody State state){
        return stateService.update(state);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        stateService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
