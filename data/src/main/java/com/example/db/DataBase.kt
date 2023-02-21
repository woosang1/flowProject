package com.example.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    version = 1,
    entities = [RecentlyMovieData::class, RecentlyKeywordData::class],
    exportSchema = false
)

abstract class DataBase : RoomDatabase(){

    // 영화
    abstract fun recentlyMovieDao(): RecentlyMovieDao

    // 키워드
    abstract fun recentlyKeywordDao(): RecentlyKeywordDao

    companion object {

        private var instance: DataBase? = null

        @Synchronized
        fun getInstance(context: Context): DataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context,
                    DataBase::class.java, "recently.db")
                    .addMigrations(*MIGRATIONS)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}

private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        with(database) {
            execSQL("ALTER TABLE recently ADD COLUMN new_content INTEGER")
            execSQL("ALTER TABLE recently ADD COLUMN display_level TEXT")
        }
    }
}

val MIGRATIONS: Array<Migration> = arrayOf(MIGRATION_1_2)