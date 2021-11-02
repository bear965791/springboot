package edu.ntut.project_01.homegym.repository;

import edu.ntut.project_01.homegym.model.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;

public interface CoachRepository extends CrudRepository<Coach,Integer> {

}
