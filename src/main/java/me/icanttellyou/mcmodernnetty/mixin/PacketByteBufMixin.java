package me.icanttellyou.mcmodernnetty.mixin;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

@Mixin(PacketByteBuf.class)
public abstract class PacketByteBufMixin extends ByteBuf {
	@Final @Shadow private ByteBuf delegate;

	@Unique
	private byte[] bytes;

	@Redirect(
		method = "readString",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/network/PacketByteBuf;readBytes(I)Lio/netty/buffer/ByteBuf;"
		)
	)
	private ByteBuf modernNetty$readBytesToArray(PacketByteBuf instance, int length) {
		bytes = new byte[length];
		return instance.readBytes(bytes);
	}

	@Redirect(
		method = "readString",
		at = @At(
			value = "INVOKE",
			target = "Lio/netty/buffer/ByteBuf;array()[B",
			remap = false
		)
	)
	private byte[] modernNetty$readBytesToArray(ByteBuf instance) {
		return bytes;
	}

	@Override
	public boolean isReadOnly() {
		return delegate.isReadOnly();
	}

	@Override
	public ByteBuf asReadOnly() {
		return delegate.asReadOnly();
	}

	@Override
	public int maxFastWritableBytes() {
		return delegate.maxFastWritableBytes();
	}

	@Override
	public short getShortLE(int index) {
		return delegate.getShortLE(index);
	}

	@Override
	public int getUnsignedShortLE(int index) {
		return delegate.getUnsignedShortLE(index);
	}

	@Override
	public int getMediumLE(int index) {
		return delegate.getMediumLE(index);
	}

	@Override
	public int getUnsignedMediumLE(int index) {
		return delegate.getUnsignedMediumLE(index);
	}

	@Override
	public int getIntLE(int index) {
		return delegate.getIntLE(index);
	}

	@Override
	public long getUnsignedIntLE(int index) {
		return delegate.getUnsignedIntLE(index);
	}

	@Override
	public long getLongLE(int index) {
		return delegate.getLongLE(index);
	}

	@Override
	public float getFloatLE(int index) {
		return delegate.getFloatLE(index);
	}

	@Override
	public double getDoubleLE(int index) {
		return delegate.getDoubleLE(index);
	}

	@Override
	public int getBytes(int index, FileChannel out, long position, int length) throws IOException {
		return delegate.getBytes(index, out, position, length);
	}

	@Override
	public CharSequence getCharSequence(int index, int length, Charset charset) {
		return delegate.getCharSequence(index, length, charset);
	}

	@Override
	public ByteBuf setShortLE(int index, int value) {
		return delegate.setShortLE(index, value);
	}

	@Override
	public ByteBuf setMediumLE(int index, int value) {
		return delegate.setMediumLE(index, value);
	}

	@Override
	public ByteBuf setIntLE(int index, int value) {
		return delegate.setIntLE(index, value);
	}

	@Override
	public ByteBuf setLongLE(int index, long value) {
		return delegate.setLongLE(index, value);
	}

	@Override
	public ByteBuf setFloatLE(int index, float value) {
		return delegate.setFloatLE(index, value);
	}

	@Override
	public ByteBuf setDoubleLE(int index, double value) {
		return delegate.setDoubleLE(index, value);
	}

	@Override
	public int setBytes(int index, FileChannel in, long position, int length) throws IOException {
		return delegate.setBytes(index, in, position, length);
	}

	@Override
	public int setCharSequence(int index, CharSequence sequence, Charset charset) {
		return delegate.setCharSequence(index, sequence, charset);
	}

	@Override
	public short readShortLE() {
		return delegate.readShortLE();
	}

	@Override
	public int readUnsignedShortLE() {
		return delegate.readUnsignedShortLE();
	}

	@Override
	public int readMediumLE() {
		return delegate.readMediumLE();
	}

	@Override
	public int readUnsignedMediumLE() {
		return delegate.readUnsignedMediumLE();
	}

	@Override
	public int readIntLE() {
		return delegate.readIntLE();
	}

	@Override
	public long readUnsignedIntLE() {
		return delegate.readUnsignedIntLE();
	}

	@Override
	public long readLongLE() {
		return delegate.readLongLE();
	}

	@Override
	public float readFloatLE() {
		return delegate.readFloatLE();
	}

	@Override
	public double readDoubleLE() {
		return delegate.readDoubleLE();
	}

	@Override
	public ByteBuf readRetainedSlice(int length) {
		return delegate.readRetainedSlice(length);
	}

	@Override
	public CharSequence readCharSequence(int length, Charset charset) {
		return delegate.readCharSequence(length, charset);
	}

	@Override
	public int readBytes(FileChannel out, long position, int length) throws IOException {
		return delegate.readBytes(out, position, length);
	}

	@Override
	public ByteBuf writeShortLE(int value) {
		return delegate.writeShortLE(value);
	}

	@Override
	public ByteBuf writeMediumLE(int value) {
		return delegate.writeMediumLE(value);
	}

	@Override
	public ByteBuf writeIntLE(int value) {
		return delegate.writeIntLE(value);
	}

	@Override
	public ByteBuf writeLongLE(long value) {
		return delegate.writeLongLE(value);
	}

	@Override
	public ByteBuf writeFloatLE(float value) {
		return delegate.writeFloatLE(value);
	}

	@Override
	public ByteBuf writeDoubleLE(double value) {
		return delegate.writeDoubleLE(value);
	}

	@Override
	public int writeBytes(FileChannel in, long position, int length) throws IOException {
		return delegate.writeBytes(in, position, length);
	}

	@Override
	public int writeCharSequence(CharSequence sequence, Charset charset) {
		return delegate.writeCharSequence(sequence, charset);
	}

	@Override
	public int forEachByte(ByteProcessor processor) {
		return delegate.forEachByte(processor);
	}

	@Override
	public int forEachByte(int index, int length, ByteProcessor processor) {
		return delegate.forEachByte(index, length, processor);
	}

	@Override
	public int forEachByteDesc(ByteProcessor processor) {
		return delegate.forEachByteDesc(processor);
	}

	@Override
	public int forEachByteDesc(int index, int length, ByteProcessor processor) {
		return delegate.forEachByteDesc(index, length, processor);
	}

	@Override
	public ByteBuf retainedSlice() {
		return delegate.retainedSlice();
	}

	@Override
	public ByteBuf retainedSlice(int index, int length) {
		return delegate.retainedSlice(index, length);
	}

	@Override
	public ByteBuf retainedDuplicate() {
		return delegate.retainedDuplicate();
	}

	@Override
	public boolean isContiguous() {
		return delegate.isContiguous();
	}

	@Override
	public ByteBuf touch() {
		return delegate.touch();
	}

	@Override
	public ByteBuf touch(Object hint) {
		return delegate.touch(hint);
	}
}
