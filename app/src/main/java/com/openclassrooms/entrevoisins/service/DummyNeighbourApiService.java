package com.openclassrooms.entrevoisins.service;



import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void makeFavorite(Neighbour neighbour) {
        neighbour.setFavorite(true);
        neighbours.set((int)neighbour.getId()-1, neighbour);
    }

    @Override
    public void unmakeFavorite(Neighbour neighbour) {
        neighbour.setFavorite(false);
        neighbours.set((int)neighbour.getId()-1, neighbour);
    }

    @Override
    public List<Neighbour> getFavoritesNeighbours() {
        List<Neighbour> favoritesNeighbours = new ArrayList<>();
        for (int i=0; i<neighbours.size();i++){
            if (neighbours.get(i).getFavorite()){
                favoritesNeighbours.add(neighbours.get(i));
            }
        }
        return favoritesNeighbours;
    }
}
