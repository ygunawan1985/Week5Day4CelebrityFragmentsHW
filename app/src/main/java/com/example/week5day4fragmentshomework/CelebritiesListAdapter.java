package com.example.week5day4fragmentshomework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week5day4fragmentshomework.model.celebrity.Celebrity;

import java.util.List;

public class CelebritiesListAdapter extends RecyclerView.Adapter<CelebritiesListAdapter.ViewHolder>{
    private List<Celebrity> celebrities;
    private final CelebrityOnClickHandler mClickHandler;

    public CelebritiesListAdapter(List<Celebrity> celebrities, CelebrityOnClickHandler mClickHandler) {
        this.celebrities = celebrities;
        this.mClickHandler = mClickHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.celebrity_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Celebrity celebrity = celebrities.get(position);

        holder.tvFullName.setText(celebrity.getFirstName() + " " + celebrity.getLastName());

        holder.setCelebrity(celebrity);
    }

    @Override
    public int getItemCount() {
        return celebrities.size();
    }

    //click interface
    public interface CelebrityOnClickHandler {
        void onClick(Celebrity celebrity);
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvFullName;
        Celebrity celebrity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            itemView.setOnClickListener(this);
        }

        public Celebrity getCelebrity() {
            return celebrity;
        }

        public void setCelebrity(Celebrity celebrity) {
            this.celebrity = celebrity;
        }

        @Override
        public void onClick(View view) {
            mClickHandler.onClick(getCelebrity());
        }
    }
}
