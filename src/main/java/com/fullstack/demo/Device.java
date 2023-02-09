package com.fullstack.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    private int deviceId;
    private String description;

}
