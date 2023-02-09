package com.fullstack.demo.device;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Device {
    @Id
    private int deviceId;
    private String description;

}
