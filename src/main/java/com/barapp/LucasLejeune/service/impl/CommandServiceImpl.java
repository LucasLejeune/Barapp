package com.barapp.LucasLejeune.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.ClientTable;
import com.barapp.LucasLejeune.model.Command;
import com.barapp.LucasLejeune.repository.CommandRepository;
import com.barapp.LucasLejeune.repository.TableRepository;
import com.barapp.LucasLejeune.service.CommandService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommandServiceImpl implements CommandService {
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private TableRepository tableRepository;


    @Override
    public Command createCommand(int table_id, LocalDateTime sentAt, String status) {
        ClientTable table = tableRepository.findById(table_id).orElseThrow(() -> new EntityNotFoundException("Table not found"));
        Command command = new Command();
        command.setId(0);
        command.setTable(table);
        command.setSent_at(sentAt);
        command.setStatus(status);
        return commandRepository.save(command);
    }


    @Override
    public Command getCommand(int id) {
        return commandRepository.findById(id).orElse(null);
    }


    @Override
    public Command updateCommand(Command command) {
        return commandRepository.save(command);
    }


    @Override
    public List<Command> getCommands() {
        return commandRepository.findAll();
    }

    
}
