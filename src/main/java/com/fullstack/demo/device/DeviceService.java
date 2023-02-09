package com.fullstack.demo.device;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public List<DeviceDto> fetchDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(device -> new DeviceDto(device.getDeviceId(), device.getDescription()))
                .toList();
    }
}
