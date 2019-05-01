package com.soutosslave.listadepaises.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import  java.lang.String;
import com.soutosslave.listadepaises.Model.Country;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private SQLHelper helper;
    private SQLiteDatabase db;

    public Repositorio(Context ctx){
        helper = new SQLHelper(ctx);
    }

    public long inserir(Country country){
        db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLHelper.COLUNA_NAME, country.name);
        cv.put(SQLHelper.COLUNA_ALPHA2, country.alpha2Code);
        cv.put(SQLHelper.COLUNA_ALPHA3, country.alpha3Code);
        cv.put(SQLHelper.COLUNA_CAPITAL, country.capital);
        cv.put(SQLHelper.COLUNA_REGION, country.region);
        cv.put(SQLHelper.COLUNA_SUBREGION, country.subregion);
        cv.put(SQLHelper.COLUNA_POPULATION, country.population);
        cv.put(SQLHelper.COLUNA_AREA, country.area);
        cv.put(SQLHelper.COLUNA_LATITUDE, country.latitude);
        cv.put(SQLHelper.COLUNA_LONGITUDE, country.longitude);

        cv.put(SQLHelper.COLUNA_RELEVANCE, country.relevance);

        long id = db.insert(SQLHelper.TABELA_COUNTRY,null, cv);

        db.close();
        return id;
    }

    public void excluirAll(){
        db = helper.getWritableDatabase();
        db.delete(SQLHelper.TABELA_COUNTRY, null, null);
        db.close();
    }

    public List<Country> listarCountry() {
        String sql = "SELECT * FROM " + SQLHelper.TABELA_COUNTRY;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Country> list = new ArrayList();

        while (cursor.moveToNext()) {
            String name = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_NAME)
            );
            String alpha2 = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ALPHA2)
            );
            String alpha3 = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ALPHA3)
            );
            String capital = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_CAPITAL)
            );
            String region = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_REGION)
            );
            String subregion = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_SUBREGION)
            );
            String population = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_POPULATION)
            );
            String area = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_AREA)
            );
            String latitude = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LATITUDE)
            );
            String longitude = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LONGITUDE)
            );

            String relevance = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_RELEVANCE)
            );
               String[] latlng = new String[2];
               latlng[0]= latitude;
               latlng[1]= longitude;
               Country country = new Country(name, alpha2, alpha3, capital, region, subregion, population, area, latlng, relevance);
            list.add(country);
        }
        cursor.close();
        return list;
    }

}