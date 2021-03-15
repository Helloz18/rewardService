package rewardService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gpsUtil.GpsUtil;
import gpsUtil.location.Location;
import rewardCentral.RewardCentral;
import rewardService.service.RewardsService;

class ControllerTest {
	
	private final GpsUtil gpsUtil = new GpsUtil();
	private final RewardCentral rewardsCentral = new RewardCentral();
	RewardsService rewardService = new RewardsService(gpsUtil, rewardsCentral);

	@Test
	void test() {
		
		Location l = new Location(1.2, 5.6);
		Location t = new Location(1.2, 5.6);
		assertEquals(rewardService.getDistance(l, t), 0.0);
	}

	@Test
	void testMapper() throws JsonMappingException, JsonProcessingException {
		String l1="{\"longitude\": -151.3888959460539,\"latitude\": -20.229208870934826	}";
		ObjectMapper mapper = new ObjectMapper();
		Double test = mapper.readTree(l1).get("longitude").asDouble();
		assertEquals(test, -151.3888959460539);
	}
	
	@Test
	void testGlobal() throws JsonMappingException, JsonProcessingException {
		String l1="{\"longitude\": 1.2,\"latitude\": -5.6	}";
		String l2="{\"longitude\": 1.2,\"latitude\": -5.6	}";
		ObjectMapper mapper = new ObjectMapper();
		Double t1 = mapper.readTree(l1).get("longitude").asDouble();
		Double t1b = mapper.readTree(l1).get("latitude").asDouble(); 
		Double t2 = mapper.readTree(l2).get("longitude").asDouble();
		Double t2b = mapper.readTree(l2).get("latitude").asDouble(); 
		
		Location l = new Location(t1, t1b);
		Location t = new Location(t2, t2b);
		assertEquals(rewardService.getDistance(l,t), 0.0);
		
	}
	
		
	
}

