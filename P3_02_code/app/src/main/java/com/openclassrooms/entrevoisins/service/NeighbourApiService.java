package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Make a neighbour favorite
     * @param neighbour
     */
    void makeFavorite(Neighbour neighbour);

    /**
     * Unmake a neighbour favorite
     * @param neighbour
     */
    void unmakeFavorite(Neighbour neighbour);

    /**
     * Get all my FavoritesNeighbours
     * @return {@link List}
     */
    List<Neighbour> getFavoritesNeighbours();

}
