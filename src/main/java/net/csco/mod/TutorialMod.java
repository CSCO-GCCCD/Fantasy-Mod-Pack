package net.csco.mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.csco.mod.block.ModBlocks;
import net.csco.mod.item.ModItems;
import org.slf4j.Logger;

/**
 * TutorialMod.java
 *
 * Author: Victor
 * Purpose: Initialize and manage custom blocks, items, and creative mode tab contents for the Minecraft mod.
 *          Handles mod registration, server setup, and client-side configuration.
 *
 * Description:
 * This class contains the main entry point for the mod, initializing and registering custom blocks, items,
 * and creative tabs using Forge event listeners. It also manages server and client-side initialization.
 *
 * Date: November 6, 2024
 *
 * License: NA
 *
 * Dependencies:
 * - Forge 1.x.x.x
 * - Minecraft 1.x.x
 */
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {

    /**
     * The mod ID used for referencing the mod in various Forge systems.
     */
    public static final String MOD_ID = "tutorialmod";

    /**
     * The logger used for logging messages from the mod.
     */
    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * The constructor for the TutorialMod class. This method is called during mod initialization.
     * It registers event listeners for both common and client-side events.
     */
    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the mod's blocks and items
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        // Register the mod's event bus to listen for common setup and creative mode tab events
        MinecraftForge.EVENT_BUS.register(this);

        // Add items to creative mode tabs
        modEventBus.addListener(this::addCreative);
    }

    /**
     * Common setup method for mod initialization. This method is empty but can be used for server-side logic.
     *
     * @param event The event that can be used for mod initialization.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // This method is currently empty, but it can be expanded in the future.
    }

    /**
     * Adds custom items and blocks to the appropriate creative mode tabs.
     * Specifically, this adds Alexandrite items and blocks to the ingredients and building blocks tabs, respectively.
     *
     * @param event The event object used to modify creative mode tab contents.
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_ALEXANDRITE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        }
    }

    /**
     * Method called when the server is starting. It is currently empty but can be expanded for server-side logic.
     *
     * @param event The server starting event.
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // This method is currently empty, but can be used for server-side logic.
    }

    /**
     * Client-side event listener for setting up client-specific functionality. This method is registered automatically
     * by the mod event bus and handles client-side setup like rendering and input.
     */
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        /**
         * Client-side setup method for initializing client-specific features, such as rendering.
         *
         * @param event The event for setting up client-side functionality.
         */
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // This method is currently empty but can be expanded for client-side setup.
        }
    }
}
