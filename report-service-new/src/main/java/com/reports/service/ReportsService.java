package com.reports.service;

import com.reports.dto.UserReportDto;
import com.reports.dto.FlatReportDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ReportsService {

	private final RestTemplate restTemplate;

	@Value("${user.service.url}")
	private String userServiceUrl;

	@Value("${flat.service.url}")
	private String flatServiceUrl;

	public ReportsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<UserReportDto> getAllUserReports() {
		HttpHeaders headers = new HttpHeaders();
//        headers.setBasicAuth("admin", "admin123");  // Basic Auth
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<UserReportDto[]> response = restTemplate.exchange(userServiceUrl + "/getAll", HttpMethod.GET,
		        entity, UserReportDto[].class);
		
		if (ObjectUtils.isEmpty(response)) {
			return Collections.emptyList();
		}

		return Arrays.asList(response.getBody());
	}

	public List<FlatReportDto> getAllFlatReports() {
		// If flat-service is not secured:
		FlatReportDto[] flats = restTemplate.getForObject(flatServiceUrl, FlatReportDto[].class);
		
		if (ObjectUtils.isEmpty(flats)) {
			return Collections.emptyList();
		}
		return Arrays.asList(flats);
	}
}
