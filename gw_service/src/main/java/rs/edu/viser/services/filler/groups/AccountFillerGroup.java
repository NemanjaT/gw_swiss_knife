package rs.edu.viser.services.filler.groups;

import java.util.List;

import rs.edu.viser.json.models.Account;
import rs.edu.viser.json.models.AccountAchievements;
import rs.edu.viser.json.models.AccountInventory;
import rs.edu.viser.json.models.AccountMaterials;
import rs.edu.viser.json.models.AccountWallet;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;
import rs.edu.viser.services.filler.config.JacksonModeler;

/**
 * Account filler group
 * @author neman
 *
 */
public class AccountFillerGroup extends FillerGroup {
	private Account account;
	private GeneratedJsonArrays arrays;
	
	private FillerConfigReader reader;
	private JacksonModeler jack;
	
	public AccountFillerGroup() {
		this.account = new Account();
		this.arrays = new GeneratedJsonArrays();
		
		this.reader = FillerConfigReader.getFillerConfigReader();
		this.jack = new JacksonModeler();
	} 

	@Override
	public void getModels(SchedulerTypes schedulerType) {
		//getting the filler patterns. . .
		FillerPatternConfig[] patternGroup = reader
				.getFillerGroups(FillerGroupTypes.ACCOUNT)[0].getFillerPatterns();
		//sorting patterns so all arrays are called in first. . .
		patternGroup = helper.orderFillerPatternConfigs(patternGroup);
		
		this.readThroughPatterns(patternGroup, schedulerType);
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("accountBank")) {
			
		} else if (pattern.getPropertyName().equals("accountWallet")) {
			
		} else if (pattern.getPropertyName().equals("accountMaterials")) {
			
		} else if (pattern.getPropertyName().equals("accountInventory")) {
			
		} else if (pattern.getPropertyName().equals("accountTitles")) {
			
		} else if (pattern.getPropertyName().equals("accountSkins")) {
			
		} else if (pattern.getPropertyName().equals("accountMinis")) {
			
		} else if (pattern.getPropertyName().equals("accountDyes")) {
			
		} else if (pattern.getPropertyName().equals("accountAchievements")) {
			
		}
		
		return this;
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof Account) {
			
		}
		
		return this;
	}

	public Account getAccount() {
		return account;
	}
	
	public List<String> getAccountBank() {
		return arrays.getAccountBank();
	}
	
	public List<AccountWallet> getAccountWallet() {
		return arrays.getAccountWallet();
	}
	
	public List<AccountMaterials> getAccountMaterials() {
		return arrays.getAccountMaterials();
	}
	
	public List<AccountInventory> getAccountInventory() {
		return arrays.getAccountInventory();
	}
	
	public List<Integer> getAccountTitles() {
		return arrays.getAccountTitles();
	}
	
	public List<Integer> getAccountSkins() {
		return arrays.getAccountSkins();
	}
	
	public List<Integer> getAccountMinis() {
		return arrays.getAccountMinis();
	}
	
	public List<Integer> getAccountDyes() {
		return arrays.getAccountDyes();
	}
	
	public List<AccountAchievements> getAccountAchievements() {
		return arrays.getAccountAchievements();
	}

}
