package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ColorLeather extends JsonModelFactoryMaster {

	private Double saturation;

	private Integer brightness;

	private Double contrast;

	private Double lightness;

	private Integer hue;

	private List<Integer> rgb;

	//Getters and setters

	public Double getSaturation() {
		return this.saturation;
	}

	public void setSaturation(Double val) {
		this.saturation = val;
	}

	public Integer getBrightness() {
		return this.brightness;
	}

	public void setBrightness(Integer val) {
		this.brightness = val;
	}

	public Double getContrast() {
		return this.contrast;
	}

	public void setContrast(Double val) {
		this.contrast = val;
	}

	public Double getLightness() {
		return this.lightness;
	}

	public void setLightness(Double val) {
		this.lightness = val;
	}

	public Integer getHue() {
		return this.hue;
	}

	public void setHue(Integer val) {
		this.hue = val;
	}

	public List<Integer> getRgb() {
		return this.rgb;
	}

	public void setRgb(List<Integer> val) {
		this.rgb = val;
	}

	public ColorLeather() {
		this.rgb = new ArrayList<Integer>();
	}

}
