package net.csco.mod.block;

import net.minecraft.world.level.block.Blocks;
import net.csco.mod.TutorialMod;
import net.csco.mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * ModBlocks.java
 *
 * Author: Victor
 * Purpose: This class is responsible for creating and registering custom blocks in the Minecraft mod.
 *          It also handles the registration of corresponding items for each block.
 *
 * Description:
 * This class defines the blocks used within the mod, such as the Alexandrite Block and Raw Alexandrite Block.
 * It utilizes Forge's Deferred Register to ensure proper registration of blocks and items at the correct
 * stage of the mod loading process.
 *
 * Date: November 6, 2024
 *
 * License: NA
 *
 * Dependencies:
 * - Forge 1.x.x.x
 * - Minecraft 1.x.x
 * - ModItems (For block item registration)
 */




/**
 * A utility class for registering blocks within the Minecraft mod.
 * This class handles the registration of custom blocks and their corresponding item representations.
 */
public class ModBlocks {

    /**
     * A DeferredRegister for registering {@link Block} objects with Forge's registry.
     * It is used to delay the registration of blocks until the correct time in the mod loading process.
     */
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    /**
     * A {@link RegistryObject} representing the Alexandrite Block. It is a custom block added to the mod.
     */
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    /**
     * A {@link RegistryObject} representing the Raw Alexandrite Block. It is another custom block added to the mod.
     */
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    /**
     * Registers a block with the provided name and supplier. Also registers a corresponding item for the block.
     *
     * @param <T>   The type of the block to be registered.
     * @param name  The name of the block to register.
     * @param block A supplier providing the block instance.
     * @return A {@link RegistryObject} representing the registered block.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Registers a corresponding block item for the provided block.
     *
     * @param name  The name of the block item to register.
     * @param block The block to associate with the block item.
     * @return A {@link RegistryObject} representing the registered block item.
     */
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Registers all the blocks in this class with the given event bus. This is necessary to ensure that the
     * registration process happens during the mod's initialization.
     *
     * @param eventBus The event bus to register the blocks with.
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
