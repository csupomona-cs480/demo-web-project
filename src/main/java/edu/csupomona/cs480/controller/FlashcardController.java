package edu.csupomona.cs480.controller;

import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
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
    @RequestMapping(value = "flashcards")
    public String list(Model model) {
        model.addAttribute("flashcards", flashcardService.listAllFlashcards());
        return "flashcards";
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

//    @RequestMapping("user/flashcards/{setId}")
//    public String listFlashcardSet(@PathVariable String setId, Model model) {
//        model.addAttribute("flashcards", flashcardService.listAllFlashcardsBySetId(setId));
//        return "flashcardset";
//    }
}
