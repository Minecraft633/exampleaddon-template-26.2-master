package com.mbvm.legaciesunited.entity;

import com.mbvm.legaciesunited.LegaciesUnited;
import com.mbvm.legaciesunited.entity.gem.PyriteEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AddonEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, LegaciesUnited.MOD_ID);

    //thorium is the id of the entity, Mob category is Creature and it's immune to fire and freezing
    public static final Supplier<EntityType<PyriteEntity>> PYRITE = ENTITY_TYPES.register("pyrite",
            () -> EntityType.Builder.of(PyriteEntity::new, MobCategory.CREATURE)
                    .sized(0.6f,1.85f)
                    .fireImmune()
                    .immuneTo(BlockTags.STRAY_IMMUNE_TO)
                    .build(getRK("pyrite")));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

    public static ResourceKey<EntityType<?>> getRK(String path){
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(LegaciesUnited.MOD_ID, path));
    }
}
