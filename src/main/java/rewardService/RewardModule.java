package rewardService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gpsUtil.GpsUtil;
import rewardCentral.RewardCentral;

@Configuration
public class RewardModule {
	
	@Bean
	public GpsUtil getGpsUtil() {
		return new GpsUtil();
	}
	@Bean
	public RewardCentral getRewardCentral() {
		return new RewardCentral();
	}
	

}
