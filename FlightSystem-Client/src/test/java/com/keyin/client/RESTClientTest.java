package com.keyin.client;

import com.keyin.domain.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
public class RESTClientTest {

    private static final String BASE_URL = "http://localhost:8080/api/airports";

    @Mock
    private RestTemplate restTemplate;  // Mocked dependency

    @InjectMocks
    private RESTClient restClient;  // System under test (SUT)

    @BeforeEach
    void setUp() {
        restClient = new RESTClient(restTemplate);
    }

    @Test
    public void testGetAllAirports_Success() {
        // Arrange: Mock API response
        List<Airport> expectedAirports = List.of(new Airport("YYZ", "Toronto Pearson"));
        ResponseEntity<Airport[]> responseEntity = new ResponseEntity<>(expectedAirports.toArray(new Airport[0]), HttpStatus.OK);

        when(restTemplate.getForEntity(BASE_URL, Airport[].class)).thenReturn(responseEntity);

        // Act: Call the method under test
        List<Airport> result = restClient.getAllAirports();

        // Assert: Verify the expected behavior
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("YYZ", result.get(0).getCode());
        assertEquals("Toronto Pearson", result.get(0).getName());

        // Verify: Ensure the mock API was called once
        verify(restTemplate, times(1)).getForEntity(BASE_URL, Airport[].class);
    }

    @Test
    public void testGetAllAirports_EmptyResponse() {
        // Arrange: Mock empty API response
        ResponseEntity<Airport[]> responseEntity = new ResponseEntity<>(new Airport[0], HttpStatus.OK);
        when(restTemplate.getForEntity(BASE_URL, Airport[].class)).thenReturn(responseEntity);

        // Act
        List<Airport> result = restClient.getAllAirports();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Verify API call
        verify(restTemplate, times(1)).getForEntity(BASE_URL, Airport[].class);
    }

    @Test
    public void testGetAllAirports_NullResponse() {
        // Arrange: Mock null API response
        when(restTemplate.getForEntity(BASE_URL, Airport[].class)).thenReturn(null);

        // Act
        List<Airport> result = restClient.getAllAirports();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Verify API call
        verify(restTemplate, times(1)).getForEntity(BASE_URL, Airport[].class);
    }
}
