package com.goadviser.services;

import com.goadviser.models.Adviser;
import com.goadviser.repositories.AdvisersRepository;
import com.goadviser.repositories.exceptions.AdviserNotFoudException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvisersService {

    @Autowired
    private AdvisersRepository advisersRepository;

    public Adviser update(final String id, final Adviser adviser) throws AdviserNotFoudException {
        Adviser adviserRestored = getAdviser(id);

        BeanUtils.copyProperties(adviser, adviserRestored, "id");

        return advisersRepository.save(adviserRestored);
    }

    private Adviser getAdviser(final String id) {
        Adviser adviserRestored = advisersRepository.findOne(id);

        if (adviserRestored == null) {
            throw new AdviserNotFoudException("Adviser not found with id: " + id);
        }
        return adviserRestored;
    }
}
