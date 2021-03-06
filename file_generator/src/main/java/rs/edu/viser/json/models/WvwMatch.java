package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/wvw/matches/2-1
 */
public class WvwMatch extends JsonModelFactoryMaster {

	private WvwMatchKills kills;

	private String startTime;

	private WvwMatchWorlds worlds;

	private List<WvwMatchMaps> maps;

	private WvwMatchScores scores;

	private String endTime;

	private String id;

	private WvwMatchAllWorlds allWorlds;

	private WvwMatchDeaths deaths;

	//Getters and setters

	public WvwMatchKills getKills() {
		return this.kills;
	}

	public void setKills(WvwMatchKills val) {
		this.kills = val;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String val) {
		this.startTime = val;
	}

	public WvwMatchWorlds getWorlds() {
		return this.worlds;
	}

	public void setWorlds(WvwMatchWorlds val) {
		this.worlds = val;
	}

	public List<WvwMatchMaps> getMaps() {
		return this.maps;
	}

	public void setMaps(List<WvwMatchMaps> val) {
		this.maps = val;
	}

	public WvwMatchScores getScores() {
		return this.scores;
	}

	public void setScores(WvwMatchScores val) {
		this.scores = val;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String val) {
		this.endTime = val;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String val) {
		this.id = val;
	}

	public WvwMatchAllWorlds getAllWorlds() {
		return this.allWorlds;
	}

	public void setAllWorlds(WvwMatchAllWorlds val) {
		this.allWorlds = val;
	}

	public WvwMatchDeaths getDeaths() {
		return this.deaths;
	}

	public void setDeaths(WvwMatchDeaths val) {
		this.deaths = val;
	}

	public WvwMatch() {
		this.maps = new ArrayList<WvwMatchMaps>();
	}

}
