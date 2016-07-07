package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.EmblemBackground;
import rs.edu.viser.json.models.EmblemForeground;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.Quaggan;
import rs.edu.viser.json.models.Title;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class DecorativeFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private List<EmblemForeground> emblemForegroundList;
	private List<EmblemBackground> emblemBackgroundList;
	private List<Quaggan> quagganList;
	private List<Title> titleList;

	public DecorativeFillerGroup() {
		super(FillerGroupTypes.DECORATIVE);

		this.arrays = new GeneratedJsonArrays();
		this.emblemBackgroundList = new ArrayList<>();
		this.emblemForegroundList = new ArrayList<>();
		this.quagganList = new ArrayList<>();
		this.titleList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(SchedulerTypes.ALL);
		
		log.info("Decorative Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof EmblemBackground) {
			processEmblemBackground(pattern);
		} else if (pattern.getObject() instanceof EmblemForeground) {
			processEmblemForeground(pattern);
		} else if (pattern.getObject() instanceof Quaggan) {
			processQuaggan(pattern);
		} else if (pattern.getObject() instanceof Title) {
			processTitle(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("emblemBackgrounds")) {
			processEmblemBackgrounds(pattern);
		} else if (pattern.getPropertyName().equals("emblemForegrounds")) {
			processEmblemForegrounds(pattern);
		} else if (pattern.getPropertyName().equals("quaggans")) {
			processQuaggans(pattern);
		} else if (pattern.getPropertyName().equals("titles")) {
			processTitles(pattern);
		}
		
		return this;
	}
	
	private void processEmblemBackgrounds(FillerArrayPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Emblem Backgrounds processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setEmblemBackgrounds(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Emblem Backgrounds processor");
	}

	private void processEmblemForegrounds(FillerArrayPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Emblem Foregrounds processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setEmblemForegrounds(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Emblem Foregrounds processor");
	}

	private void processQuaggans(FillerArrayPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Quaggans processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setQuaggans(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Quaggans processor");
	}

	private void processTitles(FillerArrayPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Titles processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setTitles(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Titles processor");
	}

	private void processEmblemBackground(FillerObjectPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Emblem Background processor");
		try {
			for (Integer i : arrays.getEmblemBackgrounds()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.emblemBackgroundList.add(jack.readValue(json.toString(), EmblemBackground.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Emblem Background processor");
	}

	private void processEmblemForeground(FillerObjectPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Emblem Foreground processor");
		try {
			for (Integer i : arrays.getEmblemForegrounds()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.emblemForegroundList.add(jack.readValue(json.toString(), EmblemForeground.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Emblem Foreground processor");
	}

	private void processQuaggan(FillerObjectPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Quaggan processor");
		try {
			for (String i : arrays.getQuaggans()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.quagganList.add(jack.readValue(json.toString(), Quaggan.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Quaggan processor");
	}

	private void processTitle(FillerObjectPatternConfig pattern) {
		log.info("Accessing Decorative Filler Group :: Title processor");
		try {
			for (Integer i : arrays.getTitles()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.titleList.add(jack.readValue(json.toString(), Title.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Decorative Filler Group :: Title processor");
	}
	
	public List<Integer> getEmblemBackgrounds() {
		return this.arrays.getEmblemBackgrounds();
	}
	
	public List<Integer> getEmblemForegrounds() {
		return this.arrays.getEmblemForegrounds();
	}
	
	public List<String> getQuaggans() {
		return this.arrays.getQuaggans();
	}
	
	public List<Integer> getTitles() {
		return this.arrays.getTitles();
	}
	
	public List<EmblemBackground> getEmblemBackgroundList() {
		return this.emblemBackgroundList;
	}
	
	public List<EmblemForeground> getEmblemForegroundList() {
		return this.emblemForegroundList;
	}
	
	public List<Quaggan> getQuagganList() { 
		return this.quagganList;
	}
	
	public List<Title> getTitleList() {
		return this.titleList;
	}

}
