package grant.com.pexelapi.repo;

import grant.com.pexelapi.model.PexelJustAPhotoResponse;
import grant.com.pexelapi.model.PexelPhotoSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PexelService {

    @GET("v1/search")
    Call<PexelPhotoSearchResponse> getPhotoSearchResponse(@Header("Authorization") String apiKey, @Query("query") String query, @Query("per_page") int numberQuery);


}
