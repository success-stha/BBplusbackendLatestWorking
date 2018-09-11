package org.verscend.bbplus.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.verscend.bbplus.models.BloodRequest;
import org.verscend.bbplus.repository.BloodGroupRepository;
import org.verscend.bbplus.repository.BloodRequestRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRequestResource {

	@Autowired
	BloodRequestRepository bloodRequestRepository;

	@Autowired
	BloodGroupRepository bloodGroupRepository;

	@PostMapping("saveBloodRequest")
	public void save(@RequestBody Map<String, String> record) {
		BloodGroup bloodGroup = bloodGroupRepository.findById(Integer.parseInt(record.get("bloodGroupId"))).get();
		BloodRequest bloodRequest = new BloodRequest(null, bloodGroup, Long.parseLong(record.get("pint")),
				Boolean.parseBoolean(record.get("status")));
		bloodRequestRepository.save(bloodRequest);
	}

	@GetMapping("requests")
	public List<BloodRequest> findBloodRequests() {
		List<BloodRequest> requestList = new ArrayList<>();
		bloodRequestRepository.findAll().forEach(requestList::add);
		return requestList;
	}

	@GetMapping("requests/{id}")
	public Optional<BloodRequest> findById(@PathVariable int id) {
		return bloodRequestRepository.findById(id);
	}

	@DeleteMapping("requests/{id}")
	public void deleteRequest(@PathVariable Integer id) {
		bloodRequestRepository.deleteById(id);
	}

	@PutMapping("updateRequest")
	public void updateRequest(@RequestBody BloodRequest bloodRequest) {
		bloodRequestRepository.save(bloodRequest);
	}

}
