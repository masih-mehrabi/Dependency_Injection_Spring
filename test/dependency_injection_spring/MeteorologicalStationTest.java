package dependency_injection_spring;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MeteorologicalStationTest {

	private static final int TEST_HUMIDITY = 42;
	private static final int TEST_WINDSPEED = 0;
	private static final int TEST_TEMPERATURE = 13;

	// Our SUT
	private static MeteorologicalStationController controller;
	private static ApplicationContext context;

	@BeforeAll
	static void setUp() {
		// Initializes the context using TestConfig as the base configuration
		context = new AnnotationConfigApplicationContext(TestConfig.class);
		// Gets an instance of the MeteorologicalStationController from the injector
		controller = context.getBean(MeteorologicalStationController.class);
	}

	 @Test
	 void testMeasure() {
		/**
		 * Note: In this case, we are testing measure() method of the controller,
		 which makes calls to getTemperatureData(), getWindspeedData(), getHumidityData() of IMeteorologicalSensorArray
		 * => In this test case, only the mock of IMeteorologicalSensorArray is needed.
	     * Note that EasyMock is used as the framework for mocking.
		 */

	    // This will then be our mocked collaborator
		 IMeteorologicalSensorArray sensorArrayMock =
				 context.getBean(MeteorologicalSensorArray.class);
		 
		 EasyMock.expect(sensorArrayMock.getWindspeedData()).andReturn(TEST_WINDSPEED);
		 EasyMock.expect(sensorArrayMock.getHumidityData()).andReturn(TEST_HUMIDITY);
		 EasyMock.expect(sensorArrayMock.getTemperatureData()).andReturn(TEST_TEMPERATURE);

		EasyMock.replay(sensorArrayMock);
		 controller.measure();
		 EasyMock.verify(sensorArrayMock);
	}
}
