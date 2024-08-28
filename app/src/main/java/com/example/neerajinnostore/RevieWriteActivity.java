package com.example.neerajinnostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RevieWriteActivity extends AppCompatActivity {
TextView pic_camera;
  ImageView Msg;
  ImageView image_gallery;
  TextView msg_text;
    String PassedValue = null;
    ImageView star_rate_img;
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revie_write);
        image_gallery = findViewById(R.id.image_gallery);
        pic_camera = findViewById(R.id.pic_camera);
        pic_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);

                // pass the constant to compare it
                // with the returned requestCode
                startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
            }
        });
        Msg = findViewById(R.id.msg);
        msg_text = findViewById(R.id.msg_text);
        star_rate_img = findViewById(R.id.star_rate_img);
        Intent i = getIntent();
        Float ratingValue = Float.valueOf(i.getStringExtra("rating"));
        if (ratingValue==0.5){
            msg_text.setText("My Product was very Bad");
            Msg.setImageResource(R.drawable.bad);
            star_rate_img.setImageResource(R.drawable.half);

        }else if (ratingValue == 1.0){
            Msg.setImageResource(R.drawable.bad);
            msg_text.setText("My Product was very Bad");
            star_rate_img.setImageResource(R.drawable.one);
        } else if (ratingValue == 1.5) {
            Msg.setImageResource(R.drawable.ok);
            msg_text.setText("My Product was Ok");
            star_rate_img.setImageResource(R.drawable.onehalf);
        } else if (ratingValue == 2.0) {
            Msg.setImageResource(R.drawable.ok);
            msg_text.setText("My Product was Ok");
            star_rate_img.setImageResource(R.drawable.two);

        }else if (ratingValue == 2.5){
            Msg.setImageResource(R.drawable.nice);
            msg_text.setText("My Product was Good");
            star_rate_img.setImageResource(R.drawable.twohalf);
        } else if (ratingValue == 3.0) {
            Msg.setImageResource(R.drawable.nice);
            msg_text.setText("My Product was Good");
            star_rate_img.setImageResource(R.drawable.three);
        } else if (ratingValue == 3.5) {
            Msg.setImageResource(R.drawable.good);
            msg_text.setText("My Product was Nice");
            star_rate_img.setImageResource(R.drawable.threehalf);

        }else if (ratingValue == 4.0){
            Msg.setImageResource(R.drawable.good);
            msg_text.setText("My Product was Nice");
            star_rate_img.setImageResource(R.drawable.four);
        } else if (ratingValue == 4.5) {
            Msg.setImageResource(R.drawable.perfect);
            msg_text.setText("My Product was Perfect");
            star_rate_img.setImageResource(R.drawable.fourhalf);
        } else if (ratingValue == 5.0) {
            Msg.setImageResource(R.drawable.perfect);
            msg_text.setText("My Product was Perfect");
            star_rate_img.setImageResource(R.drawable.five);

        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    image_gallery.setImageURI(selectedImageUri);
                    if (image_gallery != null){
                        image_gallery.setVisibility(View.VISIBLE);
                    }else {
                        image_gallery.setVisibility(View.GONE);
                    }
                }
            }
        }
    }
}