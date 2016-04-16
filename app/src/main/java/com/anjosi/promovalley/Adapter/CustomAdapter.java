package com.anjosi.promovalley.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.anjosi.promovalley.R;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class CustomAdapter extends BaseAdapter{

    private Context context;

    String[][] listaDados;

    public CustomAdapter(Context context, String[][] dados){
        this.context = context;
        this.listaDados = dados;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_itens, null);

            holder = new ViewHolder();

            holder.row_01 = (TextView) convertView.findViewById(R.id.row_01);
            holder.row_02 = (TextView) convertView.findViewById(R.id.row_02);
            holder.row_03 = (TextView) convertView.findViewById(R.id.row_03);
            holder.row_04 = (TextView) convertView.findViewById(R.id.row_04);
            holder.row_05 = (TextView) convertView.findViewById(R.id.row_05);
            holder.row_06 = (TextView) convertView.findViewById(R.id.row_06);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.row_01.setText(listaDados[0][position]);
        holder.row_02.setText(listaDados[1][position]);
        holder.row_03.setText(listaDados[2][position]);
        holder.row_04.setText(listaDados[3][position]);
        holder.row_05.setText(listaDados[4][position]);
        holder.row_06.setText(listaDados[5][position]);

        return convertView;
    }

    static class ViewHolder {
        TextView row_01;
        TextView row_02;
        TextView row_03;
        TextView row_04;
        TextView row_05;
        TextView row_06;
    }
}
