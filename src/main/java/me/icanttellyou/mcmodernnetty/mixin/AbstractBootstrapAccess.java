package me.icanttellyou.mcmodernnetty.mixin;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.util.internal.logging.InternalLogger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(value = AbstractBootstrap.class, remap = false)
public interface AbstractBootstrapAccess {
	@Invoker(value = "setChannelOptions", remap = false)
	static void modernNetty$invokeSetChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] options, InternalLogger logger) {
		throw new IllegalArgumentException();
	}
}
