package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class DepartementServiceImplTest {

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementServiceImpl departementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        // Add some mock departements to the list
        departements.add(new Departement(1, "IT"));
        departements.add(new Departement(2, "Marketing"));

        when(departementRepository.findAll()).thenReturn(departements);

        List<Departement> result = departementService.retrieveAllDepartements();

        assertEquals(2, result.size());
        // You can add more assertions based on your specific use case zezertrtr
    }

    @Test
    public void testAddDepartement() {
        Departement newDepartement = new Departement("Finance");
            // hey rgr
        when(departementRepository.save(newDepartement)).thenReturn(newDepartement);

        Departement result = departementService.addDepartement(newDepartement);

        assertEquals(newDepartement, result);
        // You can add more assertions based on your specific use case
    }

    @Test
    public void testUpdateDepartement() {
        Departement existingDepartement = new Departement(1, "IT");

        when(departementRepository.save(existingDepartement)).thenReturn(existingDepartement);

        Departement result = departementService.updateDepartement(existingDepartement);

        assertEquals(existingDepartement, result);
        // You can add more assertions based on your specific use case
    }

    @Test
    public void testRetrieveDepartement() {
        int departementId = 1;
        Departement existingDepartement = new Departement(departementId, "IT");

        when(departementRepository.findById(departementId)).thenReturn(Optional.of(existingDepartement));

        Departement result = departementService.retrieveDepartement(departementId);

        assertEquals(existingDepartement, result);
        // You can add more assertions based on your specific use case
    }

    @Test
    public void testDeleteDepartement() {
        int departementId = 1;
        Departement existingDepartement = new Departement(departementId, "IT");

        when(departementRepository.findById(departementId)).thenReturn(Optional.of(existingDepartement));

        departementService.deleteDepartement(departementId);

        verify(departementRepository, times(1)).delete(existingDepartement);
        // You can add more assertions based on your specific use case
    }
}

