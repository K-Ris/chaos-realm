package at.chaotistin.chaosrealm.world.structures;

import at.chaotistin.chaosrealm.registries.MobEntities;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.function.Function;

public class SwampHutTestStructure extends ScatteredStructure<NoFeatureConfig>  {
    private static final List<Biome.SpawnListEntry> field_202384_d = Lists.newArrayList(new Biome.SpawnListEntry(MobEntities.GNOLL, 1, 3, 6));
    private static final List<Biome.SpawnListEntry> field_214559_aS = Lists.newArrayList(new Biome.SpawnListEntry(MobEntities.HYENA, 1, 2, 5));

    public SwampHutTestStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51424_1_) {
        super(p_i51424_1_);
    }

    public String getStructureName() {
        return "Swamp_Hut_Test";
    }

    public int getSize() {
        return 3;
    }

    public Structure.IStartFactory getStartFactory() {
        return SwampHutTestStructure.Start::new;
    }

    protected int getSeedModifier() {
        return 14357620;
    }

    public List<Biome.SpawnListEntry> getSpawnList() {
        return field_202384_d;
    }

    public List<Biome.SpawnListEntry> getCreatureSpawnList() {
        return field_214559_aS;
    }

    public boolean func_202383_b(IWorld p_202383_1_, BlockPos p_202383_2_) {
        StructureStart structurestart = this.getStart(p_202383_1_, p_202383_2_, true);
        if (structurestart != StructureStart.DUMMY && structurestart instanceof SwampHutTestStructure.Start && !structurestart.getComponents().isEmpty()) {
            StructurePiece structurepiece = structurestart.getComponents().get(0);
            return structurepiece instanceof SwampHutTestPiece;
        } else {
            return false;
        }
    }

    public static class Start extends StructureStart {
        public Start(Structure<?> structureIn, int p_i50515_2_, int p_i50515_3_, Biome p_i50515_4_, MutableBoundingBox p_i50515_5_, int p_i50515_6_, long p_i50515_7_) {
            super(structureIn, p_i50515_2_, p_i50515_3_, p_i50515_4_, p_i50515_5_, p_i50515_6_, p_i50515_7_);
        }

        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            SwampHutTestPiece swamphutpiece = new SwampHutTestPiece(this.rand, chunkX * 16, chunkZ * 16);
            this.components.add(swamphutpiece);
            this.recalculateStructureSize();
        }
    }
}
