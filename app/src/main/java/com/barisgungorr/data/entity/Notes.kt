package com.barisgungorr.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "nots")

data class Notes( @PrimaryKey(autoGenerate = true)
                @ColumnInfo(name= "nots_id")        @NotNull var nots_id : Int,
                @ColumnInfo(name = "note_title")    @NotNull var note_title: String,
                @ColumnInfo(name = "text_main")     @NotNull var text_main: String) : Serializable {

}
