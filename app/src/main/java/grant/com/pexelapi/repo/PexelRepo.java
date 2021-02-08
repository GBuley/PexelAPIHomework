package grant.com.pexelapi.repo;

import grant.com.pexelapi.model.PexelPhotoSearchResponse;
import grant.com.pexelapi.utils.Constants;
import retrofit2.Call;

public class PexelRepo {

    private static PexelRepo INSTANCE = null;

    private PexelRepo(){}


    public Call<PexelPhotoSearchResponse> getSearchResponse(String query, int numberQuery){
        return RetroFitInstance.getInstance().getPhotoSearchResponse(Constants.API_KEY, query, numberQuery);
    }


    public static PexelRepo getInstance(){
        if(INSTANCE==null) INSTANCE = new PexelRepo();
        return INSTANCE;
    }
}
