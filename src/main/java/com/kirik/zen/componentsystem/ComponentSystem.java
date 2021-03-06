package com.kirik.zen.componentsystem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kirik.zen.core.Zen;

public class ComponentSystem {
	
	private final Map<String, Component> loadedComponents = new LinkedHashMap<>();
	public Zen plugin = Zen.instance;
	
	public void registerComponents(){
		//if the time ever comes for this to be important, it'll be here
	}
	
	public void registerCommands() {
		for (Entry<String, Component> entry : loadedComponents.entrySet()) {
			plugin.logToConsole("Registering commands for component '"+entry.getKey()+"'.");
			entry.getValue().registerCommands();
		}
	}

	public void registerListeners() {
		for (Entry<String, Component> entry : loadedComponents.entrySet()) {
			plugin.logToConsole("Registering listeners for component '"+entry.getKey()+"'.");
			entry.getValue().registerListeners();
		}
	}

	public Component getComponent(String name) {
		final Component component = loadedComponents.get(name);
		if (component == null)
			throw new RuntimeException("Tried to get component that wasn't loaded.");

		return component;
	}

}
