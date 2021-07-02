package location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
    City getOne(long id);
    City findByName(String name);
    Collection<City> findAll();
}
