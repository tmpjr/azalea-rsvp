package com.azaleaparty.rsvp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@SpringBootApplication
@Controller
public class RsvpApplication {
    @Autowired
    private RsvpRepository rsvpRepository;

    public static void main(String[] args) {
        SpringApplication.run(RsvpApplication.class, args);
    }

    @GetMapping({"/", "/{id:[0-9a-fA-F\\-]{36}}"})
    public String index(@PathVariable(value = "id", required = false) String id, Model model) {
        Rsvp rsvp;
        if (id != null) {
            try {
                UUID uuid = UUID.fromString(id);
                rsvp = rsvpRepository.findById(uuid).orElse(new Rsvp());
            } catch (IllegalArgumentException e) {
                rsvp = new Rsvp();
            }
        } else {
            rsvp = new Rsvp();
        }
        model.addAttribute("rsvp", rsvp);

        return "index";
    }
}
