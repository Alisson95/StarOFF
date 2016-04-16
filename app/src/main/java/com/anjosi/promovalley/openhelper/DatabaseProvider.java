package com.anjosi.promovalley.openhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.anjosi.promovalley.vo.ItemProductVO;
import com.anjosi.promovalley.vo.MercadoVO;
import com.anjosi.promovalley.vo.ProductVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class DatabaseProvider {

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DatabaseProvider(Context context){

        helper = new DataBaseHelper(context);

        if(listProd().size() == 0){
            AutoInserProdutos();
        }

        if(listMercados().size() == 0){
            AutoInserMercados();
        }

    }

    public int insertProdutos(ProductVO vo){
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COLUMN_NAME_COMP, vo.getName());

        db = helper.getWritableDatabase();

        long id = db.insert(DataBaseHelper.TABLE_COMP, null, cv);

        db.close();

        return  Integer.parseInt(String.valueOf(id));
    }

    public int insertItens(ItemProductVO item){
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COLUMN_LOCA_IT, item.getLocation());
        cv.put(DataBaseHelper.COLUMN_PRIC_IT, item.getPrice());
        cv.put(DataBaseHelper.COLUMN_FK_MER, item.getMercado().getId());
        cv.put(DataBaseHelper.COLUMN_FK_PROD, item.getProduto().getId());

        db = helper.getWritableDatabase();

        long id = db.insert(DataBaseHelper.TABLE_COMP, null, cv);

        db.close();

        return  Integer.parseInt(String.valueOf(id));
    }

    public int insertMercado(MercadoVO vo){
        ContentValues cv = new ContentValues();
        cv.put(DataBaseHelper.COLUMN_NAME_MERC, vo.getName());
        cv.put(DataBaseHelper.COLUMN_ENDE_MERC, vo.getEndereco());

        db = helper.getWritableDatabase();

        long id = db.insert(DataBaseHelper.TABLE_MERCADO, null, cv);

        db.close();

        return  Integer.parseInt(String.valueOf(id));
    }

    public List<ItemProductVO> listItens(){
        return  listItens(0, 0, true);
    }

    public List<ItemProductVO> listItens(int codigoPro, int codigoMercado){
        return  listItens(codigoPro, codigoMercado, true);
    }

    public List<ItemProductVO> listItens(int codigoPro, int codigoMercado, boolean orderDesc){
        db = helper.getReadableDatabase();

        StringBuffer bf = new StringBuffer();
        bf.append("SELECT * FROM ");
        bf.append(DataBaseHelper.TABLE_ITEM);

        String[] argumentos = null;
        if ((codigoPro != 0) || (codigoMercado != 0)) {
            bf.append(" WHERE ");

            if(codigoPro != 0){
                bf.append(DataBaseHelper.COLUMN_FK_PROD);
                bf.append(" = ? ");

                if(codigoMercado != 0){
                    bf.append(",");
                    bf.append(DataBaseHelper.COLUMN_FK_MER);
                    bf.append(" = ? ");
                }

                argumentos = new String[]{String.valueOf(codigoPro), String.valueOf(codigoMercado)};

            }else{
                if(codigoMercado != 0){
                    bf.append(DataBaseHelper.COLUMN_FK_MER);
                    bf.append(" = ? ");

                    argumentos = new String[]{String.valueOf(codigoMercado)};
                }
            }
        }

        bf.append(" ORDER BY ");
        bf.append(DataBaseHelper.COLUMN_PRIC_IT);

        if(orderDesc)
            bf.append(" DESC ");

        Cursor cursor = db.rawQuery(bf.toString(), argumentos);

        List<ItemProductVO> listItens = new ArrayList<ItemProductVO>();

        cursor.moveToFirst();

        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID));
            String location = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_LOCA_IT));
            Double price = cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.COLUMN_PRIC_IT));

            ProductVO prod = ItemProduto(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_FK_PROD)));
            MercadoVO merc = ItemMercado(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_FK_MER)));


            ItemProductVO itemVo = new ItemProductVO();
            itemVo.setProduto(prod);
            itemVo.setMercado(merc);
            itemVo.setId(id);
            itemVo.setLocation(location);
            itemVo.setPrice(price);

            listItens.add(itemVo);
        }

        cursor.close();
        db.close();

        return listItens;
    }

    public ProductVO ItemProduto(int codiPro){
        return listProd(codiPro).get(0);
    }

    public List<ProductVO> listProd(){
        return  listProd(null);
    }

    public List<ProductVO> listProd(Object where){
        db = helper.getReadableDatabase();

        StringBuffer bf = new StringBuffer();
        bf.append("SELECT * FROM ");
        bf.append(DataBaseHelper.TABLE_COMP);

        String[] argumentos = null;
        if (where != null) {
            bf.append(" WHERE ");

            if(where instanceof String){
                bf.append(DataBaseHelper.COLUMN_NAME_COMP);
                bf.append(" LIKE ? ");
            }else{
                bf.append(DataBaseHelper.COLUMN_ID);
                bf.append(" = ?");
            }

            argumentos = new String[]{String.valueOf(where)};
        }
        bf.append(" ORDER BY ");
        bf.append(DataBaseHelper.COLUMN_NAME_COMP);

        Cursor cursor = db.rawQuery(bf.toString(), argumentos);

        List<ProductVO> produtos = new ArrayList<ProductVO>();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME_COMP));

            ProductVO pr = new ProductVO();
            pr.setId(id);
            pr.setName(nome);

            produtos.add(pr);
        }

        cursor.close();
        db.close();

        return produtos;
    }

    public MercadoVO ItemMercado(int codigo){
        return  listMercados(codigo).get(0);
    }

    public List<MercadoVO> listMercados(){
        return  listMercados(null);
    }

    public List<MercadoVO> listMercados(Object where){
        db = helper.getReadableDatabase();

        StringBuffer bf = new StringBuffer();
        bf.append("SELECT * FROM ");
        bf.append(DataBaseHelper.TABLE_MERCADO);

        String[] argumentos = null;
        if (where != null) {
            bf.append(" WHERE ");

            if(where instanceof String){
                bf.append(DataBaseHelper.COLUMN_NAME_MERC);
                bf.append(" LIKE ? ");
            }else{
                bf.append(DataBaseHelper.COLUMN_ID);
                bf.append(" = ?");
            }

            argumentos = new String[]{String.valueOf(where)};

        }
        bf.append(" ORDER BY ");
        bf.append(DataBaseHelper.COLUMN_NAME_MERC);

        Cursor cursor = db.rawQuery(bf.toString(), argumentos);

        List<MercadoVO> mercados = new ArrayList<MercadoVO>();

        cursor.moveToFirst();

        while (cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME_MERC));
            String endereco = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_ENDE_MERC));

            MercadoVO vo = new MercadoVO();
            vo.setId(id);
            vo.setName(nome);
            vo.setEndereco(endereco);

            mercados.add(vo);
        }

        cursor.close();
        db.close();

        return mercados;
    }

    private void AutoInserMercados(){
        MercadoVO mercado = new MercadoVO();
        mercado.setName("Mercado Preco BOM");
        mercado.setEndereco("Rua Tenente Camargo, 1370");
        insertMercado(mercado);

        mercado.setName("Mercado CompreAqui");
        mercado.setEndereco("Rua Buenos Aires, 66");
        insertMercado(mercado);
    }

    private void AutoInserProdutos(){
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
    }
}
