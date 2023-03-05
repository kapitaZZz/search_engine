package searchengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import searchengine.model.Field;

import java.util.List;

@Component
public interface FieldRepository extends CrudRepository<Field, Integer> {

    List<Field> findAll();
}
