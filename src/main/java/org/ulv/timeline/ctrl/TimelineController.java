package org.ulv.timeline.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ulv.timeline.config.HeadersUtil;
import org.ulv.timeline.model.timeline.Timeline;
import org.ulv.timeline.service.TimelineService;

@RestController
@RequestMapping("timeline")
public class TimelineController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineController.class);

	@Autowired
	private TimelineService timelineService;
	
	@RequestMapping(value="timelines", method=RequestMethod.GET)
	public ResponseEntity<List<Timeline>> getTimelines() {
		log.info("--> getTimelines()");
		
		List<Timeline> timelines = timelineService.getTimelines();
		
		return new ResponseEntity<List<Timeline>>(timelines, HeadersUtil.HEADERS, HttpStatus.OK);
	}
}
