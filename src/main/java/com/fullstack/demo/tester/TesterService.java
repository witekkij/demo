package com.fullstack.demo.tester;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TesterService {
    private final TesterRepository testerRepository;

    public List<TesterDto> fetchTestersRankedBy(String country, String device) {
        List<TesterRanked> rankedList = List.of();

        if (country != null && device != null) {
            rankedList = testerRepository.fetchTestersRanked(country, device);
        }

        if (country == null && device != null) {
            rankedList = testerRepository.fetchTestersFilteredByDeviceRanked(device);
        }

        if (country != null && device == null) {
            rankedList = testerRepository.fetchTestersFilteredByCountryRanked(country);
        }

        if (country == null && device == null) {
            rankedList = testerRepository.fetchTestersRanked();
        }

        return rankedList
                .stream()
                .map(TesterDto::createFrom)
                .toList();
    }

    public List<String> fetchCountries(){
        return testerRepository.fetchCountries();
    }
}
