package com.mbvm.legaciesunited.entity.gem;

import com.mbvm.legaciesunited.item.AddonItems;
import com.fodk.gemcolony.entity.custom.gem.ability.GemAbility;
import com.fodk.gemcolony.entity.custom.gem.base.GemEntity;
import com.fodk.gemcolony.util.ColorUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import java.awt.*;

public class PyriteEntity extends GemEntity {

    private static final Color darkSkin = new Color(172, 134, 53);
    private static final Color lightSkin = new Color(255, 237, 156);
    private static final Color darkOutfit = new Color(122, 90, 45);
    private static final Color lightOutfit = new Color(211, 167, 110);
    private static final Color darkInsignia = new Color(147, 98, 35);
    private static final Color lightInsignia = new Color(255, 225, 78);
    private static final Color darkHair = new Color(99, 67, 28);
    private static final Color lightHair = new Color(211, 164, 105);
    private static final Color darkVisor = new Color(195, 129, 63);
    private static final Color lightVisor = new Color(255, 166, 103);

    public PyriteEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.MOVEMENT_SPEED, 0.26D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.ATTACK_SPEED, 1.4D);
    }

    @Override
    public double getBaseMaxHealth() {
        return 40;
    }

    @Override
    public double getBaseAttackDamage() {
        return 0;
    }

    @Override
    public double getBaseMovementSpeed() {
        return 0.32;
    }

    @Override
    public double getBaseAttackSpeed() {
        return 1.4;
    }

    @Override
    public Item getGemItem() {
        return AddonItems.PYRITE_GEM.get();
    }

    @Override
    public int getMaxOutfits() {
        return 3;
    }

    @Override
    public int getMaxInsignias() {
        return 3;
    }

    @Override
    public int getMaxHairstyles() {
        return 4;
    }

    @Override
    public int getMaxMarkings() {
        return 0;
    }

    @Override
    public int getMaxVisors() {
        return 1;
    }

    @Override
    public Color generateGemColor() {
        return ColorUtil.lerpColor(lightSkin, darkSkin, random.nextFloat());
    }

    @Override
    public Color generateOutfitColor() {
        return ColorUtil.lerpColor(lightOutfit, darkOutfit, random.nextFloat());
    }

    @Override
    public Color generateInsigniaColor() {
        return ColorUtil.lerpColor(lightInsignia, darkInsignia, random.nextFloat());
    }

    @Override
    public Color generateHairColor() {
        return ColorUtil.lerpColor(lightHair, darkHair, random.nextFloat());
    }

    @Override
    public Color generateMarkingsColor() {
        return Color.black;
    }

    @Override
    public Color generateVisorColor() {
        return ColorUtil.lerpColor(lightVisor, darkVisor, random.nextFloat());
    }

    @Override
    protected int getInventorySize() {
        float qualityModifier = entityData.get(QUALITY) == 0 ? 0.5f : entityData.get(QUALITY) == 2 ? 1.5f : 1f;
        return (int) (30 * qualityModifier);
    }

    //3 MIN
    @Override
    public int getReformTime(){
        float modifier = entityData.get(QUALITY) == 0 ? 0.9f : entityData.get(QUALITY) == 1 ? 1f : 1.1f;
        return (int)(50f * modifier);
    }

    @Override
    public String getGemTypeName() {
        return "Pyrite";
    }

    @Override
    protected void initializeAbilities() {
        addAbility(GemAbility.PYROKINESIS);
    }

    @Override
    public float getBaseModelSize() {
        return 1.2f;
    }
}
