package com.fullstack.demo.tester;

import lombok.Builder;

@Builder
public record TesterDto(String firstName, String lastName, String country, Long rank) {

    public static TesterDto createFrom(TesterRanked tester){
        return TesterDto.builder()
                .firstName(tester.firstName())
                .lastName(tester.lastName())
                .country(tester.country())
                .rank(tester.rank())
                .build();
    }

}
