package net.siphonofour.higurashi;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CICADA_NOON = registerSoundEvent("cicada_noon");
    public static final SoundEvent CICADA_DUSK = registerSoundEvent("cicada_dusk");
    public static final SoundEvent CICADA_DAWN = registerSoundEvent("cicada_dawn");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Higurashi.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        // Additional registrations if needed
    }
}
