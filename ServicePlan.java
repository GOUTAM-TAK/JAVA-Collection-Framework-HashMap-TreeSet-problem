package core;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATANIUM(10000);

	private int additionalCost;

	private ServicePlan(int additionalCost) {
		this.additionalCost = additionalCost;
	}

	public int getAdditionalCost() {
		return additionalCost;
	}

}
