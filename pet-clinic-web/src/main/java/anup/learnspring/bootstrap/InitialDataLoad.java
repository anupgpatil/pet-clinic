package anup.learnspring.bootstrap;

import anup.learnspring.model.Owner;
import anup.learnspring.model.Pet;
import anup.learnspring.model.PetType;
import anup.learnspring.model.Vet;
import anup.learnspring.services.OwnerService;
import anup.learnspring.services.PetTypeService;
import anup.learnspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialDataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public InitialDataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType petSavedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType petSavedCatType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Owner 1");
        //owner.setId(1L);
        owner.setLastName("Owner LName");
        owner.setAddress("Address Lane 1");
        owner.setCity("San Jose");
        owner.setTelephone("911");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(petSavedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner);
        mikesPet.setName("Chota Mike");
        owner.getPets().add(mikesPet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner 2");
        //owner2.setId(2L);
        owner2.setLastName("Owner2 LName");
        owner2.setAddress("Address Lane 2");
        owner2.setCity("San Francisco");
        owner2.setTelephone("912");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(petSavedCatType);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);
        fionasCat.setName("Chota Fiona");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Data for Owners ");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Vet FName");
        vet1.setLastName("Vet1 LName");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Vet2 FName");
        vet2.setLastName("Vet2 LName");

        vetService.save(vet2);

        System.out.println("Loaded Data for Vets ");


    }
}
