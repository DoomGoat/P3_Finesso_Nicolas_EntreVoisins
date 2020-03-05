package com.openclassrooms.entrevoisins.utils;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import org.hamcrest.Matcher;

public class ClickNeighbourViewAction implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Click on neighbour name";
    }

    @Override
    public void perform(UiController uiController, View view) {
        view.performClick();
        // Maybe check for null

    }
}


