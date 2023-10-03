package com.barisgungorr.data.datasource

import android.util.Log
import com.barisgungorr.data.entity.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesDataSource {
   suspend fun save(note_title: String, text_main:String) {
        Log.e("Note kaydet","$note_title - $text_main")
    }

  suspend  fun update(note_title:String,text_main:String) {
        Log.e("Kişi Güncelle", "$note_title - $text_main")

    }

  suspend  fun delete(note_title:String) {
        Log.e("Note Sil", note_title.toString())
    }

    suspend fun notesAdd() : List<Notes> = withContext(Dispatchers.IO) {
        val notes = ArrayList<Notes> ()
        val n1 = Notes("Baslik 1", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
        val n2 = Notes("Baslik 2", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
        val n3 = Notes("Baslik 3", "bugün hava çok kapalı bugün hava çok kapalı bugün hava çok kapalı ")
        val n4 = Notes("Baslik 4", "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.")

        notes.add(n1)
        notes.add(n2)
        notes.add(n3)
        notes.add(n4)
        return@withContext notes
    }

    suspend fun search(searchKeyword:String) : List<Notes> = withContext(Dispatchers.IO) {
        val notes = ArrayList<Notes>()

        val n1 = Notes("Title 1", "Today is weather cloudy ")

        notes.add(n1)

        return@withContext notes
    }


}