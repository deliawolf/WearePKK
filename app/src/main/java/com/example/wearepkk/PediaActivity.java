package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.wearepkk.adapter.PediaAdapter;
import com.example.wearepkk.model.PediaModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PediaActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("PKKpedia");

    private PediaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedia);

        com.google.android.material.floatingactionbutton.FloatingActionButton add_pedia_btn = findViewById(R.id.button_add_note_pedia);


        add_pedia_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PediaActivity.this,PediaAddActivity.class));
            }
        });
        setUpRecyclerView();
    }
    private void setUpRecyclerView(){
        Query query = notebookRef.orderBy("title", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<PediaModel> options = new FirestoreRecyclerOptions.Builder<PediaModel>()
                .setQuery(query,PediaModel.class)
                .build();


        adapter = new PediaAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_pedia);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
