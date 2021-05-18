package com.example.tubes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;

public class CategoryDBHelper extends SQLiteOpenHelper {

    public static final String CATEGORY_VOCAB = "Vocabulary";
    public static final String CATEGORY_VOCAB2 = "Vocabulary";
    public static final String CATEGORY_VOCAB3 = "Vocabulary";
    public static final String CATEGORY_VOCAB4 = "Vocabulary";
    public static final String CATEGORY_VOCAB5 = "Vocabulary";
    public static final String CATEGORY_VOCAB6 = "Vocabulary";

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + CategoryContract.QuestionsTable.TABLE_NAME +
            "(" +
            CategoryContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CategoryContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_ANSWER + " TEXT, " +
            CategoryContract.QuestionsTable.COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + CategoryContract.QuestionsTable.TABLE_NAME;
    private SQLiteDatabase db;

    public CategoryDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }
}
