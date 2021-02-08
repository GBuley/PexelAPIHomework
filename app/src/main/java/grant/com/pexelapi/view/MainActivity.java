package grant.com.pexelapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import grant.com.pexelapi.R;
import grant.com.pexelapi.adapter.PexelPhotoAdapter;
import grant.com.pexelapi.databinding.ActivityMainBinding;
import grant.com.pexelapi.databinding.EntryMainBinding;
import grant.com.pexelapi.model.PexelPhotoSearchResponse;
import grant.com.pexelapi.model.Photo;
import grant.com.pexelapi.repo.PexelRepo;
import grant.com.pexelapi.utils.Constants;
import grant.com.pexelapi.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    //TODO: Make search button that calls getPhotoSearchResponse
    //TODO: Observe the change in the data and display it on mainActivity
    //TODO: Create our recycler view

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private int numberOfPhotos;
    private boolean grid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        binding.imageList.setLayoutManager(linearLayout);


        String query = getIntent().getStringExtra(Constants.MAIN_ACTIVITY_QUERY);
        int numberQuery = getIntent().getIntExtra(Constants.MAIN_ACTIVITY_NUMBER, 15);
        viewModel.getPhotoSearchResponse(query, numberQuery);

        binding.layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid = !grid;
                if(grid){
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(binding.getRoot().getContext(), 3);
                    binding.imageList.setLayoutManager(gridLayoutManager);
                }
                else{
                    LinearLayoutManager linearLayout = new LinearLayoutManager(binding.getRoot().getContext());
                    binding.imageList.setLayoutManager(linearLayout);
                }
            }
        });

        viewModel.getSearchResponse().observe(this, new Observer<PexelPhotoSearchResponse>() {
            @Override
            public void onChanged(PexelPhotoSearchResponse pexelPhotoSearchResponse) {
                PexelPhotoAdapter pexelPhotoAdapter = new PexelPhotoAdapter(pexelPhotoSearchResponse.getPhotos());
                binding.imageList.setAdapter(pexelPhotoAdapter);
                numberOfPhotos = pexelPhotoAdapter.getItemCount();
                binding.searchInfoText.setText("We found "+numberOfPhotos+" results for search '"+query+"'");
            }
        });

    }
}