package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.Account;
import rs.edu.viser.json.models.AccountAchievements;
import rs.edu.viser.json.models.AccountBank;
import rs.edu.viser.json.models.AccountInventory;
import rs.edu.viser.json.models.AccountMaterials;
import rs.edu.viser.json.models.AccountWallet;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

/**
 * Account filler group
 * @author neman
 *
 */
public class AccountFillerGroup extends FillerGroup {
	private Account account;
	private GeneratedJsonArrays arrays;
	
	public AccountFillerGroup() {
		super(FillerGroupTypes.ACCOUNT);
		
		this.account = new Account();
		this.arrays = new GeneratedJsonArrays();
	} 

	@Override
	public void getModels(SchedulerTypes schedulerType) {
		this.readThroughPatterns(schedulerType);
		
		log.info("Account Filler Group initialization finished!");
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("accountBank")) {
			processAccountBank(pattern);
		} else if (pattern.getPropertyName().equals("accountWallet")) {
			processAccountWallet(pattern);
		} else if (pattern.getPropertyName().equals("accountMaterials")) {
			processAccountMaterials(pattern);
		} else if (pattern.getPropertyName().equals("accountInventory")) {
			processAccountInventory(pattern);
		} else if (pattern.getPropertyName().equals("accountTitles")) {
			processAccountTitles(pattern);
		} else if (pattern.getPropertyName().equals("accountSkins")) {
			processAccountSkins(pattern);
		} else if (pattern.getPropertyName().equals("accountMinis")) {
			processAccountMinis(pattern);
		} else if (pattern.getPropertyName().equals("accountDyes")) {
			processAccountDyes(pattern);
		} else if (pattern.getPropertyName().equals("accountAchievements")) {
			processAccountAchievements(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof Account) {
			processAccount(pattern);
		}
		
		return this;
	}
	
	private void processAccountBank(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Bank processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountBank(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, AccountBank.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Account Filler Group :: Account Bank processor");
	}

	private void processAccountWallet(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Wallet processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountWallet(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, AccountWallet.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Wallet processor");
	}

	private void processAccountMaterials(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Materials processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountMaterials(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, AccountMaterials.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Materials processor");
	}

	private void processAccountInventory(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Inventory processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountInventory(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, AccountInventory.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Inventory processor");
	}

	private void processAccountTitles(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Titles processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountTitles(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Titles processor");
	}

	private void processAccountSkins(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Skins processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountSkins(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Skins processor");
	}

	private void processAccountMinis(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Minis processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountMinis(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Minis processor");
	}

	private void processAccountDyes(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Dyes processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountDyes(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Dyes processor");
	}

	private void processAccountAchievements(FillerArrayPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account Achievements processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setAccountAchievements(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, AccountAchievements.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account Achievements processor");
	}

	private void processAccount(FillerObjectPatternConfig pattern) {
		log.info("Accessing Account Filler Group :: Account processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), accessToken);
			
			this.account = jack.readValue(json.toString(), Account.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Account Filler Group :: Account processor");
	}

	public Account getAccount() {
		return account;
	}
	
	public List<AccountBank> getAccountBank() {
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
