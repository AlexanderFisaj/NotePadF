package org.example.model;

import java.io.IOException;
import java.util.List;

public interface NoteModel {
    void createNote(String topic, String content, String date, String time);
    List<Note> getAllNotes();
    List<Note> getNotesByDate(String date);
    List<Note> sortNotesByDate();
    List<Note> searchNotesByKeyword(String keyword);
    void saveNotesToFile(String filePath) throws IOException;
    void loadNotesFromFile(String filePath) throws IOException;

}

