package tn.esprit.spring.kaddem.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class EquipeServiceImplMock {

    @Mock
    EquipeRepository equipeRepository;

    @InjectMocks
    EquipeServiceImpl equipeService;

    Equipe equipe1 = new Equipe(1, "Equipe1", Niveau.JUNIOR, null, null);

    List<Equipe> equipes = Arrays.asList(
            equipe1,
            new Equipe(2, "Equipe2", Niveau.SENIOR, null, null),
            new Equipe(3, "Equipe3", Niveau.EXPERT, null, null)
    );

    @Test
    void testRetrieveAllEquipes() {
        Mockito.when(equipeRepository.findAll()).thenReturn(equipes);
        List<Equipe> result = equipeService.retrieveAllEquipes();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void testAddEquipe() {
        Mockito.when(equipeRepository.save(equipe1)).thenReturn(equipe1);
        Equipe savedEquipe = equipeService.addEquipe(equipe1);
        Assertions.assertEquals("Equipe1", savedEquipe.getNomEquipe());
    }

    @Test
    void testDeleteEquipe() {
        Mockito.when(equipeRepository.findById(1)).thenReturn(Optional.of(equipe1));
        equipeService.deleteEquipe(1);
        Mockito.verify(equipeRepository, Mockito.times(1)).delete(equipe1);
    }

    @Test
    void testRetrieveEquipe() {
        Mockito.when(equipeRepository.findById(1)).thenReturn(Optional.of(equipe1));
        Equipe result = equipeService.retrieveEquipe(1);
        Assertions.assertEquals("Equipe1", result.getNomEquipe());
    }

    @Test
    void testUpdateEquipe() {
        Mockito.when(equipeRepository.save(equipe1)).thenReturn(equipe1);
        Equipe updatedEquipe = equipeService.updateEquipe(equipe1);
        Assertions.assertEquals("Equipe1", updatedEquipe.getNomEquipe());
    }


}
