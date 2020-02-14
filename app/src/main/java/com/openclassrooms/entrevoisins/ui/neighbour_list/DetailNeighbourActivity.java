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
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

public class DetailNeighbourActivity extends AppCompatActivity {

    ImageView mAvatarImageView;
    TextView mImageNameTextView;
    TextView mInfoNameTextView;
    ImageButton mPreviousButton;
    FloatingActionButton mFavoriteButton;

    Neighbour mCurrentNeighbour;
    List<Neighbour> mFavoriteNeighbours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);

        mCurrentNeighbour = new Neighbour(69,"Johnny","http://i.pravatar.cc/500", "Pôle-Nord ; 2000km", "+699 69 69 69 69", "Coucou ! :D");

        mAvatarImageView = findViewById(R.id.detail_avatar);
        mImageNameTextView = findViewById(R.id.detail_image_name);
        mInfoNameTextView = findViewById(R.id.detail_info_name);
        mPreviousButton = findViewById(R.id.detail_previous_button);
        mFavoriteButton = findViewById(R.id.detail_favorite_button);

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
                //mFavoriteNeighbours = mFavoriteNeighbours.add(mCurrentNeighbour);
            }
        });

    }

    private void displayDetails(final Neighbour neighbour){

        mImageNameTextView.setText(neighbour.getName());
        mInfoNameTextView.setText(neighbour.getName());
        Glide.with(mAvatarImageView.getContext())
                .load(neighbour.getAvatarUrl())
                .into(mAvatarImageView);
    }


}
