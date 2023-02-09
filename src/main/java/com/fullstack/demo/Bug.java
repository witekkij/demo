package com.fullstack.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bugs")
public class Bug {
    @Id
    private int bugId;
    private int deviceId;
    private int testerId;

}
