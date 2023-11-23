package org.example.presenter;

public interface NotePresenter {
    void createNote(String topic, String content, String date, String time);
    void getAllNotes();
    void getNotesByDate(String date);

    void sortNotesByDate();

    void searchNotesByKeyword(String keyword);
}
