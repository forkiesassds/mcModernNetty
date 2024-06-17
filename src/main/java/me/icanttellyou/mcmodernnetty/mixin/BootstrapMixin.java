package me.icanttellyou.mcmodernnetty.mixin;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.logging.InternalLogger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(value = Bootstrap.class, remap = false)
public abstract class BootstrapMixin {
	@Redirect(
		method = "init",
		at = @At(
			value = "INVOKE",
			target = "Lio/netty/bootstrap/Bootstrap;setChannelOptions(Lio/netty/channel/Channel;Ljava/util/Map;Lio/netty/util/internal/logging/InternalLogger;)V",
			remap = false
		),
		remap = false
	)
	@SuppressWarnings("unchecked")
	private void modernNetty$fixSettingsInvoke(Channel channel, Map<ChannelOption<?>, Object> map, InternalLogger internalLogger) {
		AbstractBootstrapAccess.modernNetty$invokeSetChannelOptions(channel, map.entrySet().toArray(new Map.Entry[0]), internalLogger);
	}
}
