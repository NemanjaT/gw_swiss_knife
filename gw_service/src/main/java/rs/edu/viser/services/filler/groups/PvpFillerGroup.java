package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.PvpAmulet;
import rs.edu.viser.json.models.PvpGame;
import rs.edu.viser.json.models.PvpSeason;
import rs.edu.viser.json.models.PvpStandings;
import rs.edu.viser.json.models.PvpStats;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class PvpFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private PvpStats pvpStats;
	private List<PvpGame> pvpGameList;
	private List<PvpAmulet> pvpAmuletList;
	private List<PvpSeason> pvpSeasonList;

	public PvpFillerGroup() {
		super(FillerGroupTypes.PVP);
		
		this.arrays = new GeneratedJsonArrays();
		this.pvpStats = new PvpStats();
		this.pvpGameList = new ArrayList<>();
		this.pvpAmuletList = new ArrayList<>();
		this.pvpSeasonList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("Pvp Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof PvpStats) {
			processPvpStats(pattern);
		} else if (pattern.getObject() instanceof PvpGame) {
			processPvpGame(pattern);
		} else if (pattern.getObject() instanceof PvpAmulet) {
			processPvpAmulet(pattern);
		} else if (pattern.getObject() instanceof PvpSeason) {
			processPvpSeason(pattern);
		}

		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("pvpGames")) {
			processPvpGames(pattern);
		} else if (pattern.getPropertyName().equals("pvpAmulets")) {
			processPvpAmulets(pattern);
		} else if (pattern.getPropertyName().equals("pvpStandings")) {
			processPvpStandings(pattern);
		} else if (pattern.getPropertyName().equals("pvpSeasons")) {
			oricessPvpSeasons(pattern);
		}

		return this;
	}
	
	private void processPvpGames(FillerArrayPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Games processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setPvpGames(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Games processor");
	}

	private void processPvpAmulets(FillerArrayPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Amulets processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setPvpAmulets(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Amulets processor");
	}

	private void processPvpStandings(FillerArrayPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Standings processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setPvpStandings(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, PvpStandings.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Standings processor");
	}

	private void oricessPvpSeasons(FillerArrayPatternConfig pattern) {
		log.info("Accessing Pvp Seasons Group :: Pvp Seasons processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setPvpSeasons(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Standings processor");
	}

	private void processPvpStats(FillerObjectPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Stats processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), accessToken);
		
			this.pvpStats = jack.readValue(json.toString(), PvpStats.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Stats processor");
	}

	private void processPvpGame(FillerObjectPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Game processor");
		try {
			for (String i : arrays.getPvpGames()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
			
				this.pvpGameList.add(jack.readValue(json.toString(), PvpGame.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Game processor");
	}

	private void processPvpAmulet(FillerObjectPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Amulet processor");
		try {
			for (Integer i : arrays.getPvpAmulets()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.pvpAmuletList.add(jack.readValue(json.toString(), PvpAmulet.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Amulet processor");
	}

	private void processPvpSeason(FillerObjectPatternConfig pattern) {
		log.info("Accessing Pvp Filler Group :: Pvp Season processor");
		try {
			for (String i : arrays.getPvpSeasons()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.pvpSeasonList.add(jack.readValue(json.toString(), PvpSeason.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Pvp Filler Group :: Pvp Season processor");
	}
	
	public List<String> getPvpGames() {
		return arrays.getPvpGames();
	}
	
	public List<Integer> getPvpAmulets() {
		return arrays.getPvpAmulets();
	}
	
	public List<String> getPvpSeason() {
		return arrays.getPvpSeasons();
	}
	
	public List<PvpStandings> getPvpStandings() {
		return arrays.getPvpStandings();
	}
	
	public PvpStats getPvpStats() {
		return pvpStats;
	}

	public List<PvpGame> getPvpGameList() {
		return pvpGameList;
	}

	public List<PvpAmulet> getPvpAmuletList() {
		return pvpAmuletList;
	}

	public List<PvpSeason> getPvpSeasonList() {
		return pvpSeasonList;
	}

}
