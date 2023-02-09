package com.fullstack.demo;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "testers")
public class Tester {
    @Id
    private int testerId;
    private String firstName;
    private String lastName;
    private String country;
    private OffsetDateTime date;

    @OneToMany
    @JoinTable(
            name="tester_device",
            joinColumns = @JoinColumn( name="testerId"),
            inverseJoinColumns = @JoinColumn( name="deviceId")
    )
    private List<Device> devices = new ArrayList<>();

}
