package dev.sgpapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sgpapi.service.InitialiserDonneesService;

@Component
public class StartUpAppListener {
	@Autowired
	private InitialiserDonneesService initialiserDonneesService;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		initialiserDonneesService.initialiser();
	}
}
