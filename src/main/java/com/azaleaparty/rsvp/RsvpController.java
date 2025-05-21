package com.azaleaparty.rsvp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
public class RsvpController {
    @Autowired
    private RsvpRepository rsvpRepository;

    @PostMapping("/rsvp")
    public String submitRsvp(@ModelAttribute Rsvp rsvp) {
        if (rsvp.getId() != null && rsvpRepository.findById(rsvp.getId()).isPresent()) {
            Rsvp existingRsvp = rsvpRepository.findById(rsvp.getId()).get();
            existingRsvp.setName(rsvp.getName());
            existingRsvp.setEmail(rsvp.getEmail());
            existingRsvp.setKids(rsvp.getKids());
            existingRsvp.setAdults(rsvp.getAdults());
            rsvpRepository.save(existingRsvp);
        } else {
            rsvp.setCreatedAt(new java.util.Date());
            rsvpRepository.save(rsvp);
        }

        return "redirect:/index/" + rsvp.getId();
    }

    @PostMapping("/rsvp/email")
    public Rsvp getRsvpByEmail(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        return rsvpRepository.findByEmail(email);
    }

    @GetMapping("/rsvp/{id}")
    public Rsvp getRsvpById(@PathVariable("id") UUID id) {
        return rsvpRepository.findById(id).orElse(null);
    }
}
