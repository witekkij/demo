package com.fullstack.demo.device;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("devices")
@Slf4j
public class DeviceController {

    private DeviceService deviceService;

    @Inject
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public DevicesResponse getDevices() {
        return new DevicesResponse(deviceService.fetchDevices());
    }

    private record DevicesResponse(List<DeviceDto> items) {
    }
}
