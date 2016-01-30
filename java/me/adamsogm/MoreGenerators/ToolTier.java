package me.adamsogm.MoreGenerators;

public enum ToolTier {
	CRUDE(0), BASIC(1), STANDARD(2), IMPROVED(3), REINFORCED(4), ADVANCED(5), ULTIMATE(6);
	private final int tier;
	
	ToolTier(int tier){
		this.tier = tier;
	}
	
	public int tier(){
		return tier;
	}
	 
	public static ToolTier getTier(int tier){
		for(ToolTier tmpTier : ToolTier.values()){
			if(tmpTier.tier() == tier){
				return tmpTier;
			}
		}
		return null;
	}
	
}
