package com.ufsm.mono;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ufsm.mono.model.Transference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Transference> transferenceArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transferenceArrayList = new ArrayList<>();
        addTransferences();

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
                Transference transference = transferenceArrayList.get(position);

                transactionViewHoler.title.setText(transference.getName());
                transactionViewHoler.ivLogo.setImageDrawable(getDrawable(transference.getImageDrawId()));
                transactionViewHoler.money.setText(transference.getValue());
                char signal = transference.getValue().charAt(0);
                if(signal == '-'){
                    transactionViewHoler.money.setTextColor(Color.RED);
                }
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

            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            money = itemView.findViewById(R.id.money);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }

    private void addTransferences(){
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "- $ 200.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 60.50"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "- $ 1850.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "- $ 378.95"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 10.50"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 80.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "- $ 250.00"));
        transferenceArrayList.add(new Transference(R.drawable.transaction_image_example, "Teste", "Teste", "+ $ 3850.00"));
    }

    public void bottomMenuClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.button2MainActivity:
                intent = new Intent(this, AnalyticsActivity.class);
                break;
            case R.id.button3MainActivity:
                intent = new Intent(this, CardActivity.class);
                break;
            case R.id.button4MainActivity:
                intent = new Intent(this, ProfileActivity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
    }

}

