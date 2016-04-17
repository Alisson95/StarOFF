package com.anjosi.promovalley.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.anjosi.promovalley.AdapterItens.MercadoAdapter;
import com.anjosi.promovalley.R;
import com.anjosi.promovalley.vo.MercadoVO;
import com.anjosi.promovalley.vo.ViewHolder;

import java.util.List;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class CustomAdapter extends BaseAdapter{

    private Context context;
    private List<?> listaDados;

    public CustomAdapter(Context context, List<?> dados){
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

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_itens, null);

            holder = new ViewHolder();

            holder.row_01 = (TextView) convertView.findViewById(R.id.row_01);
            holder.row_02 = (TextView) convertView.findViewById(R.id.row_02);
            holder.row_03 = (TextView) convertView.findViewById(R.id.row_03);
            holder.row_04 = (TextView) convertView.findViewById(R.id.row_04);
            holder.row_05 = (TextView) convertView.findViewById(R.id.row_05);
            holder.row_06 = (TextView) convertView.findViewById(R.id.row_06);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        if (listaDados.getClass().getSimpleName().equals(MercadoVO.class)) {
            MercadoAdapter.CarreMercados(holder, ((MercadoVO)listaDados.get(position)));
        }

        return convertView;
    }
}
