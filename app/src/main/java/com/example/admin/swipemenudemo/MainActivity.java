package com.example.admin.swipemenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemChildClickListener {

    RecyclerView recyclerView;
    QuickAdapter quickAdapter;
    List<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
        recyclerView.addItemDecoration( new DividerItemDecoration( this ,LinearLayoutManager.VERTICAL) );
        quickAdapter=new QuickAdapter( data );
        quickAdapter.setOnItemChildClickListener( this );
        recyclerView.setAdapter( quickAdapter );


        data=new ArrayList<>(  );
        for (int i=0;i<30;i++){
            data.add( String.valueOf( (i+1) ) );
        }
        quickAdapter.setNewData( data );
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()){
            case R.id.tv_delete:
                quickAdapter.remove( position );
                Toast.makeText( this, "size:--"+data.size(), Toast.LENGTH_SHORT ).show();
                Log.d( "Arrays:",Arrays.toString( data.toArray() ) );
                break;
        }
    }
}
