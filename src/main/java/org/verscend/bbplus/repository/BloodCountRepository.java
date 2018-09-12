package org.verscend.bbplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.BloodCount;
import org.verscend.bbplus.models.BloodGroup;

public interface BloodCountRepository extends CrudRepository<BloodCount, Long> {
    BloodCount findByBloodGroup(BloodGroup bloodGroup);

}
