package location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long>{
    Region getOne(long id);
    Region findByName(String name);
    Collection<Region> findAll();
}