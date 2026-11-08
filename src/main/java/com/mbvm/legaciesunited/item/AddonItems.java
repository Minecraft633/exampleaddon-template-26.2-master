package com.mbvm.legaciesunited.item;

import com.mbvm.legaciesunited.LegaciesUnited;
import com.mbvm.legaciesunited.entity.AddonEntities;
import com.fodk.gemcolony.item.custom.GemItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AddonItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LegaciesUnited.MOD_ID);

    //thorium_gem is the id for the registered item, Name = Thorium is needed for display and entity name
    public static final DeferredItem<Item> PYRITE_GEM = ITEMS.registerItem("pyrite_gem",
            properties -> new GemItem(properties, "Pyrite", AddonEntities.PYRITE.get()));

    //get resource key for item tags
    public static ResourceKey<Item> getRK(DeferredItem deferredItem){
        return BuiltInRegistries.ITEM.getResourceKey(deferredItem.asItem()).get();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
