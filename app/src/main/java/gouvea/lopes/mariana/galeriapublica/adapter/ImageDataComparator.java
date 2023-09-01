package gouvea.lopes.mariana.galeriapublica.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import gouvea.lopes.mariana.galeriapublica.ImageData;

public class ImageDataComparator extends DiffUtil.ItemCallback<ImageData> {
    @Override
    public boolean areItemsTheSame(@NonNull ImageData oldItem, @NonNull ImageData newItem) {
        return oldItem.uri.equals(newItem.uri);
    }

    @Override
    public  boolean areContentsTheSame(@NonNull ImageData oldItem, @NonNull ImageData newItem) {
        return oldItem.uri.equals(newItem.uri);
    }
}
