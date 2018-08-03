package ch.beerpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ch.beerpro.helpers.BackgroundImageProvider;
import ch.beerpro.helpers.StringItemCallback;


public class BeerCategoriesRecyclerViewAdapter
        extends ListAdapter<String, BeerCategoriesRecyclerViewAdapter.ViewHolder> {

    private final BeerCategoriesFragment.OnItemSelectedListener listener;

    public BeerCategoriesRecyclerViewAdapter(BeerCategoriesFragment.OnItemSelectedListener listener) {
        super(new StringItemCallback());
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_beer_categories_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(getItem(position), position, listener);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.content)
        TextView content;

        @BindView(R.id.imageView)
        ImageView imageView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }

        void bind(String item, int position, BeerCategoriesFragment.OnItemSelectedListener listener) {
            content.setText(item);
            Context resources = itemView.getContext();
            imageView.setImageDrawable(BackgroundImageProvider.getBackgroundImage(resources, position));
            if (listener != null) {
                itemView.setOnClickListener(v -> listener.onBeerCategorySelected(item));
            }
        }
    }
}
