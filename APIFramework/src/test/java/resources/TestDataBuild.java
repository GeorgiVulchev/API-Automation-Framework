package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload() {
		AddPlace addPlace = new AddPlace();
		Location location = new Location();
		location.setLat(-38.383404);
		location.setLng(-33.427362);

		List<String> listOfTypes = new ArrayList<String>();
		listOfTypes.add("shoe park");
		listOfTypes.add("shop");

		addPlace.setAccuracy(50);
		addPlace.setAddress("address15");
		addPlace.setLanguage("Bulgarian");
		addPlace.setPhone_number("1234567810");
		addPlace.setWebsite("https://website.com");
		addPlace.setName("George");
		addPlace.setTypes(listOfTypes);
		addPlace.setLocation(location);
		
		return addPlace;
	}
}
