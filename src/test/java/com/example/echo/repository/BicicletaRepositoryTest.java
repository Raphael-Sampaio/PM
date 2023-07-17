package com.example.echo.repository;

import com.example.echo.model.Bicicleta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class BicicletaRepositoryTest {

    private BicicletaRepository repository;

    @BeforeEach
     void setUp() {
        repository = new BicicletaRepository();
    }

    @Test
     void testSalvarBicicleta() {
        Bicicleta bicicleta = new Bicicleta();
        Bicicleta savedBicicleta = repository.salvarBicicleta(bicicleta);
        assertEquals(bicicleta, savedBicicleta);
    }

    @Test
     void testAlterarBicicleta() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        Bicicleta updatedBicicleta = repository.alterarBicicleta(bicicleta, id);
        assertEquals(id, updatedBicicleta.getId());
        assertEquals(bicicleta, updatedBicicleta);
    }

    @Test
     void testDeleteBicicleta() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        repository.salvarBicicleta(bicicleta);
        repository.deleteBicicleta(id);
        assertNull(repository.findById(id));
    }

    @Test
     void testFindById() {
        int id = 1;
        Bicicleta bicicleta = new Bicicleta();
        repository.salvarBicicleta(bicicleta);
        Bicicleta foundBicicleta = repository.findById(id);
        assertNotNull(foundBicicleta);
        assertEquals(id, foundBicicleta.getId());
        assertEquals(bicicleta, foundBicicleta);
    }

    @Test
     void testFindAll() {
        Bicicleta bicicleta1 = new Bicicleta();
        Bicicleta bicicleta2 = new Bicicleta();
        repository.salvarBicicleta(bicicleta1);
        repository.salvarBicicleta(bicicleta2);
        List<Bicicleta> bicicletas = repository.findAll();
        assertEquals(2, bicicletas.size());
        assertTrue(bicicletas.contains(bicicleta1));
        assertTrue(bicicletas.contains(bicicleta2));
    }

}
