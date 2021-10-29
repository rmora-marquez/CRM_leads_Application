package edu.ieu.crmleadsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.ieu.crmleadsapplication.fragment.LeadsFragment;

public class LeadsActivity extends AppCompatActivity {
    private LeadsFragment leadsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);
        leadsFragment = (LeadsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.leads_container);
        if(leadsFragment == null){
            leadsFragment = LeadsFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.leads_container, leadsFragment)
                    .commit();
        }


    }

    private AppCompatActivity getActivity() {
        return this;
    }
}