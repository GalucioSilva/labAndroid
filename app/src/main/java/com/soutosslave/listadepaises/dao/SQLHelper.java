package com.soutosslave.listadepaises.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {



    private static final String NOME_BANCO = "dbCountry";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_COUNTRY = "country_tabela";
    public static final String COLUNA_NAME = "name";
    public static final String COLUNA_ALPHA2 = "alpha2Code";
    public static final String COLUNA_ALPHA3 = "alpha3Code";
    public static final String COLUNA_CAPITAL = "capital";
    public static final String COLUNA_REGION = "region";
    public static final String COLUNA_SUBREGION = "subregion";
    public static final String COLUNA_POPULATION = "population";
    public static final String COLUNA_AREA = "area";
    public static final String COLUNA_LATITUDE = "latitude";
    public static final String COLUNA_LONGITUDE = "longitude" ;
    public static final String COLUNA_RELEVANCE ="relevance" ;
    public SQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABELA_COUNTRY + " ( " +
                        COLUNA_NAME + " TEXT," +
                        COLUNA_ALPHA2 + " TEXT, " +
                        COLUNA_ALPHA3 + " TEXT, " +
                        COLUNA_CAPITAL + " TEXT, " +
                        COLUNA_REGION + " TEXT, " +
                        COLUNA_SUBREGION+ " TEXT, " +
                        COLUNA_POPULATION + " TEXT, " +
                        COLUNA_AREA + " TEXT,"+
                        COLUNA_LATITUDE + " TEXT, " +
                        COLUNA_LONGITUDE + " TEXT, " +
                        COLUNA_RELEVANCE + " TEXT)"
        );

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // para as próximas versões
    }

}