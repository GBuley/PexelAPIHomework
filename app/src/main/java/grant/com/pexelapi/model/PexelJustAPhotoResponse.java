package grant.com.pexelapi.model;

public class PexelJustAPhotoResponse {
    private Photo photo;

    public PexelJustAPhotoResponse(Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
