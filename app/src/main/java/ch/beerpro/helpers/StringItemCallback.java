package ch.beerpro.helpers;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class StringItemCallback extends DiffUtil.ItemCallback<String> {
    @Override
    public boolean areItemsTheSame(@NonNull String oldE, @NonNull String newE) {
        return oldE.equals(newE);
    }

    @Override
    public boolean areContentsTheSame(@NonNull String oldE, @NonNull String newE) {
        return oldE.equals(newE);
    }
}
