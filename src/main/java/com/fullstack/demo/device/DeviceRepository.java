package com.fullstack.demo.device;

import org.springframework.data.repository.ListCrudRepository;

@org.springframework.stereotype.Repository
public interface DeviceRepository extends ListCrudRepository<Device, Long> {}

