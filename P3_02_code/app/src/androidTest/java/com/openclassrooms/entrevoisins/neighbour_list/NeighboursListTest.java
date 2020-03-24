
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.contrib.ViewPagerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.ClickNeighbourViewAction;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private int positionTest = 1;
    private NeighbourApiService service = DI.getNewInstanceApiService();


    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(allOf (withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionTest, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf (withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * When we click an item, the detailActivity is launch
     */
    @Test
    public void myNeighboursList_onNeighbourClick_shouldOpenDetailActivity() {
        // Given : We click on the element at position 2
        // When perform a click on a neighbour
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionTest, new ClickNeighbourViewAction()));
        // Then : the view went to DetailActivity
        onView(withId(R.id.detail_neighbour)).check(matches(isDisplayed()));
    }

    /**
     * When the detailActivity is launch, the item detail name is shown
     */
    @Test
    public void myNeighboursList_onNeighbourDetailOpen_shouldDisplayNeighbourName() {
        // When perform a click on a neighbour
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionTest, new ClickNeighbourViewAction()));
        String neighbourName = service.getNeighbours().get(positionTest).getName();
        // Then : the name field is the name of the neighbour
        onView(withId(R.id.detail_image_name)).check(matches(withText(neighbourName)));
    }

    /**
     * When we look in the favorite Tab, only favorite items are shown
     */
    @Test
    public void myNeighboursList_favoriteList_shouldOnlyDisplayFavoritesNeighbours() {
        // When perform scroll on favorite Tab
        onView(withId(R.id.container)).perform(ViewPagerActions.scrollRight());

        // Then : the only neighbour in the list is the favorite
        onView(allOf (withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(service.getFavoritesNeighbours().size()));
    }

    /**
     * When we click on the favorite button of an item, the item is shown in the favorite Tab
     * When we click again on the favorite button, the item is no more shown in the favorite Tab

    @Test
    public void myNeighboursList_detailNeighbourButton_shouldChangeIconAndSwitchFavoriteState() {
        int actualFavListSize = service.getFavoritesNeighbours().size();
        // Perform a click on a neighbour
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(positionTest, new ClickNeighbourViewAction()));
        // Perform a click on favorite button
        onView(withId(R.id.detail_favorite_button)).perform(click());
        // Perform a click on the back button and scroll to the favorite list
        onView(withId(R.id.detail_previous_button)).perform(click());
        onView(withId(R.id.container)).perform(ViewPagerActions.scrollRight());
        // Then : the only neighbour in the list is the favorite
        onView(allOf (withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(actualFavListSize+1));
        // Perform a click on the neighbour and click on the favorite button again
        onView(allOf (withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new ClickNeighbourViewAction()));
        onView(withId(R.id.detail_favorite_button)).perform(click());
        // Perform a click on back button again
        onView(withId(R.id.detail_previous_button)).perform(click());
        // Then : The list should be empty
        onView(allOf (withId(R.id.list_neighbours), isDisplayed())).check(withItemCount(actualFavListSize));
    }*/
}