package searchengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import searchengine.model.Page;

import java.util.List;

@Component
public interface PageRepository extends CrudRepository<Page, Integer> {

    List<Page> findAll();

    boolean existsByPath(String path);

    Page findByPathEquals(String path);
}
