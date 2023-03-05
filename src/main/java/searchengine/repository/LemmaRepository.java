package searchengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import searchengine.model.Lemma;

import java.util.List;

@Component
public interface LemmaRepository extends CrudRepository<Lemma, Integer> {


    List<Lemma> findAllByLemma(String lemma);

    List<Lemma> findAll();

    List<Lemma> findAllBySiteID(int siteID);

    Lemma findByLemmaAndSiteID(String lemma, int siteID);

}
