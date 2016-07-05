package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.net.URL;
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
		patternGroup = helper.orderFillerPatternConfigs(patternGroup);
		
		for (FillerPatternConfig pattern : patternGroup) {
			String url = reader.getFillerGroups(FillerGroupTypes.ACCOUNT)[0].getUrlSufix() 
					+ pattern.getUrlPattern();
			
			if (schedulerType == pattern.getSchedulerType() || schedulerType == SchedulerTypes.ALL) {
				if (pattern instanceof FillerObjectPatternConfig 
						&& ((FillerObjectPatternConfig) pattern).getObject() instanceof Account) {
					
				} else if (pattern instanceof FillerArrayPatternConfig) {
					FillerArrayPatternConfig arr = (FillerArrayPatternConfig) pattern;
					if (arr.getPropertyName().equals("accountBank")) {
						
					} else if (arr.getPropertyName().equals("accountWallet")) {
						
					} else if (arr.getPropertyName().equals("accountMaterials")) {
						
					} else if (arr.getPropertyName().equals("accountInventory")) {
						
					} else if (arr.getPropertyName().equals("accountTitles")) {
						
					} else if (arr.getPropertyName().equals("accountSkins")) {
						
					} else if (arr.getPropertyName().equals("accountMinis")) {
						
					} else if (arr.getPropertyName().equals("accountDyes")) {
						
					} else if (arr.getPropertyName().equals("accountAchievements")) {
						
					}
				}
			}
		}
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
