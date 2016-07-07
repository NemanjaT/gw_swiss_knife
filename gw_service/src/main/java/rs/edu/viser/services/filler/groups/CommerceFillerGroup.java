package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.CommerceCurrentSellTransactions;
import rs.edu.viser.json.models.CommerceExchangeCoins;
import rs.edu.viser.json.models.CommerceExchangeGems;
import rs.edu.viser.json.models.CommerceListing;
import rs.edu.viser.json.models.CommercePastBuyTransactions;
import rs.edu.viser.json.models.CommercePastSellTransactions;
import rs.edu.viser.json.models.CommercePrice;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class CommerceFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private CommerceExchangeCoins commerceExchangeCoins;
	private CommerceExchangeGems commerceExchangeGems;
	private List<CommerceListing> commerceListingList;
	private List<CommercePrice> commercePriceList;

	public CommerceFillerGroup() {
		super(FillerGroupTypes.COMMERCE);

		this.arrays = new GeneratedJsonArrays();
		this.commerceExchangeCoins = new CommerceExchangeCoins();
		this.commerceExchangeGems = new CommerceExchangeGems();
		this.commerceListingList = new ArrayList<>();
		this.commercePriceList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("Commerce Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof CommerceExchangeCoins) {
			processCommerceExchangeCoins(pattern);
		} else if (pattern.getObject() instanceof CommerceExchangeGems) {
			processCommerceExchangeGems(pattern);
		} else if (pattern.getObject() instanceof CommerceListing) {
			processCommerceListing(pattern);
		} else if (pattern.getObject() instanceof CommercePrice) {
			processCommercePrice(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("commerceListings")) {
			processCommerceListings(pattern);
		} else if (pattern.getPropertyName().equals("commercePrices")) {
			processCommercePrices(pattern);
		} else if (pattern.getPropertyName().equals("commerceCurrentBuyTransactions")) {
			processCommerceCurrentBuyTransactions(pattern);
		} else if (pattern.getPropertyName().equals("commerceCurrentSellTransactions")) {
			processCommerceCurrentSellTransactions(pattern);
		} else if (pattern.getPropertyName().equals("commercePastBuyTransactions")) {
			processCommercePastBuyTransactions(pattern);
		} else if (pattern.getPropertyName().equals("commercePastSellTransactions")) {
			processCommercePastSellTransactions(pattern);
		}
		
		return this;
	}
	
	private void processCommerceListings(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Listings processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setCommerceListings(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Listings processor");
	}

	private void processCommercePrices(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Prices processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setCommercePrices(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Prices processor");
	}

	private void processCommerceCurrentBuyTransactions(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Current Buy Transactions processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setCommerceCurrentBuyTransactions(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, Object.class))); //TODO: GW-0001
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Current Buy Transactions processor");
	}

	private void processCommerceCurrentSellTransactions(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Current Sell Transactions processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setCommerceCurrentSellTransactions(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, 
							CommerceCurrentSellTransactions.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Current Sell Transactions processor");
	}

	private void processCommercePastBuyTransactions(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Past Buy Transactions processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setCommercePastBuyTransactions(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, 
							CommercePastBuyTransactions.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Past Buy Transactions processor");
	}

	private void processCommercePastSellTransactions(FillerArrayPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Past Sell Transactions processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setCommercePastSellTransactions(jack.readValue(json.toString(), 
					jack.getTypeFactory().constructCollectionType(List.class, 
							CommercePastSellTransactions.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Commerce Filler Group :: Commerce Past Sell Transactions processor");
	}

	private void processCommerceExchangeCoins(FillerObjectPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Daily Commerce Exchange Coins processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), String.valueOf(10000));
		
			this.commerceExchangeCoins = jack.readValue(json.toString(), CommerceExchangeCoins.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Commerce Filler Group :: Daily Commerce Exchange Coins processor");
	}

	private void processCommerceExchangeGems(FillerObjectPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Daily Commerce Exchange Gems processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), String.valueOf(10000));
		
			this.commerceExchangeGems = jack.readValue(json.toString(), CommerceExchangeGems.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Commerce Filler Group :: Daily Commerce Exchange Gems processor");
	}

	private void processCommerceListing(FillerObjectPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Listing processor");
		try {
			for (Integer i : arrays.getCommerceListings()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.commerceListingList.add(jack.readValue(json.toString(), CommerceListing.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Commerce Filler Group :: Commerce Listing processor");
	}

	private void processCommercePrice(FillerObjectPatternConfig pattern) {
		log.info("Accessing Commerce Filler Group :: Commerce Price processor");
		try {
			for (Integer i : arrays.getCommercePrices()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.commercePriceList.add(jack.readValue(json.toString(), CommercePrice.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Commerce Filler Group :: Commerce Price processor");
	}
	
	public List<Integer> getCommerceListings() {
		return this.arrays.getCommerceListings();
	}
	
	public List<Integer> getCommercePrices() {
		return this.arrays.getCommercePrices();
	}
	
	public List<CommerceListing> getCommerceListingList() {
		return this.commerceListingList;
	}
	
	public List<CommercePrice> getCommercePriceList() {
		return this.commercePriceList;
	}
	
	public List<CommerceCurrentSellTransactions> getCommerceCurrentSellTransactions() {
		return this.arrays.getCommerceCurrentSellTransactions();
	}
	
	public List<Object> getCommerceCurrentBuyTransactions() { //TODO: GW-0001
		return this.arrays.getCommerceCurrentBuyTransactions();
	}
	
	public List<CommercePastBuyTransactions> getCommercePastBuyTransactions() {
		return this.arrays.getCommercePastBuyTransactions();
	}
	
	public List<CommercePastSellTransactions> getCommercePastSellTransactions() {
		return this.arrays.getCommercePastSellTransactions();
	}
	
	public CommerceExchangeCoins getCommerceExchangeCoins() {
		return this.commerceExchangeCoins;
	}
	
	public CommerceExchangeGems getCommerceExchangeGems() {
		return this.commerceExchangeGems;
	}
}
