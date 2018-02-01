package com.goadviser.repositories.advisers;

import com.goadviser.models.Adviser;

import java.util.List;

public interface AdvisersRepositoryQuery {

    List<Adviser> find(String filter);

}
