package com.mbvm.legaciesunited.datagen;

import com.mbvm.legaciesunited.LegaciesUnited;
import com.mbvm.legaciesunited.item.AddonItems;
import com.fodk.gemcolony.GemColony;
import com.fodk.gemcolony.data.ModDataComponents;
import com.fodk.gemcolony.item.BubbleColorTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class AddonModelProvider extends ModelProvider {

    public AddonModelProvider(PackOutput output) {
        super(output, LegaciesUnited.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        //generate the gem item model
        generateGemItem(AddonItems.PYRITE_GEM.get(), itemModels);
    }

    //a helper method to generate a gem item model and its bubbled variant
    private void generateGemItem(Item item, ItemModelGenerators itemModels) {
        var gemModel = ModelTemplates.FLAT_ITEM.create(
                item,
                TextureMapping.layer0(
                        new Material(Identifier.fromNamespaceAndPath(LegaciesUnited.MOD_ID, "item/" + BuiltInRegistries.ITEM.getKey(item).getPath()))
                ),
                itemModels.modelOutput
        );

        var bubbleModel = ModelTemplates.FLAT_ITEM.create(
                ModelLocationUtils.getModelLocation(item, "_bubble"),
                TextureMapping.layer0(
                        new Material(Identifier.fromNamespaceAndPath(GemColony.MOD_ID, "item/gem_bubble"))
                ),
                itemModels.modelOutput
        );

        itemModels.itemModelOutput.accept(
                item,
                ItemModelUtils.conditional(
                        ItemModelUtils.hasComponent(ModDataComponents.BUBBLED.get()),
                        ItemModelUtils.composite(
                                ItemModelUtils.plainModel(gemModel),
                                ItemModelUtils.tintedModel(
                                        ModelLocationUtils.getModelLocation(item, "_bubble"),
                                        BubbleColorTintSource.INSTANCE
                                )
                        ),
                        ItemModelUtils.plainModel(gemModel)
                )
        );
    }
}
