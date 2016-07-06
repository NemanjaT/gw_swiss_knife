package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.json.models.Account;
import rs.edu.viser.json.models.AccountAchievements;
import rs.edu.viser.json.models.AccountInventory;
import rs.edu.viser.json.models.AccountMaterials;
import rs.edu.viser.json.models.AccountWallet;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.FillerHelper;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
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
	
	private String url;
	private LOG log;
	
	public AccountFillerGroup() {
		this.account = new Account();
		this.arrays = new GeneratedJsonArrays();
		
		this.reader = FillerConfigReader.getFillerConfigReader();
		this.helper = new FillerHelper();
		this.retriever = new JsonRetriever();
		this.jack = new JacksonModeler();
		
		this.log = new LOG(this.getClass());
	} 

	@Override
	public void getModels(SchedulerTypes schedulerType) {
		FillerGroupConfig fillerGroup = reader.getFillerGroups(FillerGroupTypes.ACCOUNT)[0];
		log.info("Initializing Account Filler Group");
		
		//getting the filler patterns. . .
		FillerPatternConfig[] patternGroup = fillerGroup.getFillerPatterns();
		this.url = fillerGroup.getUrlSufix();
		
		//sorting patterns so all arrays are called in first. . .
		patternGroup = helper.orderFillerPatternConfigs(patternGroup);
		
		this.readThroughPatterns(patternGroup, schedulerType);
		
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
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
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
