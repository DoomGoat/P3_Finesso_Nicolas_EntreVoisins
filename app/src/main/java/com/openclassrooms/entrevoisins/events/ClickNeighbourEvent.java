package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class ClickNeighbourEvent {

    /**
     * Neighbour clicked
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
