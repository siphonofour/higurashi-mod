package net.siphonofour.higurashi;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;


public class TimeEventHandler {
    private static long lastPlayedDay = -1;
    private static long lastDuskPlayedDay = -1;
    private static long lastDawnPlayedDay = -1;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(TimeEventHandler::onServerTick);
    }

    private static void onServerTick(MinecraftServer server) {
        server.getWorlds().forEach(world -> {
            long timeOfDay = world.getTimeOfDay() % 24000;
            long day = world.getTimeOfDay() / 24000;

            // Play the cicada sound once per day at 6000 ticks (afternoon)
            if (timeOfDay == 6000 && lastPlayedDay != day) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    world.playSound(
                            null,
                            player.getBlockPos(),
                            ModSounds.CICADA_NOON,
                            SoundCategory.AMBIENT,
                            0.2F,
                            1.0F
                    );
                }
                lastPlayedDay = day;
            }
            
            // Higurashi cicada at 12000 ticks (dusk)
            if (timeOfDay == 12000 && lastDuskPlayedDay != day) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    world.playSound(
                            null,
                            player.getBlockPos(),
                            ModSounds.CICADA_DUSK,
                            SoundCategory.AMBIENT,
                            0.2F,
                            1.0F
                    );
                }
                lastDuskPlayedDay = day;
            }

            // Play the cicada sound once per day at 1000 ticks (dawn)
            if (timeOfDay == 0 && lastDawnPlayedDay != day) {
                for (ServerPlayerEntity player : world.getPlayers()) {
                    world.playSound(
                            null,
                            player.getBlockPos(),
                            ModSounds.CICADA_DAWN,
                            SoundCategory.AMBIENT,
                            0.2F,
                            1.0F
                    );
                }
                lastDawnPlayedDay = day;
            }

        });
    }
}


