package grant.com.pexelapi.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;

import org.jetbrains.annotations.NotNull;

import grant.com.pexelapi.model.PexelPhotoSearchResponse;
import grant.com.pexelapi.repo.PexelRepo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<PexelPhotoSearchResponse> searchResponse = new MutableLiveData<>();

    public LiveData<PexelPhotoSearchResponse> getSearchResponse() {
        return searchResponse;
    }


    public void getPhotoSearchResponse(String query, int numberQuery){
        if(query.equals("") || query.equals(" ")){
            PexelPhotoSearchResponse noSearch = new PexelPhotoSearchResponse(0,0,0, null, "");
            searchResponse.setValue(noSearch);
        }
        PexelRepo.getInstance().getSearchResponse(query, numberQuery).enqueue(new Callback<PexelPhotoSearchResponse>() {
            @Override
            public void onResponse(@NotNull Call<PexelPhotoSearchResponse> call, @NotNull Response<PexelPhotoSearchResponse> response) {
                searchResponse.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<PexelPhotoSearchResponse> call, @NotNull Throwable t) {
                System.out.println("Call failed");
            }
        });

    }

}
