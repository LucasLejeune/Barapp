package com.barapp.LucasLejeune.model;

import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Command {
    @Id
    private Integer id;

    private @Nullable LocalDateTime sent_at;
    private String status;
    @ManyToOne
    @JoinColumn(name = "table_id")
    private ClientTable table_id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getSent_at() {
        return sent_at;
    }
    public void setSent_at(LocalDateTime sent_at) {
        this.sent_at = sent_at;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public ClientTable getTable() {
        return table_id;
    }
    public void setTable(ClientTable table_id) {
        this.table_id = table_id;
    }
}
