package org.verscend.bbplus.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.BloodGroup;
import org.verscend.bbplus.models.BloodRecord;
import org.verscend.bbplus.repository.BloodGroupRepository;
import org.verscend.bbplus.repository.BloodRecordRepository;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRecordResource {

@Autowired
BloodRecordRepository bloodRecordRepository;

@Autowired
BloodGroupRepository bloodGroupRepository;

@PostMapping("saveRecord")
public void save(@RequestBody Map<String, String> record) {
BloodGroup bloodGroup = bloodGroupRepository.findById(Integer.parseInt(record.get("bloodGroupId"))).get();
BloodRecord bloodRecord = new BloodRecord(null, bloodGroup, Long.parseLong(record.get("pint")),
record.get("donorName"), Long.parseLong(record.get("donorPhone")));
bloodRecordRepository.save(bloodRecord);
}

@GetMapping("records")
public List<BloodRecord> findUsers() {
List<BloodRecord> recordList = new ArrayList<>();
bloodRecordRepository.findAll().forEach(recordList::add);
return recordList;
}

@DeleteMapping("records/{id}")
public void deleteRecord(@PathVariable int id) {
bloodRecordRepository.deleteById(id);
}

@PutMapping("updateRecord")
public void updateRecord(@RequestBody BloodRecord bloodRecord) {
bloodRecordRepository.save(bloodRecord);
}
@GetMapping("filter/{fromDate}/{toDate}")
List<Map<String, Object>> dateBasedRecord(@PathVariable String fromDate, @PathVariable String toDate) {
List<Map<String, Object>> filtered = bloodRecordRepository.dateBasedRecord(fromDate, toDate);
return filtered;
}

@GetMapping("request/{bloodType}/{pint}")
public void deleteInDummy(@PathVariable String bloodType, @PathVariable long pint) {
	bloodRecordRepository.deleteInDummy(bloodType, pint);

} 

}