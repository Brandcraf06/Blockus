package com.brand.blockus.config;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import me.sargunvohra.mcmods.autoconfig1.annotation.Config;

@Config(name = "blockus")
public class BlockusConfig implements ConfigData {
    public boolean enableNetherStarsBlock = true;
	public boolean enableLimestoneGeneration = true;
	public boolean enableMarbleGeneration = true;
	public boolean enableBluestoneGeneration = true;
	public boolean enableLoveBlockParticles = true;
	public boolean enableAsphaltEffect = true;
	public boolean enableNetherStarsBlockEffects = true;
	public int AsphaltSpeedAmplifier = 4;

};
