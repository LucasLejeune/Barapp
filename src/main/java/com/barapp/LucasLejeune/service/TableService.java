package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.ClientTable;

public interface TableService {
    ClientTable createTable(int card_id, String name);
    ClientTable getTable(int id);
    ClientTable updateTable(ClientTable table);
    List<ClientTable> getTables();
}
