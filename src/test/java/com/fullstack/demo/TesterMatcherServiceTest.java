package com.fullstack.demo;

import com.fullstack.demo.tester.TesterDto;
import com.fullstack.demo.tester.TesterService;
import com.fullstack.demo.tester.TesterRanked;
import com.fullstack.demo.tester.TesterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TesterMatcherServiceTest {

    @Mock
    private TesterRepository testerRepository;
    @InjectMocks
    private TesterService testerService;

    @Test
    void shouldReturnListOfUsersForGivenCountryAndDeviceSortedByExperience() {
        TesterRanked testerOne = TesterRanked.builder().country("PL").firstName("OneName").deviceDescription("Iphone1").rank(22L).build();
        TesterRanked testerTwo = TesterRanked.builder().country("PL").firstName("TwoName").deviceDescription("Iphone1").rank(122L).build();
        TesterRanked otherTester = TesterRanked.builder().country("PL").firstName("OtherName").deviceDescription("Iphone1").rank(222L).build();
        TesterRanked someOtherTester = TesterRanked.builder().country("PL").firstName("SomeOtherName").deviceDescription("Iphone1").rank(322L).build();

        given(testerRepository.fetchTestersRanked("PL", "Iphone1")).willReturn(List.of(testerOne, testerTwo, otherTester, someOtherTester));

        List<TesterDto> result = testerService.fetchTestersRankedBy("PL", "Iphone1");

        Assertions.assertEquals(result, List.of(
                TesterDto.builder().firstName("OneName").country("PL").rank(22L).build(),
                TesterDto.builder().firstName("TwoName").country("PL").rank(122L).build(),
                TesterDto.builder().firstName("OtherName").country("PL").rank(222L).build(),
                TesterDto.builder().firstName("SomeOtherName").country("PL").rank(322L).build()
        ));
    }
}