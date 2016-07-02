package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
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
import rs.edu.viser.services.filler.FillerHelper;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

/**
 * Account filler group
 * @author neman
 *
 */
public class AccountFillerGroup extends FillerGroup {
	private Account account;
	private GeneratedJsonArrays arrays;
//	private List<AccountAchievements> accountAchievements;
//	private List<String> accountBank;
//	private List<Integer> accountDyes;
//	private List<AccountInventory> accountInventory;
//	private List<AccountMaterials> accountMaterials;
//	private List<Integer> accountMinis;
//	private List<Integer> accountSkins;
//	private List<Integer> accountTitles;
//	private List<AccountWallet> accountWallet;

	@Override
	public void getModels(SchedulerTypes schedulerType) {
		this.retriever = new JsonRetriever();
		this.helper = new FillerHelper();
		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
		FillerGroupConfig[] groups = reader.getFillerGroups(FillerGroupTypes.ACCOUNT, schedulerType);
		System.out.println(groups.length);
	}
	
	public Account getAccount() {
		return account;
	}
	
	public List<String> getAccountBank() {
		return arrays.getAccountBank();
	}
	
	//TODO: ....

}
