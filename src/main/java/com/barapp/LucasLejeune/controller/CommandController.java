package com.barapp.LucasLejeune.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barapp.LucasLejeune.model.Command;
import com.barapp.LucasLejeune.service.CommandService;

@RestController
@RequestMapping("/commands")
public class CommandController {
    @Autowired
    private CommandService commandService;
    
    @PostMapping("/{cardId}")
    public ResponseEntity<Command> createCommand(@RequestBody CommandRequest commandRequest) {
        Command createdCommand = commandService.createCommand(commandRequest.getTableId(), commandRequest.getSentAt(), commandRequest.getStatus());
        return new ResponseEntity<>(createdCommand, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Command> getCommand(@PathVariable int id) {
        Command command = commandService.getCommand(id);
        if (command == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(command, HttpStatus.OK);
    }

    @GetMapping
    public List<Command> getAllCommands(){
        return commandService.getCommands();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Command> updateCommand(@PathVariable Integer id, @RequestBody Command command) {
        Command existingCommand = commandService.getCommand(id);
        if (existingCommand == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Command updatedCommand = commandService.updateCommand(command);
        return new ResponseEntity<>(updatedCommand, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Command> patchCocktail(@PathVariable int id, @RequestBody Command patch) {
        Command command = commandService.getCommand(id);

        if (patch.getSent_at() != null) {
            command.setSent_at(null);
        }
        if (patch.getStatus() != null) {
            command.setStatus(patch.getStatus());
        }
        if (patch.getTable() != null) {
            command.setTable(patch.getTable());
        }

        Command updatedCommand = commandService.updateCommand(command);
        return ResponseEntity.ok(updatedCommand);
    }
    
}

class CommandRequest {
    private int tableId;
    private LocalDateTime sentAt;
    private String status;
    public int getTableId() {
        return tableId;
    }
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
    public LocalDateTime getSentAt() {
        return sentAt;
    }
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
