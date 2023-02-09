package com.fullstack.demo.tester;

import lombok.Builder;

@Builder
public record TesterRanked(
        String firstName,
        String lastName,
        String country,
        int deviceId,
        String deviceDescription,
        Long rank
) {

    public TesterRanked(String firstName, String lastName, String country, Long rank) {
        this(firstName, lastName, country, 0, null, rank);
    }

}
