package grant.com.pexelapi.repo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetroFitInstance {

    private static final String BASE_URL = "https://api.pexels.com/";
    private static PexelService INSTANCE = null;

    RetroFitInstance(){}

    public static PexelService getInstance(){
        if(INSTANCE ==null){
            return INSTANCE = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).client(getClient()).build().create(PexelService.class);
        }
        return INSTANCE;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }
}
