package com.fjbg.todo.di

import android.content.Context
import androidx.room.Room
import com.fjbg.todo.data.local.TaskDatabase
import com.fjbg.todo.data.local.db.Converter
import com.fjbg.todo.data.local.db.TaskDao
import com.fjbg.todo.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DbModule {

    @Provides
    fun provideTaskDatabase(@ApplicationContext applicationContext: Context): TaskDatabase {
        return Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            DB_NAME
        ).addTypeConverter(Converter::class).build()
    }

    @Provides
    fun provideTaskDao(taskDatabase: TaskDatabase): TaskDao {
        return taskDatabase.taskDao()
    }
}