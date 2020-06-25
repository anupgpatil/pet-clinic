package anup.learnspring.services;

import anup.learnspring.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

    void findByANup(String name);

}
