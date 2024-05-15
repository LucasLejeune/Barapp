package com.barapp.LucasLejeune.service;

import java.time.LocalDateTime;
import java.util.List;

import com.barapp.LucasLejeune.model.Command;

public interface CommandService {
    Command createCommand(int table_id, LocalDateTime sentAt, String status);
    Command getCommand(int id);
    Command updateCommand(Command command);
    List<Command> getCommands();
}
