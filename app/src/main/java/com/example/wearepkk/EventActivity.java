package com.example.wearepkk;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.wearepkk.adapter.EventAdapter;
import com.example.wearepkk.model.EventModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class EventActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("PKKevent");

    private EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        setUpRecyclerView();
    }
    private void setUpRecyclerView(){
        Query query = notebookRef.orderBy("timestamp_urut", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<EventModel> options2 = new FirestoreRecyclerOptions.Builder<EventModel>()
                .setQuery(query, EventModel.class)
                .build();


        adapter = new EventAdapter(options2);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_event);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new EventAdapter.OnItemCLickListener(){
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position){
                EventModel eventModel = documentSnapshot.toObject(EventModel.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();

                String title = adapter.getItem(position).getTitle_Event();
                String desc = adapter.getItem(position).getDescription_event();
                String location = adapter.getItem(position).getLocation();
                String time = adapter.getItem(position).getTimestamp();
                String dress = adapter.getItem(position).getDress_code();

                Intent intent = new Intent(EventActivity.this,EventDetailActivity.class);

                intent.putExtra("title_event", title);
                intent.putExtra("description_event", desc);
                intent.putExtra("id",id);
                intent.putExtra("location",location);
                intent.putExtra("timestamp",time);
                intent.putExtra("dress_code",dress);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
