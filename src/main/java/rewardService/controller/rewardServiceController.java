package rewardService.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import rewardCentral.RewardCentral;
import rewardService.service.RewardsService;

@RestController
public class rewardServiceController {


	private final GpsUtil gpsUtil = new GpsUtil();
	private final RewardCentral rewardsCentral = new RewardCentral();
	RewardsService rewardService = new RewardsService(gpsUtil, rewardsCentral);
	
	/**
	 * get distance between two location
	 * @param location1
	 * @param location2
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@RequestMapping(path="/distance")
	public Double distance(String location1, String location2) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Double longitude1 = mapper.readTree(location1).get("longitude").asDouble();
		Double latitude1 = mapper.readTree(location1).get("latitude").asDouble(); 
		Double longitude2 = mapper.readTree(location2).get("longitude").asDouble();
		Double latitude2 = mapper.readTree(location2).get("latitude").asDouble(); 
		
		Location firstLocation = new Location(longitude1, latitude1);
		Location secondLocation = new Location(longitude2, latitude2);
		return rewardService.getDistance(firstLocation, secondLocation);
	}
	
	/**
	 * indicates if a visitor is currently in the attraction
	 * @param visitorLocation
	 * @param attraction
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 * @throws ParseException 
	 */
//	@RequestMapping(path="/nearAttraction")
//	public Boolean isVisitorInAttraction(String userId, String visitedDate, String attraction, String visitorLocation, String proximitybuffer) throws JsonMappingException, JsonProcessingException, ParseException {
//		ObjectMapper mapper = new ObjectMapper();
//		UUID uid = UUID.fromString(userId); 
//	    DateTimeFormatter cet = DateTimeFormatter
//	    		.ofPattern("EE MMM dd HH:mm:ss z yyyy");
//	    LocalDateTime dateTime = LocalDateTime.parse(visitedDate, cet);
//	    
//	    int proxi = Integer.parseInt(mapper.readTree(proximitybuffer).asText());
//	    
//	    Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
//		Double visitorLongitude = mapper.readTree(visitorLocation).get("longitude").asDouble();
//		Double visitorLatitude = mapper.readTree(visitorLocation).get("latitude").asDouble(); 
//		Double attractionLongitude = mapper.readTree(attraction).get("longitude").asDouble();
//		Double attractionLatitude = mapper.readTree(attraction).get("latitude").asDouble(); 
//		String attractionName = mapper.readTree(attraction).get("attractionName").asText();
//		String attractionCity = mapper.readTree(attraction).get("city").asText();
//		String attractionState = mapper.readTree(attraction).get("state").asText();
//		
//		Location visitor = new Location(visitorLongitude, visitorLatitude);
//		//Location attractionlocation = new Location(attractionLongitude, attractionLatitude);
//		
//		VisitedLocation visitedLocation = new VisitedLocation(uid, visitor, date);
//		Attraction attractionOk = new Attraction(attractionName, attractionCity, attractionState, attractionLatitude, attractionLongitude);
//		
//		//return rewardService.proximityAttraction(visitor, attraction);
//		return rewardService.nearAttraction(visitedLocation, attractionOk, proxi);
//	}
	
	
	
	@PostMapping(path="/test2")
	public String test2(String a,String b) {
		return "a"+a+"b"+b;
	}
}
