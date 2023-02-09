package com.fullstack.demo.tester;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@NoArgsConstructor
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("testers")
@Slf4j
public class TesterController {

    private TesterService testerService;

    @Inject
    public TesterController(TesterService testerService) {
        this.testerService = testerService;
    }

    @GetMapping(value = "/match")
    public MatchTestersResponse getTesters(
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "deviceName", required = false) String deviceName
    ) {
        log.info("Received request GET /testers-match (country={}, device={})", country, deviceName);

        if ("all".equalsIgnoreCase(country)) {
            country = null;
        }
        if ("all".equalsIgnoreCase(deviceName)) {
            deviceName = null;
        }

        var runInformationItems = testerService.fetchTestersRankedBy(country, deviceName);
        return new MatchTestersResponse(runInformationItems);
    }


    @GetMapping(value = "/countries")
    public CountryResponse getCountries(
    ) {
        log.debug("Received request GET /testers-countries");

        var countries = testerService.fetchCountries();
        return new CountryResponse(countries);
    }

    private record MatchTestersResponse(List<TesterDto> items) {
    }

    private record CountryResponse(List<String> items) {
    }
}
