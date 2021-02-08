package grant.com.pexelapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import grant.com.pexelapi.databinding.ItemImageBinding;
import grant.com.pexelapi.model.Photo;
import grant.com.pexelapi.utils.Constants;
import grant.com.pexelapi.view.ImageInfoActivity;
import grant.com.pexelapi.view.MainActivity;
import grant.com.pexelapi.view.MainEntryActivity;

public class PexelPhotoAdapter extends RecyclerView.Adapter<PexelPhotoAdapter.PexelViewHolder> {
    private List<Photo> photos;
    private String photoUrl;
    private String photographerUrl;
    private String photographerName;
    private String id;

    public PexelPhotoAdapter(List<Photo> photos) {
        this.photos = photos;

    }

    @NonNull
    @Override
    public PexelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding imageBinding = ItemImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PexelViewHolder(imageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PexelViewHolder holder, int position) {
        Photo photo = photos.get(position);
        holder.loadUrl(photo);
        holder.loadNames(photo);
        holder.setPhoto(photo);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    static class PexelViewHolder extends RecyclerView.ViewHolder{
        private ItemImageBinding binding;

        public PexelViewHolder(@NonNull ItemImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void createListener(Photo thePhoto){
            binding.imageSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(binding.getRoot().getContext(), ImageInfoActivity.class);
                    intent.putExtra(Constants.IMAGE_INFO_ID, String.valueOf(thePhoto.getId()));
                    intent.putExtra(Constants.IMAGE_INFO_PHOTOGRAPHER, thePhoto.getPhotographer());
                    intent.putExtra(Constants.IMAGE_INFO_PHOTOGRAPHER_URL, thePhoto.getPhotographerUrl());
                    intent.putExtra(Constants.IMAGE_INFO_URL, thePhoto.getSrc().getOriginal());
                    binding.getRoot().getContext().startActivity(intent);
                }
            });
        }

        public void loadUrl(Photo photo){
            Glide.with(binding.getRoot()).load(photo.getSrc().getOriginal()).centerCrop().placeholder(binding.imageSet.getDrawable()).into(binding.imageSet);
            createListener(photo);
        }

        public void loadNames(Photo photo) {
            binding.photographerName.setText("Photographer: "+photo.getPhotographer());
        }

        public void setPhoto(Photo photo) {

        }
    }
}
