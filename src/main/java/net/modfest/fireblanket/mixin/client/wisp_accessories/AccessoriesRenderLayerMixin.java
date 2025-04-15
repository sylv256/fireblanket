package net.modfest.fireblanket.mixin.client.wisp_accessories;

import io.wispforest.accessories.client.AccessoriesRenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(AccessoriesRenderLayer.class)
public class AccessoriesRenderLayerMixin {
	@Inject(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V",
		at = @At("HEAD"),
		cancellable = true
	)
	private void cancelRender(MatrixStack poseStack, VertexConsumerProvider multiBufferSource, int light, LivingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
		ci.cancel();
	}
}
