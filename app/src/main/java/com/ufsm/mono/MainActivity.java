package com.ufsm.mono;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Transference> transferenceArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transferenceArrayList = new ArrayList<>();

        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));

        RecyclerView recyclerView = findViewById(R.id.rc_transferece_history);
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.transaction_item, parent, false);
                return new TransactionViewHoler(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                TransactionViewHoler transactionViewHoler = (TransactionViewHoler) holder;
                //transactionViewHoler.title.setText(transferenceArrayList.get(position).name);
            }

            @Override
            public int getItemCount() {
                return transferenceArrayList.size();
            }
        });
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

    }

    public class TransactionViewHoler extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView subtitle;
        public TextView money;
        public ImageView ivLogo;

        public TransactionViewHoler(@NonNull View itemView) {
            super(itemView);

            title = findViewById(R.id.title);
            subtitle = findViewById(R.id.subtitle);
            money = findViewById(R.id.money);
            ivLogo = findViewById(R.id.ivLogo);
        }
    }

}

