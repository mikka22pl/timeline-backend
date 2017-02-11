package org.ulv.timeline.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.model.Distributor;
import org.ulv.timeline.service.DistributorService;

@RestController
@RequestMapping("timeline")
public class DistributorController {

	@Autowired
	private DistributorService distributorService;
	
	@RequestMapping(value="/services", method=RequestMethod.GET)
	public ResponseEntity<List<Distributor>> getServices() {
		
		List<Distributor> distributors = distributorService.getDistributors(null);
		
		return new ResponseEntity<List<Distributor>>(distributors, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
