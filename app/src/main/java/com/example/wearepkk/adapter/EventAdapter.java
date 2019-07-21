package com.example.wearepkk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wearepkk.R;
import com.example.wearepkk.model.EventModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.text.SimpleDateFormat;

public class EventAdapter extends FirestoreRecyclerAdapter <EventModel, EventAdapter.EventHolder>{

    public EventAdapter(@NonNull FirestoreRecyclerOptions<EventModel> options2) {
        super(options2);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventHolder eventHolder, int i, @NonNull EventModel eventModel) {
        eventHolder.textViewTitle_event.setText(eventModel.getTitle_Event());
        eventHolder.textViewLocation.setText(eventModel.getLocation());
        eventHolder.date_event.setText(eventModel.getTimestamp());
    }
    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_event_item,parent,false);

        return new EventHolder(v);
    }
    class EventHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle_event;
        TextView textViewLocation;
        TextView date_event;

        public EventHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle_event = itemView.findViewById(R.id.text_view_title_event);
            textViewLocation = itemView.findViewById(R.id.text_view_location_event);
            date_event = itemView.findViewById(R.id.text_view_date_event);
        }
    }
}
