package searchengine.dto.statistics;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import searchengine.model.enums.Status;

@Component
@Getter
@Setter
public class DetailedStatisticsItem {

    String url;
    String name;
    Status status;
    long statusTime;
    String error;
    long pages;
    long lemmas;

    public DetailedStatisticsItem(String url, String name, Status status, long statusTime, String error, long pages, long lemmas) {
        this.url = url;
        this.name = name;
        this.status = status;
        this.statusTime = statusTime;
        this.error = error;
        this.pages = pages;
        this.lemmas = lemmas;
    }

    public DetailedStatisticsItem() {
    }
}
