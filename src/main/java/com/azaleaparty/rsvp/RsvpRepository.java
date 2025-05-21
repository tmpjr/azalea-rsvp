package com.azaleaparty.rsvp;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.UUID;

public interface RsvpRepository extends CrudRepository<Rsvp, Long> {
    Optional<Rsvp> findById(UUID id);
    Rsvp findByEmail(String email);
}
