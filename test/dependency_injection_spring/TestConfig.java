package dependency_injection_spring;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;

public class TestConfig {
	@Bean
	public MeteorologicalStationController controller() {
		return new MeteorologicalStationController();
	}

	@Bean
	public IMeteorologicalStationGUI gui() {
		return EasyMock.createMock(MeteorologicalStationGUI.class);
	}
	
	
	@Bean
	public IMeteorologicalSensorArray sensorArrayMock() {
		return EasyMock.createMock(MeteorologicalSensorArray.class);
	}
	
	@Bean
	public IMeteorologicalFileStorage fileStorageMock() {
		return EasyMock.createMock(MeteorologicalFileStorage.class);
	}
}
