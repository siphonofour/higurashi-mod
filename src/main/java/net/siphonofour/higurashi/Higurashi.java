package net.siphonofour.higurashi;

import net.fabricmc.api.ModInitializer;

public class Higurashi implements ModInitializer {
	public static final String MOD_ID = "higurashi";

	@Override
	public void onInitialize() {
		ModSounds.register();
		TimeEventHandler.register();
	}
}


