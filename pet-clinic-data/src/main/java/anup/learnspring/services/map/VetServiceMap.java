package anup.learnspring.services.map;

import anup.learnspring.model.Specialty;
import anup.learnspring.model.Vet;
import anup.learnspring.services.SpecailtyService;
import anup.learnspring.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet , Long> implements VetService {

    private final SpecailtyService specailtyService;

    public VetServiceMap(SpecailtyService specailtyService) {
        this.specailtyService = specailtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId()==null){
                    Specialty savedSpecialty = specailtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
