package edu.ieu.crmleadsapplication.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.ieu.crmleadsapplication.R;

public class LeadsAdapter extends ArrayAdapter<Lead> {

    public LeadsAdapter(@NonNull Context context,@NonNull List<Lead> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(null == convertView){
            convertView = inflater.inflate(R.layout.list_item_lead,parent,false);
        }
        ImageView avatar = convertView.findViewById(R.id.iv_avatar);
        TextView name = convertView.findViewById(R.id.tv_name);
        TextView title = convertView.findViewById(R.id.tv_title);
        TextView company = convertView.findViewById(R.id.tv_company);

        Lead lead = getItem(position);
        Glide.with(getContext()).load(lead.getImage()).into(avatar);
        name.setText(lead.getName());
        title.setText(lead.getTitle());
        company.setText(lead.getCompany());
        return convertView;
    }
}
