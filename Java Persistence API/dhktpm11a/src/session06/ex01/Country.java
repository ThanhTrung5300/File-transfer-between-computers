package session06.ex01;

public class Country {
	private String name;
	private String code;
	private String capital;
	private String province;
	private Double area;
	private Integer population;
	public Country() {
	}
	public Country(String name, String code, String capital, String province, Double area, Integer population) {
		this.name = name;
		this.code = code;
		this.capital = capital;
		this.province = province;
		this.area = area;
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", code=" + code + ", capital=" + capital + ", province=" + province
				+ ", area=" + area + ", population=" + population + "]";
	}
	
	

}
