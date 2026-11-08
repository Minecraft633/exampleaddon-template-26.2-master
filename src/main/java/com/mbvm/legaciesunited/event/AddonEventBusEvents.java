package com.mbvm.legaciesunited.event;

import com.mbvm.legaciesunited.LegaciesUnited;
import com.mbvm.legaciesunited.entity.AddonEntities;
import com.mbvm.legaciesunited.entity.gem.PyriteEntity;
import com.mbvm.legaciesunited.item.AddonItems;
import com.fodk.gemcolony.event.RegisterGemDefinitionsEvent;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.util.List;

@EventBusSubscriber(modid = LegaciesUnited.MOD_ID)
public class AddonEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        //creating thorium's attributes such as HP / DMG / Speed / Attack speed
        event.put(AddonEntities.PYRITE.get(), PyriteEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerGems(RegisterGemDefinitionsEvent event) {

        // adding Thorium to gem definitions, thorium is the Id, Thorium is the display name, THORIUM_GEM is the gem item, THORIUM is the entity
        // the values are conditions for gem injection :
        // Optimal temperature = 0.8, Optimal humidity = 1.2
        // The sigma values are tolerance for the optimal values : the smaller it is the more accurate the condition needs to be to get that gem
        // the higher it is the more forgiving a gem is
        // the last value is weight = 1, thats the rarity : so if 2 gems share the same cold/dry biomes, the one with higher weight is more likely
        event.RegisterGemDefinitionAndConditions(
                Identifier.fromNamespaceAndPath(LegaciesUnited.MOD_ID, "pyrite"),
                "Pyrite",
                List.of(AddonItems.PYRITE_GEM.get()),
                AddonEntities.PYRITE.get(),
                1f, 1.4f, 0.3f, 0.3f, 1.0f
        );


        // if you want to define a gem but not make it injectable use this version (remove the environemental conditions):
        /*event.RegisterGemDefinition(
                Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "thorium"),
                "Thorium",
                List.of(AddonItems.THORIUM_GEM.get()),
                AddonEntities.THORIUM.get()
        );*/
    }
}
