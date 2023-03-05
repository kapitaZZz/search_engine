package searchengine.model.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Data implements Comparable<Data>{
    String site;
    String siteName;
    String uri;
    String title;
    String snippet;
    double relevance;

    @Override
    public int compareTo(Data o) {
        return (int) (o.getRelevance() * 10 - this.relevance * 10);
    }
}
