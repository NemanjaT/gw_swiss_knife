package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.Build;
import rs.edu.viser.json.models.File;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class SystemFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private Build build;
	private List<File> fileList;

	public SystemFillerGroup() {
		super(FillerGroupTypes.SYSTEM);
		
		this.arrays = new GeneratedJsonArrays();
		this.build = new Build();
		this.fileList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("System Filler Group :: Achievement Group processor");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof Build) {
			processBuild(pattern);
		} else if (pattern.getObject() instanceof File) {
			processFile(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("files")) {
			processFiles(pattern);
		}
		
		return this;
	}
	
	private void processFiles(FillerArrayPatternConfig pattern) {
		log.info("Accessing System Filler Group :: Files processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setFiles(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Account Filler Group :: Files processor");
	}

	private void processBuild(FillerObjectPatternConfig pattern) {
		log.info("Accessing System Filler Group :: Build processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern());
		
			this.build = jack.readValue(json.toString(), Build.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Account Filler Group :: Build processor");
	}

	private void processFile(FillerObjectPatternConfig pattern) {
		log.info("Accessing System Filler Group :: File processor");
		try {
			for (String i : arrays.getFiles()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.fileList.add(jack.readValue(json.toString(), File.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Account Filler Group :: File processor");
	}
	
	public List<String> getFiles() {
		return arrays.getFiles();
	}

	public Build getBuild() {
		return build;
	}

	public List<File> getFileList() {
		return fileList;
	}

}
