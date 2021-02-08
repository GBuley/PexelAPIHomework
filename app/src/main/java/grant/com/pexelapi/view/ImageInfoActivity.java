package grant.com.pexelapi.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.concurrent.Executor;

import grant.com.pexelapi.databinding.ImageInfoBinding;
import grant.com.pexelapi.utils.Constants;

public class ImageInfoActivity extends AppCompatActivity {

    ImageInfoBinding binding;
    private Bitmap picture;
    FileInputStream fileInputStream = null;

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
                    OutputStream out = null;
                    try {
                        in = new java.net.URL(getIntent().getStringExtra(Constants.IMAGE_INFO_URL)).openStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String path = Environment.getExternalStorageDirectory().toString();
                    File myDir = new File(path +"/savedImages");
                    myDir.mkdirs();
                    String fileName = "picture"+System.currentTimeMillis()+".jpg";
                    File file = new File(myDir, fileName);
                    try {
                        picture = BitmapFactory.decodeStream(in);
                        out = new FileOutputStream(file);
                        picture.compress(Bitmap.CompressFormat.JPEG, 100, out);
                        out.flush();
                        out.close();
                        file.setReadable(true,false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(picture==null){
                        System.out.println("bitmap no worky");
                    }
                    else {
                        Uri photoFile = FileProvider.getUriForFile(binding.getRoot().getContext(), binding.getRoot().getContext().getPackageName()+".provider", file);
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_STREAM, photoFile);
                        intent.setType("image/jpeg");
                        Intent.createChooser(intent, "Share via");
                        startActivity(intent);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();

            }
        });
    }
}
