package com.example.rxjavaapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecyclerview)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager  = new LinearLayoutManager(this);
        rvCustomAdapter = new RVCustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rvCustomAdapter);

//        Observable.just("How are you?").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                txtHi.setText(s);
//            }
//        });

        // TextView Text the Lambda Way
        Observable.just("Hey! What's Up").subscribe(txtHi::setText);
//        Observable.just("Mohammed", "Saleh", "Hareth", "Hammam").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                rvCustomAdapter.addStringToList(s);
//            }
//        });

        Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500), new Date());
        Entry entry2 = new Entry("Xbox One", BigDecimal.valueOf(2000), new Date());
        Entry entry3 = new Entry("Xbox One s", BigDecimal.valueOf(2500), new Date());
        Entry entry4 = new Entry("Xbox One X", BigDecimal.valueOf(3000), new Date());

//        Observable.just(entry1, entry2, entry3, entry4).subscribe(new Consumer<Entry>() {
//            @Override
//            public void accept(Entry entry) throws Throwable {
//                rvCustomAdapter.addEntryToList(entry);
//            }
//        });

        Observable.just(entry1, entry2, entry3, entry4).subscribe(s->rvCustomAdapter.addEntryToList(s));



    }
}