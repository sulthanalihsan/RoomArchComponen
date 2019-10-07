package com.example.roomarchcomponen.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomarchcomponen.database.WordRepository;
import com.example.roomarchcomponen.entity.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository wordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        mAllWords = wordRepository.getmAllWords();
    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        wordRepository.Insert(word);
    }
}
