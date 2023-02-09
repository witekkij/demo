package com.fullstack.demo.tester;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "testers")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tester {
    @Id
    private Long testerId;
    private String firstName;
    private String lastName;
    private String country;
    private OffsetDateTime lastLogin;

//    @OneToMany
//    @JoinTable(
//            name="tester_device",
//            joinColumns = @JoinColumn(name="tester_id"),
//            inverseJoinColumns = @JoinColumn(name="device_id")
//    )
//    @Builder.Default
//    private List<Device> devices = new ArrayList<>();

}
