package com.fjbg.todo.data.local.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.fjbg.todo.data.local.model.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converter {

    @TypeConverter
    fun fromCategoriesToJson(categories: List<CategoryEntity>): String = Gson().toJson(categories)

    @TypeConverter
    fun frmJsonToCategories(categories: String): List<CategoryEntity> {
        val listType = object : TypeToken<List<Category>>() {}.type
        return Gson().fromJson(categories, listType)
    }
}
