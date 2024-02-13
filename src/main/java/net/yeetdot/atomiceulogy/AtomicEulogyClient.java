package net.yeetdot.atomiceulogy;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.yeetdot.atomiceulogy.block.ModBlocks;

public class AtomicEulogyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks. TITANIUM_DOOR,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks. TITANIUM_TRAPDOOR,RenderLayer.getCutout());
    }
}
