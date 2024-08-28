package com.example.neerajinnostore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.model.CarouselType;
import org.imaginativeworld.whynotimagecarousel.utils.Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.relex.circleindicator.CircleIndicator2;

public class ImageCarouselActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);
        ImageCarousel carousel = findViewById(R.id.carousel);

// Attributes
        carousel.setCarouselPadding(Utils.dpToPx(0, ImageCarouselActivity.this));
        carousel.setCarouselPaddingStart(Utils.dpToPx(0, ImageCarouselActivity.this));
        carousel.setCarouselPaddingTop(Utils.dpToPx(0, ImageCarouselActivity.this));
        carousel.setCarouselPaddingEnd(Utils.dpToPx(0, ImageCarouselActivity.this));
        carousel.setCarouselPaddingBottom(Utils.dpToPx(0, ImageCarouselActivity.this));

        carousel.setShowTopShadow(true);
        carousel.setTopShadowAlpha(0.6f); // 0 to 1, 1 means 100%
        carousel.setTopShadowHeight(Utils.dpToPx(32, ImageCarouselActivity.this)); // px value of dp

        carousel.setShowBottomShadow(true);
        carousel.setBottomShadowAlpha(0.6f); // 0 to 1, 1 means 100%
        carousel.setBottomShadowHeight(Utils.dpToPx(64, ImageCarouselActivity.this)); // px value of dp

        carousel.setShowCaption(true);
        carousel.setCaptionMargin(Utils.dpToPx(0, ImageCarouselActivity.this)); // px value of dp
        carousel.setCaptionTextSize(Utils.spToPx(14, ImageCarouselActivity.this)); // px value of sp

        carousel.setShowIndicator(true);
        carousel.setIndicatorMargin(Utils.dpToPx(0, ImageCarouselActivity.this)); // px value of dp

        carousel.setShowNavigationButtons(true);
        carousel.setImageScaleType(ImageView.ScaleType.CENTER);
        carousel.setCarouselBackground(new ColorDrawable(Color.parseColor("#333333")));
        carousel.setImagePlaceholder(ContextCompat.getDrawable(
                ImageCarouselActivity.this,
                R.drawable.ic_baseline_picture_in_picture_24
        ));

// See kotlin code for details.
       carousel.setPreviousButtonLayout(org.imaginativeworld.whynotimagecarousel.R.layout.previous_button_layout);
      carousel.setPreviousButtonId(org.imaginativeworld.whynotimagecarousel.R.id.btn_next);
        carousel.setPreviousButtonMargin(Utils.dpToPx(4, ImageCarouselActivity.this)); // px value of dp

        carousel.setNextButtonLayout(org.imaginativeworld.whynotimagecarousel.R.layout.next_button_layout);
        carousel.setNextButtonId(org.imaginativeworld.whynotimagecarousel.R.id.btn_next);
        carousel.setNextButtonMargin(Utils.dpToPx(4, ImageCarouselActivity.this)); // px value of dp

        carousel.setCarouselType(CarouselType.SHOWCASE);
        carousel.setScaleOnScroll(true);
        carousel.setScalingFactor(.15f);

// See kotlin code for details.
        carousel.setAutoWidthFixing(true);

// See kotlin code for details.
        carousel.setAutoPlay(false);
        carousel.setAutoPlayDelay(3000); // Milliseconds

// Touch to pause autoPlay.
        carousel.setTouchToPause(true);

// Infinite scroll for the carousel.
        carousel.setInfiniteCarousel(true);

// Scroll listener
        carousel.setOnScrollListener(new CarouselOnScrollListener() {
            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy, int position, @Nullable CarouselItem carouselItem) {
                // ...
            }

            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState, int position, @Nullable CarouselItem carouselItem) {
                // ...
            }
        });

// Carousel listener
        carousel.setCarouselListener(new CarouselListener() {
            @Override
            public void onBindViewHolder(@NonNull ViewBinding viewBinding, @NonNull CarouselItem carouselItem, int i) {

            }

            @Override
            public ViewBinding onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent) {
                // ...
                return null;
            }


            @Override
            public void onLongClick(int position, @NotNull CarouselItem dataObject) {
                // ...
            }

            @Override
            public void onClick(int position, @NotNull CarouselItem carouselItem) {
                // ...
            }
        });

// Goto next slide/item
        carousel.next();

// Goto previous slide/item
        carousel.previous();

// Start auto play
        carousel.start();

// Stop auto play
        carousel.stop();

// See kotlin code for details.
       // CircleIndicator2 indicator = findViewById(R.id.);
      //  carousel.setIndicator(indicator);

// See kotlin code for details.
      //  carousel.registerLifecycle(lifecycle)

// ...

// See kotlin code for details.
       // carousel.setData(list)
    }
}