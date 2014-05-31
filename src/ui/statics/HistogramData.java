package ui.statics;

public class HistogramData {
	private String type,belong;
	float value;
	HistogramData(float value,String type,String belong){
		this.type = type;
		this.belong = belong;
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public String getBelong() {
		return belong;
	}
	public float getValue() {
		return value;
	}
}
