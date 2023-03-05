package searchengine.model.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import searchengine.model.data.Data;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class SearchResponse {

    boolean result;
    long count;
    ArrayList<Data> data;
}
