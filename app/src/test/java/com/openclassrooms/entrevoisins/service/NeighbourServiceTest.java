package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void createNeighbourWithSuccess() {
        Neighbour neighbourToCreate = new Neighbour(System.currentTimeMillis(),"","","","","",false);
        service.createNeighbour(neighbourToCreate);
        assertTrue(service.getNeighbours().contains(neighbourToCreate));
    }

    @Test
    public void makeNeighbourFavoriteWithSuccess() {
        Neighbour neighbourToFavorite = service.getNeighbours().get(0);
        service.makeFavorite(neighbourToFavorite);
        assertTrue(service.getNeighbours().get(0).getFavorite());
    }

    @Test
    public void unmakeNeighbourFavoriteWithSuccess() {
        Neighbour neighbourToUnFavorite = service.getNeighbours().get(0);
        neighbourToUnFavorite.setFavorite(true);
        service.unmakeFavorite(neighbourToUnFavorite);
        assertFalse(service.getNeighbours().get(0).getFavorite());
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        List<Neighbour> favoriteNeighbours = service.getNeighbours();
        for (int i = 0; i < favoriteNeighbours.size(); i++) {
            favoriteNeighbours.get(i).setFavorite(true);
        }
        List<Neighbour> expectedFavoriteNeighbours = DummyNeighbourGenerator.DUMMY_FAVORITE_NEIGHBOURS;
        assertThat(favoriteNeighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedFavoriteNeighbours.toArray()));
    }
}
