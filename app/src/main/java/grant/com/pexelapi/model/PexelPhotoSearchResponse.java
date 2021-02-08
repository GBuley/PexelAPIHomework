package grant.com.pexelapi.model;

import com.squareup.moshi.Json;

import java.util.List;

public class PexelPhotoSearchResponse {

    @Json(name="total_results")
    private int totalResults;
    private int page;
    @Json(name="per_page")
    private int perPage;
    private List<Photo> photos;
    @Json(name="next_page")
    private String nextPage;

    public PexelPhotoSearchResponse(int totalResults, int page, int perPage, List<Photo> photos, String nextPage) {
        this.totalResults = totalResults;
        this.page = page;
        this.perPage = perPage;
        this.photos = photos;
        this.nextPage = nextPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }
}
