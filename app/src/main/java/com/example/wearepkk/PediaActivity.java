package com.example.wearepkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wearepkk.adapter.PediaAdapter;
import com.example.wearepkk.model.PediaModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

public class PediaActivity extends AppCompatActivity{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("PKKpedia");
    private PediaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedia);
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


        adapter.setOnItemClickListener(new PediaAdapter.OnItemCLickListener() {
            @Override
            public void OnItemClick(DocumentSnapshot documentSnapshot, int position) {
                PediaModel pediaModel = documentSnapshot.toObject(PediaModel.class);
                String id = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();

                String title = adapter.getItem(position).getTitle();
                String desc = adapter.getItem(position).getDescription();

                Intent intent = new Intent(PediaActivity.this,PediaDetailActivity.class);

                intent.putExtra("title", title);
                intent.putExtra("description", desc);
                intent.putExtra("id",id);
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

