package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


public class DetailNeighbourActivity extends AppCompatActivity {

    ImageView mAvatarImageView;
    TextView mImageNameTextView;
    TextView mInfoNameTextView;
    TextView mAddressTextView;
    TextView mPhoneTextView;
    TextView mMediaTextView;
    TextView mAboutMeTitleTextView;
    TextView mAboutMeDescriptionTextView;
    ImageButton mPreviousButton;
    FloatingActionButton mFavoriteButton;

    private NeighbourApiService mApiService;
    private Neighbour mCurrentNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        mApiService = DI.getNeighbourApiService();

        mAvatarImageView = findViewById(R.id.detail_avatar);
        mImageNameTextView = findViewById(R.id.detail_image_name);
        mInfoNameTextView = findViewById(R.id.detail_info_name);
        mAddressTextView = findViewById(R.id.detail_info_address);
        mPhoneTextView = findViewById(R.id.detail_info_phone);
        mMediaTextView = findViewById(R.id.detail_info_media);
        mAboutMeTitleTextView = findViewById(R.id.detail_about_title);
        mAboutMeDescriptionTextView = findViewById(R.id.detail_about_text);
        mPreviousButton = findViewById(R.id.detail_previous_button);
        mFavoriteButton = findViewById(R.id.detail_favorite_button);

        mCurrentNeighbour = Neighbour.getExtras(getIntent());
        this.displayDetails(mCurrentNeighbour);

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentNeighbour.getFavorite()){
                    mApiService.unmakeFavorite(mCurrentNeighbour);
                }
                mApiService.makeFavorite(mCurrentNeighbour);
            }
        });
    }

    private void displayDetails(final Neighbour neighbour) {

        mImageNameTextView.setText(neighbour.getName());
        mInfoNameTextView.setText(neighbour.getName());
        mAddressTextView.setText(neighbour.getAddress());
        mPhoneTextView.setText(neighbour.getPhoneNumber());
        mMediaTextView.setText(getString(R.string.media, neighbour.getName()));
        mAboutMeTitleTextView.setText(R.string.about_me);
        mAboutMeDescriptionTextView.setText(neighbour.getAboutMe());
        Glide.with(mAvatarImageView.getContext())
                .load(neighbour.getAvatarUrl())
                .into(mAvatarImageView);
    }
}
