package grant.com.pexelapi.model;

import com.squareup.moshi.Json;

public class Photo {
    private long id;
    private int width;
    private int height;
    private String url;
    private String photographer;
    @Json(name="photographer_url")
    private String photographerUrl;
    @Json(name="photographer_id")
    private int photographerId;
    @Json(name="avgColor")
    private String avgColor;
    private MetaPhoto src;


    public Photo(long id, int width, int height, String url, String photographer, String photographerUrl, int photographerId, String avgColor, MetaPhoto src) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
        this.photographer = photographer;
        this.photographerUrl = photographerUrl;
        this.photographerId = photographerId;
        this.avgColor = avgColor;
        this.src = src;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getPhotographerUrl() {
        return photographerUrl;
    }

    public void setPhotographerUrl(String photographerUrl) {
        this.photographerUrl = photographerUrl;
    }

    public int getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(int photographerId) {
        this.photographerId = photographerId;
    }

    public String getAvgColor() {
        return avgColor;
    }

    public void setAvgColor(String avgColor) {
        this.avgColor = avgColor;
    }

    public MetaPhoto getSrc() {
        return src;
    }

    public void setSrc(MetaPhoto src) {
        this.src = src;
    }
}
