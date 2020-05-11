package anup.learnspring.bootstrap;

import anup.learnspring.model.*;
import anup.learnspring.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialDataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specailtyService;
    private final VisitService visitService;

    public InitialDataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specailtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specailtyService = specailtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count  = petTypeService.findAll().size();
        if (count==0) {
            loadData();
        }
    }

    private void loadData() {
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

        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Not Well");
        visit2.setPet(mikesPet);
        visitService.save(visit2);


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

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Not Well");
        visit1.setPet(fionasCat);
        visitService.save(visit1);

        System.out.println("Loaded Data for Owners ");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedSpecialty  = specailtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSpecialty2  = specailtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedSpecialty3  = specailtyService.save(dentistry);


        Vet vet1 = new Vet();
        vet1.setFirstName("Vet FName");
        vet1.setLastName("Vet1 LName");
        vet1.getSpecialties().add(savedSpecialty);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2 FName");
        vet2.setLastName("Vet2 LName");
        vet2.getSpecialties().add(savedSpecialty2);

        vetService.save(vet2);

        System.out.println("Loaded Data for Vets ");
    }
}
