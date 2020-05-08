package anup.learnspring.repositories;

import anup.learnspring.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<PetType , Long> {
}
