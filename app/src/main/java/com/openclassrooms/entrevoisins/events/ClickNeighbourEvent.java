package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class ClickNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public ClickNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
