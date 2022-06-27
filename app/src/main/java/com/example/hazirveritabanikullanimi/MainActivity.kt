package com.example.hazirveritabanikullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        val vt = VeriTabaniYardimcisi(this)

        //val liste = Kategorilerdao().tumKategoriler(vt)
        val liste = Filmlerdao().tumFilmlerByKategoriId(vt,2)

        for (f in liste){
            Log.e("Film id",f.film_id.toString())
            Log.e("Film ad",f.film_ad)
            Log.e("Film yil",f.film_yil.toString())
            Log.e("Film resim",f.film_resim)
            Log.e("Film Kategori id",f.kategori.kategori_id.toString())
            Log.e("Film Kategori ad",f.kategori.kategori_ad)
            Log.e("Film Yönetmen id",f.yonetmen.yonetmen_id.toString())
            Log.e("Film Yönetmen ad",f.yonetmen.yonetmen_ad)
        }
    }

    fun veritabaniKopyala(){

        val db = DatabaseCopyHelper(this)


        try {
            db.createDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}