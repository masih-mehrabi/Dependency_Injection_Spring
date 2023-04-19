package dependency_injection_spring;

import java.io.IOException;

public interface IMeteorologicalFileStorage {

	void setTemperature(int temperature);

	void setWindspeed(int windspeed);

	void setHumidity(int humidity);

	void save() throws IOException;
}
