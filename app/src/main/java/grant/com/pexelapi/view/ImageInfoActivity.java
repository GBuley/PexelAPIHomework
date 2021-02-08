package grant.com.pexelapi.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

import grant.com.pexelapi.databinding.ImageInfoBinding;
import grant.com.pexelapi.utils.Constants;

public class ImageInfoActivity extends AppCompatActivity {

    ImageInfoBinding binding;
    private Bitmap picture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ImageInfoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Glide.with(binding.getRoot()).load(getIntent().getStringExtra(Constants.IMAGE_INFO_URL)).centerCrop().placeholder(binding.image.getDrawable()).into(binding.image);
        binding.imageId.setText("Image id: "+ getIntent().getStringExtra(Constants.IMAGE_INFO_ID));
        binding.imagePhotographerUrl.setText("Photographer URL: "+getIntent().getStringExtra(Constants.IMAGE_INFO_PHOTOGRAPHER_URL));
        binding.imagePhotographer.setText("Photographer: "+ getIntent().getStringExtra(Constants.IMAGE_INFO_PHOTOGRAPHER));
        binding.imageUrl.setText("Image URL"+ getIntent().getStringExtra(Constants.IMAGE_INFO_URL));

        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = () -> {
                    InputStream in = null;
                    try {
                        in = new java.net.URL(getIntent().getStringExtra(Constants.IMAGE_INFO_URL)).openStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    picture = BitmapFactory.decodeStream(in);
                };
                Thread thread = new Thread(runnable);
                thread.start();
                if(picture==null){
                    System.out.println("bitmap no worky");
                }
                else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_STREAM, picture);
                    Intent.createChooser(intent, "Share via");
                    startActivity(intent);
                }
            }
        });
    }
}
