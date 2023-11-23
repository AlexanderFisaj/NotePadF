package org.example.presenter;

import org.example.model.Note;
import org.example.model.NoteModel;
import org.example.view.NoteView;

import java.util.List;

public class NotePresenterImpl implements NotePresenter {
    private NoteModel model;
    private NoteView view;

    public NotePresenterImpl(NoteModel model, NoteView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void createNote(String topic, String content, String date, String time) {
        model.createNote(topic, content, date, time);
        view.displayMessage("Note created successfully.");
    }

    @Override
    public void getAllNotes() {
        List<Note> notes = model.getAllNotes();
        view.displayNotes(notes);
    }

    @Override
    public void getNotesByDate(String date) {
        List<Note> notes = model.getNotesByDate(date);
        view.displayNotes(notes);
    }
    @Override
    public void sortNotesByDate() {
        List<Note> sortedNotes = model.sortNotesByDate();
        view.displayNotes(sortedNotes);
    }

    @Override
    public void searchNotesByKeyword(String keyword) {
        List<Note> searchResults = model.searchNotesByKeyword(keyword);
        view.displayNotes(searchResults);
    }

}
