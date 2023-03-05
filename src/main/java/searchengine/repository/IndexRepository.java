package searchengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import searchengine.model.Index;

import java.util.List;

@Component
public interface IndexRepository extends CrudRepository<Index, Integer> {

    List<Index> findAll();

    boolean existsByPageIdAndLemmaId(int page_id, int lemma_id);

}
