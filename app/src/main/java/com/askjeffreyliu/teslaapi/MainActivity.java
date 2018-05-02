package com.askjeffreyliu.teslaapi;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.askjeffreyliu.teslaapi.model.Vehicle;
import com.askjeffreyliu.teslaapi.viewmodel.VehiclesViewModel;
import com.orhanobut.logger.Logger;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private VehiclesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setDataListener();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                viewModel.getVehiclesLiveData();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setDataListener() {
        // Get a new or existing ViewModel from the ViewModelProvider.
        viewModel = ViewModelProviders.of(this).get(VehiclesViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        viewModel.getAllDbVehicles().observe(this, new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(@Nullable final List<Vehicle> vehicles) {
                // Update the cached copy of the words in the adapter.
                Logger.d("db size is " + vehicles.size());
//                for (int i = 0; i < vehicles.size(); i++) {
//                    Logger.d("db"+vehicles.get(i).getVehicle_id() + " " + vehicles.get(i).getDisplay_name());
//                }
            }
        });

        viewModel.getAllNetworkVehicles().observe(this, new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(@Nullable final List<Vehicle> vehicles) {
                // Update the cached copy of the words in the adapter.
                for (int i = 0; i < vehicles.size(); i++) {
                    Logger.d("netowk" + vehicles.get(i).getVehicle_id() + " " + vehicles.get(i).getDisplay_name());
                }
            }
        });
    }
}
