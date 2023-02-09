package com.fullstack.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bugs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bug {
    @Id
    private int bugId;
    private int deviceId;
    private int testerId;

}
