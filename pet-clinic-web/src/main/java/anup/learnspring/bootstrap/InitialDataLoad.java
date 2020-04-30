package anup.learnspring.bootstrap;

import anup.learnspring.model.Owner;
import anup.learnspring.model.Vet;
import anup.learnspring.services.OwnerService;
import anup.learnspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public InitialDataLoad(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Owner 1");
        //owner.setId(1L);
        owner.setLastName("Owner LName");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Owner 2");
        //owner2.setId(2L);
        owner2.setLastName("Owner2 LName");

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
