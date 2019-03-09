package com.rido.kuisq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("datamahasiswa");
        mDatabase.keepSynced(true);

        mList=(RecyclerView)findViewById(R.id.myrecycleview);
        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<mahasiswa,mahasiswaViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<mahasiswa, mahasiswaViewHolder>
                (mahasiswa.class,R.layout.card_row,mahasiswaViewHolder.class,mDatabase){
            @Override
            protected void populateViewHolder(mahasiswaViewHolder viewHolder, mahasiswa model, int position) {
                viewHolder.setNama(model.getNama());
                viewHolder.setJurusan(model.getJurusan());
                viewHolder.setNim(model.getNim());
                viewHolder.setSosmed(model.getSosmed());
            }
        };

        mList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class mahasiswaViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public mahasiswaViewHolder(View itemView){
            super(itemView);
            mView=itemView;
        }

        public void setNama(String nama){
            TextView post_nama=(TextView)mView.findViewById(R.id.nama);
            post_nama.setText(nama);
        }

        public void setJurusan(String jurusan){
            TextView post_jurusan=(TextView)mView.findViewById(R.id.jurusan);
            post_jurusan.setText(jurusan);
        }

        public void setNim(String nim){
            TextView post_nim=(TextView)mView.findViewById(R.id.nim);
            post_nim.setText(nim);
        }

        public void setSosmed(String sosmed){
            TextView post_sosmed=(TextView)mView.findViewById(R.id.sosmed);
            post_sosmed.setText(sosmed);
        }
    }
}
