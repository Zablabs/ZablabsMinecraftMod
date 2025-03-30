package net.zablabs.testmod.Block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.zablabs.testmod.ExampleMod;
import net.zablabs.testmod.Item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

            public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .strength(4f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    ));



        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }


        private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
            ModItems.ITEMS .register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }


        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
}
