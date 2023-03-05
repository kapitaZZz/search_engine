package searchengine.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Result implements Comparable<Result>{

    private String uri;
    private String title;
    private String snippet;
    private float relevance;

    @Override
    public int compareTo(Result o) {
        return (int) (o.getRelevance() * 10 - this.relevance * 10);
    }

    public String toString(){
        return "Uri: " + uri + " Title: " + title + " Snippet: " + snippet + " Relevance: " + relevance + System.lineSeparator();
    }
}
