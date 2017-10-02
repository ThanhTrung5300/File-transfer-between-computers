package session06.ex01;

import org.bson.Document;

import com.mongodb.async.SingleResultCallback;

public class XulyKetquaTruyVan implements SingleResultCallback<Document>{
	private Country country;

	@Override
	public void onResult(Document result, Throwable t) {
		if(result!=null) {
			//if(t.containsKey("Name")) ???????
			String name = result.get("Name").toString();
			String code = result.get("Code").toString();
			String capital = result.get("Capital").toString();
			String province = result.get("Province").toString();
			
			String x = result.get("Area").toString();
			double y=-1;
			try{y = Double.parseDouble(x);}catch(Exception ex) {y=-1;};
			
			Double area= y;
			Integer population=result.getInteger("Population");
			country=new Country(name, code, capital, province, area, population);
		}		
	}

	public Country getCountry() {
		return country;
	}

	
}
