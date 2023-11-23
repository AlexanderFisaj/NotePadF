package org.example.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteModelImpl implements NoteModel {
    private List<Note> notes;

    public NoteModelImpl() {
        this.notes = new ArrayList<>();
    }

    @Override
    public void createNote(String topic, String content, String date, String time) {
        Note note = new Note(topic, content, date, time);
        notes.add(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public List<Note> getNotesByDate(String date) {
        List<Note> notesByDate = new ArrayList<>();
        for (Note note : notes) {
            if (note.getDate().equals(date)) {
                notesByDate.add(note);
            }
        }
        return notesByDate;
    }

    @Override
    public List<Note> sortNotesByDate() {
        List<Note> sortedNotes = new ArrayList<>(notes);
        Collections.sort(sortedNotes, (note1, note2) -> note1.getDate().compareTo(note2.getDate()));
        return sortedNotes;
    }

    @Override
    public List<Note> searchNotesByKeyword(String keyword) {
        List<Note> matchingNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getTopic().contains(keyword) || note.getContent().contains(keyword)) {
                matchingNotes.add(note);
            }
        }
        return matchingNotes;
    }

    @Override
    public void saveNotesToFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), notes);
    }

    @Override
    public void loadNotesFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        notes = objectMapper.readValue(new File(filePath), new TypeReference<List<Note>>() {});
    }
}
