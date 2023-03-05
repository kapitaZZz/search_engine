package searchengine.controllers;

import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.model.responses.StatisticsResponse;
import searchengine.services.ConfigService;

@RestController
public class StatisticsController {

    private ConfigService configService;
    private StatisticsService statisticsService;
    private Statistics statistics;
    private StatisticsResponse statisticsResponse;

    @Autowired
    public StatisticsController(ConfigService configService, StatisticsService statisticsService, Statistics statistics, StatisticsResponse statisticsResponse) {
        this.configService = configService;
        this.statisticsService = statisticsService;
        this.statistics = statistics;
        this.statisticsResponse = statisticsResponse;
    }

    @GetMapping("/statistics")
    public ResponseEntity<Object> getStatistics(){
        statistics = statisticsService.getStatistics();
        statisticsResponse.setResult(true);
        statisticsResponse.setStatistics(statistics);
        return ResponseEntity.ok (statisticsResponse);
    }
}
