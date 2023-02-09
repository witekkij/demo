package com.fullstack.demo.tester;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TesterRepository extends ListCrudRepository<Tester, Long> {

    @Query("""
            select new com.fullstack.demo.tester.TesterRanked(ts.firstName, ts.lastName, ts.country, d.deviceId, d.description, count(*))
                            from Bug bg
                            left join Tester ts on bg.testerId = ts.testerId
                            left join Device d on bg.deviceId = d.deviceId
                            where ts.country = ?1
                            and d.description = ?2
                            group by ts.firstName, ts.lastName, ts.country, d.deviceId, d.description
                            HAVING COUNT(*) > 1
                            order by 6 desc
               """)
    List<TesterRanked> fetchTestersRanked(@Param("country") String country, @Param("device") String device);

    @Query("""
            select new com.fullstack.demo.tester.TesterRanked(ts.firstName, ts.lastName, ts.country, count(*))
                            from Bug bg
                            left join Tester ts on bg.testerId = ts.testerId
                            left join Device d on bg.deviceId = d.deviceId
                            where ts.country = ?1
                            group by ts.firstName, ts.lastName, ts.country
                            HAVING COUNT(*) > 1
                            order by 4 desc
               """)
    List<TesterRanked> fetchTestersFilteredByCountryRanked(@Param("country") String country);

    @Query("""
            select new com.fullstack.demo.tester.TesterRanked(ts.firstName, ts.lastName, ts.country, d.deviceId, d.description, count(*))
                            from Bug bg
                            left join Tester ts on bg.testerId = ts.testerId
                            left join Device d on bg.deviceId = d.deviceId
                            where d.description = ?1
                            group by ts.firstName, ts.lastName, ts.country, d.deviceId, d.description
                            HAVING COUNT(*) > 1
                            order by 6 desc
               """)
    List<TesterRanked> fetchTestersFilteredByDeviceRanked(@Param("device") String device);

    @Query("""
            select new com.fullstack.demo.tester.TesterRanked(ts.firstName, ts.lastName, ts.country, d.deviceId, d.description, count(*))
                            from Bug bg
                            left join Tester ts on bg.testerId = ts.testerId
                            left join Device d on bg.deviceId = d.deviceId
                            group by ts.firstName, ts.lastName, ts.country, d.deviceId, d.description
                            HAVING COUNT(*) > 1
                            order by 6 desc
               """)
    List<TesterRanked> fetchTestersRanked();

    @Query("select distinct t.country from Tester t")
    List<String> fetchCountries();

}
