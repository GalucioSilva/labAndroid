package com.soutosslave.listadepaises.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.soutosslave.listadepaises.Model.Country;
import com.soutosslave.listadepaises.R;
import java.util.List;
public class Adapter extends ArrayAdapter<Country> {
    public Adapter(Context context, List<Country> objects) { super(context, 0, objects); }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvCapital = (TextView) convertView.findViewById(R.id.capital);
        //TextView tvRegion = (TextView) convertView.findViewById(R.id.region);
        //TextView tvSubregion = (TextView) convertView.findViewById(R.id.subregion);
        tvName.setText(country.name);
        tvCapital.setText(country.capital);
        //tvRegion.setText(country.region);
        //tvSubregion.setText(country.subregion);
        return convertView;
    }
}
