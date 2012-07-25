package com.colorcc.user.mapper.test.base;

import java.util.Map;

public interface DbTestInitialization {
	
	public enum DbAction {
		DROP("drop"),
		CREATE("create");	
		
		private String action;
		DbAction(String action) {
			this.action = action;
		}
		
		public String getActionValue() {
			return this.action;
		}
		
		public static DbAction fromString(String action) {
			if (action != null) {
				for (DbAction dbAction : DbAction.values()) {
					if (action.equalsIgnoreCase(dbAction.action)) {
						return dbAction;
					}
				}
			}
			return null;
		}
	};
	
	
	public Map<String, String> getdbPropertyMap();
	
	public boolean canInit();
	
	public void dropOrCreateDatabae(String action);
	
	public void initDatabase();

}
