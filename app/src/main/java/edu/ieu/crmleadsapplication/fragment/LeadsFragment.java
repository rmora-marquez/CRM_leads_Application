package edu.ieu.crmleadsapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import edu.ieu.crmleadsapplication.LeadsRepository;
import edu.ieu.crmleadsapplication.R;
import edu.ieu.crmleadsapplication.modelo.Lead;
import edu.ieu.crmleadsapplication.modelo.LeadsAdapter;

public class LeadsFragment extends Fragment {
    private ListView mLeadLists;
    private ArrayAdapter<String> mLeadsAdapter;
    private ArrayAdapter<Lead> leadPojoAdapter;
    public LeadsFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    public static LeadsFragment newInstance(){
        return new LeadsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_leads, container, false);
        mLeadLists = root.findViewById(R.id.leads_list);
        String[] leadsNames = {
                "Alexander Pierrot",
                "Carlos Lopez",
                "Sara Bonz",
                "Liliana Clarence",
                "Benito Peralta",
                "Juan Jaramillo",
                "Christian Steps",
                "Alexa Giraldo",
                "Linda Murillo",
                "Lizeth Astrada"
        };

        mLeadsAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                leadsNames
        );
        //mLeadLists.setAdapter(mLeadsAdapter);
        leadPojoAdapter= new LeadsAdapter(getActivity(),
                LeadsRepository.getInstance().getLeads());
        mLeadLists.setAdapter(leadPojoAdapter);

        mLeadLists.setOnItemClickListener( (adapterView, view, position, l) -> {
            Lead curreLead = leadPojoAdapter.getItem(position);
            Toast.makeText(getActivity(),
                    "Iniciar screen de detalle para: " + curreLead.getName(),
                    Toast.LENGTH_LONG)
            .show();
        });
        return root;
    }
}