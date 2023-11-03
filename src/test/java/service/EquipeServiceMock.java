package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class EquipeServiceMock {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testAddEquipe() {
        Equipe equipeToAdd = new Equipe();
        when(equipeRepository.save(equipeToAdd)).thenReturn(equipeToAdd);

        Equipe addedEquipe = equipeService.addEquipe(equipeToAdd);

        assertEquals(equipeToAdd, addedEquipe);
        verify(equipeRepository, times(1)).save(eq(equipeToAdd));
    }

    @Test
    public void testDeleteEquipe() {
        Integer equipeId = 1;
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(mockEquipe));

        equipeService.deleteEquipe(equipeId);

        verify(equipeRepository, times(1)).delete(eq(mockEquipe));
    }

    @Test
    public void testRetrieveEquipe() {
        Integer equipeId = 1;
        Equipe mockEquipe = new Equipe();
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(mockEquipe));

        Equipe retrievedEquipe = equipeService.retrieveEquipe(equipeId);

        assertEquals(mockEquipe, retrievedEquipe);
    }


}
