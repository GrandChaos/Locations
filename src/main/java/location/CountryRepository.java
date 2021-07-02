package location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
    Country getOne(long id);
    Country findByName(String name);
    Collection<Country> findAll();
}
