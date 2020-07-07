package anup.learnspring.services.map;

import anup.learnspring.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId =1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());
        ownerMapService.save((Owner) Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        Assert.isTrue(1==ownerSet.size(),"Size is same");
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
        Owner owner2 = ownerMapService.save( (Owner)Owner.builder().id(2L).build());
        Assertions.assertNotNull(owner2);
        Assertions.assertEquals(2,owner2.getId());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        Assertions.assertEquals(1,owner.getId());
    }

    @Test
    void findByLastName() {
    }
}
