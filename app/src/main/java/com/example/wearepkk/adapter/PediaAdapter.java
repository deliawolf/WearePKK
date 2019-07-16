package com.example.wearepkk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wearepkk.R;
import com.example.wearepkk.model.PediaModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PediaAdapter extends FirestoreRecyclerAdapter<PediaModel, PediaAdapter.PediaHolder> {

    public PediaAdapter(@NonNull FirestoreRecyclerOptions<PediaModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PediaHolder pediaHolder, int i, @NonNull PediaModel pediaModel) {
        pediaHolder.textViewTitle.setText(pediaModel.getTitle());
        pediaHolder.textViewDescription.setText(pediaModel.getDescription());
    }

    @NonNull
    @Override
    public PediaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_pedia_item,parent,false);

        return new PediaHolder(v);
    }

    class PediaHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;

        public PediaHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title_pedia);
            textViewDescription = itemView.findViewById(R.id.text_view_desc_pedia);
        }
    }
}
