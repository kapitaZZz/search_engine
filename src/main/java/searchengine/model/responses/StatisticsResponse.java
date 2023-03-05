package searchengine.model.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Setter
@Getter
public class StatisticsResponse {

    boolean result;
    Statistics statistics;
}
