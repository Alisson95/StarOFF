package com.anjosi.promovalley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.anjosi.promovalley.Adapter.CustomAdapter;
import com.anjosi.promovalley.openhelper.DatabaseProvider;
import com.anjosi.promovalley.vo.MercadoVO;

import java.util.List;

public class ListaMercados extends Activity {

    private ListView listaDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_produtos);

        this.listaDados = (ListView) findViewById(R.id.list_produtos);


        ListaMercados();
    }

    private void ListaMercados(){
        List<MercadoVO> listMercado = DatabaseProvider.listMercados();

        CustomAdapter adapter = new CustomAdapter(this, listMercado);

        listaDados.setAdapter(adapter);
    }
}
