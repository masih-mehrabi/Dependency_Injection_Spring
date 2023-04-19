package dependency_injection_spring;

import org.springframework.context.annotation.Bean;

public class AppConfig {
	@Bean
	public MeteorologicalStationController controller() {
		return new MeteorologicalStationController();
	}

	@Bean
	public IMeteorologicalStationGUI gui() {
		return new MeteorologicalStationGUI();
	}
	
	@Bean
	public IMeteorologicalSensorArray sensorArray() {
		return new MeteorologicalSensorArray();
	}
	@Bean
	public IMeteorologicalFileStorage storage() {
		return new MeteorologicalFileStorage();
	}

}
