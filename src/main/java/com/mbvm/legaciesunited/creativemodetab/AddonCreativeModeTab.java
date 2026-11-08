package com.mbvm.legaciesunited.creativemodetab;

import com.mbvm.legaciesunited.LegaciesUnited;
import com.mbvm.legaciesunited.item.AddonItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AddonCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegaciesUnited.MOD_ID);

    public static final Supplier<CreativeModeTab> LEGACIES_UNITED_TAB = CREATIVE_MODE_TABS.register("legacies_united_tab",
            () -> CreativeModeTab.builder()

                    //set the tab icon to an item
                    .icon(() -> new ItemStack(AddonItems.PYRITE_GEM.get()))
                    .title(Component.translatable("creativetab.legaciesunited.legacies_united_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //output.accept(item) to add more items to your creative tab
                        output.accept(AddonItems.PYRITE_GEM);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
