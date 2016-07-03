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

/**
 * Account filler group
 * @author neman
 *
 */
public class AccountFillerGroup extends FillerGroup {
	private Account account;
	private GeneratedJsonArrays arrays;

	@Override
	public void getModels(SchedulerTypes schedulerType) {
		this.retriever = new JsonRetriever();
		this.helper = new FillerHelper();
		
		this.account = new Account();
		this.arrays = new GeneratedJsonArrays();
		
		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
		FillerGroupConfig[] groups = reader.getFillerGroups(FillerGroupTypes.ACCOUNT);
		LOG log = new LOG(this.getClass());
		
		log.info("Initializing Account Filler Group filler class");
		
		for (FillerPatternConfig fpc : groups[0].getFillerPatterns()) {
			if (fpc.getSchedulerType() == schedulerType || schedulerType == SchedulerTypes.ALL) {
				if (fpc instanceof FillerObjectPatternConfig) {
					FillerObjectPatternConfig object = (FillerObjectPatternConfig) fpc;
					if (object.getObject() instanceof Account) {
						processAccount(object, groups[0].getUrlSufix());
					}
				} else if (fpc instanceof FillerArrayPatternConfig) {
					//all arrays
					FillerArrayPatternConfig array = (FillerArrayPatternConfig) fpc;
					if (array.getPropertyName().equals("accountAchievements")) {
						processAccountAchievements(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountDyes")) {
						processAccountDyes(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountMinis")) {
						processAccountMinis(array,groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountSkins")) {
						processAccountSkins(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountTitles")) {
						processAccountTitles(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountBank")) {
						processAccountBank(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountInventory")) {
						processAccountInventory(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountMaterials")) {
						processAccountMaterials(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("accountWallet")) {
						processAccountWallet(array, groups[0].getUrlSufix());
					}
				}
			}
		}
	}

	private void processAccount(FillerObjectPatternConfig object, String urlSufix) {
		String fullUrl = urlSufix + object.getUrlPattern();
		try {
			//Get the object and declare a new Account object...
			JSONObject json = retriever.getParametarizedJsonObject(fullUrl, this.accessToken);

			//fill in object...
			this.account.setAccess(helper.getStringParam(json, "access"));
			this.account.setCommander(helper.getBoolParam(json, "commander"));
			this.account.setCreated(helper.getStringParam(json, "created"));
			this.account.setDailyAp(helper.getIntParam(json, "daily_ap"));
			this.account.setFractalLevel(helper.getIntParam(json, "fractal_level"));
			this.account.setGuilds(helper.getStringList(json, "guilds"));
			this.account.setId(helper.getStringParam(json, "id"));
			this.account.setMonthlyAp(helper.getIntParam(json, "monthly_ap"));
			this.account.setName(helper.getStringParam(json, "name"));
			this.account.setWorld(helper.getIntParam(json, "world"));
			this.account.setWvwRank(helper.getIntParam(json, "wvw_rank"));
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processAccountAchievements(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<AccountAchievements> list = this.arrays.getAccountAchievements();
			
			for (int i = 0; i < json.length(); i++) {
				JSONObject inner = json.getJSONObject(i);
				AccountAchievements aa = new AccountAchievements();
				
				aa.setBits(helper.getStringList(inner, "bits"));
				aa.setCurrent(helper.getIntParam(inner, "current"));
				aa.setDone(helper.getBoolParam(inner, "done"));
				aa.setId(helper.getIntParam(inner, "id"));
				aa.setMax(helper.getIntParam(inner, "max"));
				aa.setRepeated(helper.getIntParam(inner, "repeated"));
				aa.setUnlocked(helper.getBoolParam(inner, "unlocked"));
				
				list.add(aa);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountDyes(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<Integer> list = arrays.getAccountDyes();
			
			for (int i = 0; i < json.length(); i++) {
				list.add(json.getInt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountMinis(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<Integer> list = arrays.getAccountMinis();
			
			for (int i = 0; i < json.length(); i++) {
				list.add(json.getInt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountSkins(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<Integer> list = arrays.getAccountSkins();
			
			for (int i = 0; i < json.length(); i++) {
				list.add(json.getInt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountTitles(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<Integer> list = arrays.getAccountTitles();
			
			for (int i = 0; i < json.length(); i++) {
				list.add(json.getInt(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountBank(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<String> list = arrays.getAccountBank();
			
			for (int i = 0; i < json.length(); i++) {
				list.add(json.getString(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountInventory(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, this.accessToken);
			List<AccountInventory> list = arrays.getAccountInventory();
			
			for (int i = 0; i < json.length(); i++) {
				JSONObject inner = json.getJSONObject(i);
				AccountInventory ai = new AccountInventory();
				
				ai.setCount(helper.getIntParam(inner, "count"));
				ai.setBinding(helper.getStringParam(inner, "binding"));
				ai.setId(helper.getIntParam(inner, "id"));
				
				list.add(ai);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountMaterials(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, accessToken);
			List<AccountMaterials> list = arrays.getAccountMaterials();
			
			for (int i = 0; i < json.length(); i++) {
				JSONObject inner = json.getJSONObject(i);
				AccountMaterials am = new AccountMaterials();
				
				am.setCategory(helper.getIntParam(inner, "category"));
				am.setCount(helper.getIntParam(inner, "count"));
				am.setId(helper.getIntParam(inner, "id"));
				
				list.add(am);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
	}

	private void processAccountWallet(FillerArrayPatternConfig array, String urlSufix) {
		String fullUrl = urlSufix + array.getUrlPattern();
		try {
			JSONArray json = retriever.getParametarizedJsonArray(fullUrl, accessToken);
			List<AccountWallet> list = arrays.getAccountWallet();
			
			for (int i = 0; i < json.length(); i++) {
				JSONObject inner = json.getJSONObject(i);
				AccountWallet aw = new AccountWallet();
				
				aw.setId(helper.getIntParam(inner, "id"));
				aw.setValue(helper.getIntParam(inner, "value"));
				
				list.add(aw);
			}
		} catch (IOException | JSONException e) {
			e.printStackTrace();
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
