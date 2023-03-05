package searchengine.dto.statistics;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class StatisticsData {
    private TotalStatistics total;
    private List<DetailedStatisticsItem> detailed;

    @Autowired
    TotalStatistics total;

    @Autowired
    DetailedStatisticsItem[] detailed;

    public StatisticsData(TotalStatistics total, DetailedStatisticsItem[] detailed) {
        this.total = total;
        this.detailed = detailed;
    }

    public StatisticsData() {
    }

    public TotalStatistics getTotal() {
        return total;
    }

    public void setTotal(TotalStatistics total) {
        this.total = total;
    }

    public DetailedStatisticsItem[] getDetailed() {
        return detailed;
    }

    public void setDetailed(DetailedStatisticsItem[] detailed) {
        this.detailed = detailed;
    }

}
