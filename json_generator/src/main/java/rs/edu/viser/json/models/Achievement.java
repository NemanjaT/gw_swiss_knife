package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/achievements/251
 */
public class Achievement extends JsonModelFactoryMaster {

	private List<Integer> prerequisites;

	private String lockedText;

	private List<AchievementTiers> achievementTiers;

	private String name;

	private List<String> flags;

	private String description;

	private Integer id;

	private String requirement;

	private String type;

	private List<AchievementRewards> achievementRewards;

}
