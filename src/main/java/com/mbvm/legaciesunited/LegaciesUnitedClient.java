package com.mbvm.legaciesunited;

import com.mbvm.legaciesunited.entity.AddonEntities;
import com.mbvm.legaciesunited.entity.gem.PyriteEntity;
import com.fodk.gemcolony.entity.client.model.GemModel;
import com.fodk.gemcolony.entity.client.renderer.GemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = LegaciesUnited.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = LegaciesUnited.MOD_ID, value = Dist.CLIENT)
public class LegaciesUnitedClient {

    public LegaciesUnitedClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        LegaciesUnited.LOGGER.info("HELLO FROM CLIENT SETUP");
        LegaciesUnited.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // registering the renderer
        // THORIUM is the entity we are registering the renderer for
        // the Gem Model is for ThoriumEntity
        // and the id is thorium, be careful to name you resources accordingly :
        // for example id = thorium so the resource folder should be :
        // model at : assets/exampleaddon/geckolib/models/entity
        // textures at :assets/exampleaddon/textures/entity/gem/thorium
        // the folder thorium should have thorium/outfits , thorium/insignia , thorium/placements , thorium/hairstyles (not necessary) and thorium/visor
        // the folder outfits should contain outfit_0 , outfit_1 etc
        // the folder insignia should contain insignia_0 , insignia_1 etc
        // the folder hairstyles should contain hair_0 , hair_1 etc
        // the folder visor should contain visor_0 , visor_1 etc
        // the folder placements should contain gem_0 , gem_1 etc
        // the placement order is :
        //    FOREHEAD,
        //    BACKHEAD,
        //    TOP_HEAD,
        //    EYE_R,
        //    EYE_L,
        //    CHEEK_R,
        //    CHEEK_L,
        //    EAR_R,
        //    EAR_L,
        //    NOSE,
        //    SHOULDER_R,
        //    SHOULDER_L,
        //    ARM_R,
        //    ARM_L,
        //    HAND_R,
        //    HAND_L,
        //    BACK,
        //    CHEST,
        //    NAVEL,
        //    THIGH_R,
        //    THIGH_L,
        //    LEG_R,
        //    LEG_L;
        // you also need 3 more textures,thorium_eyes, thorium_eyes_whites and thorium_skin, they are in the thorium folder
        // all the textures are already in for this example
        event.registerEntityRenderer(AddonEntities.PYRITE.get(), context -> new GemRenderer(context, new GemModel<PyriteEntity>(Identifier.fromNamespaceAndPath(LegaciesUnited.MOD_ID, "pyrite")), "pyrite", LegaciesUnited.MOD_ID) {});
    }
}
