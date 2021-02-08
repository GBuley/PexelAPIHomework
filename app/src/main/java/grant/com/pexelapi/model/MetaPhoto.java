package grant.com.pexelapi.model;

import com.squareup.moshi.Json;

public class MetaPhoto {

    String original;
    String large;
    @Json(name = "large2x")
    String largeTimesTwo;
    String medium;
    String small;
    String portrait;
    String landscape;
    String tiny;

    public MetaPhoto(String original, String large, String largeTimesTwo, String medium, String small, String portrait, String tiny) {
        this.original = original;
        this.large = large;
        this.largeTimesTwo = largeTimesTwo;
        this.medium = medium;
        this.small = small;
        this.portrait = portrait;
        this.tiny = tiny;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getLargeTimesTwo() {
        return largeTimesTwo;
    }

    public void setLargeTimesTwo(String largeTimesTwo) {
        this.largeTimesTwo = largeTimesTwo;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getTiny() {
        return tiny;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }
}
