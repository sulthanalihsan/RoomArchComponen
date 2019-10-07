package com.example.roomarchcomponen.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.roomarchcomponen.entity.Word;

import java.util.List;

public class WordRepository {
    private WordDao mWordao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordao = db.wordDao();
        mAllWords = mWordao.getAphabetWord();
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void Insert(Word word) {
        new insertAsynTask(mWordao).execute(word);
    }

    private static class insertAsynTask extends AsyncTask<Word, Void, Void> {
        private WordDao mAsyntaskDao;

        insertAsynTask(WordDao dao) {
            mAsyntaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyntaskDao.insert(words[0]);
            return null;
        }
    }
}
