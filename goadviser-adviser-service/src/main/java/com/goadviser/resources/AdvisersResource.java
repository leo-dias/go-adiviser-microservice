package com.goadviser.resources;

import com.goadviser.models.Adviser;
import com.goadviser.repositories.AdvisersRepository;
import com.goadviser.services.AdvisersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class AdvisersResource {

    @Autowired
    private AdvisersRepository advisersRepository;

    @Autowired
    private AdvisersService advisersService;

    @GetMapping
    public List<Adviser> findAll() {
        return advisersRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Adviser> findById(@PathVariable final String id) {
        Adviser adviser = advisersRepository.findOne(id);
        return adviser == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(adviser);
    }

    @GetMapping(params = {"filter"})
    public ResponseEntity<List<Adviser>> filter(@RequestParam("filter") final String filter) {
        List<Adviser> adviserList = advisersRepository.find(filter);
        return adviserList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(adviserList);
    }

    @PostMapping
    public ResponseEntity<Adviser> create(@Valid @RequestBody final Adviser adviser) {
        Adviser adviserSaved = advisersRepository.save(adviser);
        return ResponseEntity.created(URI.create("/advisers/" + adviserSaved.getId())).body(adviserSaved);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Adviser> update(@PathVariable final String id, @Valid @RequestBody final Adviser adviser) {
        Adviser adviserSaved = advisersService.update(id, adviser);
        return ResponseEntity.created(URI.create("/advisers/" + adviserSaved.getId())).body(adviserSaved);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final String id) {
        advisersRepository.delete(id);
    }
}
