package com.example.wearepkk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wearepkk.R;
import com.example.wearepkk.model.EventModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class EventAdapter extends FirestoreRecyclerAdapter <EventModel, EventAdapter.EventHolder>{

    private EventAdapter.OnItemCLickListener listener;

    public EventAdapter(@NonNull FirestoreRecyclerOptions<EventModel> options2) {
        super(options2);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventHolder eventHolder, int i, @NonNull EventModel eventModel) {
        eventHolder.textViewTitle_event.setText(eventModel.getTitle_Event());
        eventHolder.textViewLocation.setText(eventModel.getLocation());
        eventHolder.date_event.setText(eventModel.getTimestamp());
        eventHolder.textViewdescription_event.setText(eventModel.getDescription_event());
        eventHolder.dress_code.setText(eventModel.getDress_code());
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
        TextView textViewdescription_event;
        TextView dress_code;

        public EventHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle_event = itemView.findViewById(R.id.text_view_title_event);
            textViewLocation = itemView.findViewById(R.id.text_view_location_event);
            date_event = itemView.findViewById(R.id.text_view_date_event);
            textViewdescription_event = itemView.findViewById(R.id.text_view_description_event);
            dress_code = itemView.findViewById(R.id.text_view_dress_event);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.OnItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }
    public interface OnItemCLickListener {
        void OnItemClick(DocumentSnapshot documentSnapshot, int position);
    }
    public void setOnItemClickListener(EventAdapter.OnItemCLickListener listener){
        this.listener = listener;
    }
}
