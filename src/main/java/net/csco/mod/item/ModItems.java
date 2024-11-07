package net.csco.mod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.csco.mod.TutorialMod;

/**
 * ModItems.java
 *
 * Author: Victor
 * Purpose: This class is responsible for creating and registering custom items in the Minecraft mod.
 *          It handles the registration of items such as Alexandrite and Raw Alexandrite.
 *
 * Description:
 * This class defines and registers custom items used within the mod. These items are registered with
 * Forge's Deferred Register, ensuring that they are properly added to the game at the correct stage of
 * the mod loading process.
 *
 * Date: November 6, 2024
 *
 * License: NA
 *
 * Dependencies:
 * - Forge 1.x.x.x
 * - Minecraft 1.x.x
 */
public class ModItems {

    /**
     * A DeferredRegister for registering {@link Item} objects with Forge's registry.
     * This is used to delay the registration of items until the correct time in the mod loading process.
     */
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    /**
     * A {@link RegistryObject} representing the Alexandrite item. It is a custom item added to the mod.
     */
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    /**
     * A {@link RegistryObject} representing the Raw Alexandrite item. It is another custom item added to the mod.
     */
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    /**
     * Registers all the items in this class with the given event bus. This ensures that the items are
     * registered during the mod's initialization process.
     *
     * @param eventBus The event bus to register the items with.
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
