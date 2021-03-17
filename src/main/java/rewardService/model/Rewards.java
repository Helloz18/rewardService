package rewardService.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Rewards {

	public UUID userId;
	public List<UserReward> userRewards = new ArrayList<>();
	
	public void addUserReward(UserReward userReward) {
		if(userRewards.stream().filter(r -> !r.attraction.attractionName.equals(userReward.attraction)).count() == 0) {
			userRewards.add(userReward);
		}
	}
	
	public List<UserReward> getUserRewards() {
		return userRewards;
	}
	
}
