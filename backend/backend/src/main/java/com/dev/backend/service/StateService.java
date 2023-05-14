package com.dev.backend.service;

import com.dev.backend.entity.State;
import com.dev.backend.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<State> searchAll(){
        return stateRepository.findAll();

    }

    public State insert(State state) {
        state.setCreationDate(new Date());
        State newState = stateRepository.saveAndFlush(state);
        return newState;
    }
    public State update(State state) {
        state.setCreationDate(new Date());
        return stateRepository.saveAndFlush(state);
    }
    public void exclude(Long id) {
        State state = stateRepository.findById(id).get();
        stateRepository.delete(state);
    }
}
