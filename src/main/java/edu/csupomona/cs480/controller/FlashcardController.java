package edu.csupomona.cs480.controller;

import com.sun.org.apache.regexp.internal.RE;
import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class FlashcardController {

    private FlashcardService flashcardService;

    @Autowired
    public void setFlashcardService(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    //Create
    @RequestMapping("flashcard/new")
    public String newFlashcard(Model model) {
        model.addAttribute(new Flashcard());
        return "flashcardform";
    }

    //Create & Update
    @RequestMapping(value = "flashcard", method = RequestMethod.POST)
    public String saveFlashcard(Flashcard flashcard) {
        flashcardService.saveFlashcard(flashcard);
        return "redirect:/flashcard/" + flashcard.getId();
    }

    //Read
    @RequestMapping("flashcard/{id}")
    public String showFlashCard(@PathVariable Integer id, Model model) {
        model.addAttribute("flashcard", flashcardService.getFlashcardById(id));
        return "flashcardshow";
    }

    //List all
    @RequestMapping(value = "flashcards", method = RequestMethod.GET)
    public List<Flashcard> list(Model model) {
        //model.addAttribute("flashcards", flashcardService.listAllFlashcards());

        List<Flashcard> list = new ArrayList<>();
        Iterator f = flashcardService.listAllFlashcards().iterator();
        while(f.hasNext()) {
            list.add((Flashcard) f.next());
        }

        return list;
    }

    //Update
    @RequestMapping("flashcard/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("flashcard", flashcardService.getFlashcardById(id));
        return "flashcardform";
    }

    //Delete
    @RequestMapping("flashcard/delete/{id}")
    public String delete(@PathVariable Integer id) {
        flashcardService.deleteFlashcard(id);
        return "redirect:/flashcards";
    }

    //List Flashcards
    @RequestMapping("user/flashcards/{id}")
    public String listFlashcards(@PathVariable String id, Model model) {
        model.addAttribute("flashcards", flashcardService.listAllFlashcardsByUserId(id));
        return "flashcards";
    }

    //return a given sets
    @RequestMapping(value = "flashcard/set/{setId}", method = RequestMethod.GET)
    public List<Flashcard> listFlashcardSet(@PathVariable String setId) {

        return flashcardService.listAllFlashcardsBySetId(setId);
    }

    //receive a set and add to database
    @RequestMapping(value = "flashcard/set/new", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void saveFlashcardSet(@RequestBody List<Flashcard> flashcard) {

        for(Flashcard f : flashcard) {
            System.out.println(f.getSetId());
            flashcardService.saveFlashcard(f);
        }
    }
}
