package com.anjosi.promovalley.AdapterItens;

import com.anjosi.promovalley.vo.MercadoVO;
import com.anjosi.promovalley.vo.ViewHolder;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class MercadoAdapter {

    public static void CarreMercados(ViewHolder holder, MercadoVO mercado){
        holder.row_01.setText(mercado.getId());
        holder.row_02.setText(mercado.getName());
        holder.row_03.setText(mercado.getEndereco());
    }
}
