package com.example.room

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.room.ui.theme.RoomTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val context = LocalContext.current
    val vt = Veritabani.veritabaniErisim(context)!!

    LaunchedEffect(key1 = true){
//        sil(vt)
//        ekle(vt)
//        tumKisiler(vt)
    }
}

fun tumKisiler(vt:Veritabani){
    val job:Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().tumKisiler()

        for (k in liste){
            Log.e("Kisi_bilgi", "*******")
            Log.e("Kisi_id", k.kisi_id.toString())
            Log.e("Kisi_adi", k.kisi_ad)
            Log.e("Kisi_tel", k.kisi_tel)
        }
    }

}

fun ekle(vt:Veritabani){
    val job:Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = Kisiler(0,"Murad","519948539")
        vt.kisilerDao().kisiEkle(yeniKisi)
    }

}

fun sil(vt:Veritabani){
    val job:Job = CoroutineScope(Dispatchers.Main).launch {
        val kisiSil = Kisiler(7,"","")
        vt.kisilerDao().kisiSil(kisiSil)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomTheme {
        Sayfa()
    }
}