package com.secure.notes.controllers;

import com.secure.notes.models.Note;
import com.secure.notes.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody String content,
                           @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: "+ username);
        return  noteService.createNoteForUser(username,content);
    }

    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: "+ username);
        return noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable("noteId") Long noteId,
                           @RequestBody String content,
                           @AuthenticationPrincipal UserDetails userDetails
                           ){
        String username = userDetails.getUsername();
        return noteService.updateNoteForUser(noteId,content,username);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable("noteId") Long noteId,
                           @AuthenticationPrincipal UserDetails userDetails
    ){
        String username = userDetails.getUsername();
         noteService.deleteNoteForUser(noteId,username);
    }

}
