package com.anjosi.promovalley.openhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.anjosi.promovalley.vo.ItemProductVO;
import com.anjosi.promovalley.vo.MercadoVO;
import com.anjosi.promovalley.vo.ProductVO;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class DatabaseProvider {

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DatabaseProvider(Context context){

        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    private int insertProdutos(ProductVO vo){
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COLUMN_NAME_COMP, vo.getName());
        long id = db.insert(DataBaseHelper.TABLE_COMP, null, cv);
        return  Integer.parseInt(String.valueOf(id));
    }

    private int insertItens(ItemProductVO item){
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COLUMN_LOCA_IT, item.getLocation());
        cv.put(DataBaseHelper.COLUMN_PRIC_IT, item.getPrice());
        cv.put(DataBaseHelper.COLUMN_FK_MER, item.getMercado().getId());
        cv.put(DataBaseHelper.COLUMN_FK_PROD, item.getProduto().getId());

        long id = db.insert(DataBaseHelper.TABLE_COMP, null, cv);

        return  Integer.parseInt(String.valueOf(id));
    }

    private int insertMercado(MercadoVO vo){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_NAME_MERC, vo.getName());
        cv.put(DataBaseHelper.COLUMN_ENDE_MERC, vo.getEndereco());
        long id = db.insert(DataBaseHelper.TABLE_MERCADO, null, cv);
        return  Integer.parseInt(String.valueOf(id));
    }

/*
    class insertion extends AsyncTask<Object, Object, Object>{

        @Override
        protected Object doInBackground(Object... params) {
            int id = 0;

            ProductVO produto = new ProductVO();
            produto.setName("ARROZ");
            insertProdutos(produto);
            produto.setName("ACUCAR");
            insertProdutos(produto);
            produto.setName("CAFÉ MOÍDO");
            insertProdutos(produto);
            produto.setName("FARINHA DE MANDIOCA");
            insertProdutos(produto);
            produto.setName("FARINHA DE TRIGO");
            insertProdutos(produto);
            produto.setName("FEIJÃO CARIOCA TIPO");
            insertProdutos(produto);
            produto.setName("FUBÁ");
            insertProdutos(produto);
            produto.setName("MACARRÃO ESPAGUETE");
            insertProdutos(produto);
            produto.setName("ÓLEO DE SOJA");
            insertProdutos(produto);
            produto.setName("SAL");
            insertProdutos(produto);
            produto.setName("SARDINHA EM ÓLEO");
            insertProdutos(produto);


            ListItensProdutos pro = new ListItensProdutos();

            ItemProductVO productVO = new ItemProductVO();

            MercadoVO mercado = new MercadoVO();
            mercado.setName("Mercado Preco BOM");
            mercado.setEndereco("Rua Tenente Camargo, 1370");

            id = insertMercado(mercado);
            mercado.setId(id);

            productVO.setMercado(mercado);



            mercado.setName("Mercado CompreAqui");
            mercado.setEndereco("Rua Buenos Aires, 66");

            productVO.setMercado(mercado);




//            insert();
            return null;
        }
    }
            */
}
