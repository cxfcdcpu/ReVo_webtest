package entity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class EntityHelper {
	public static byte[] int_to_bytes(int myI) {
		return ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(myI).array();
	}
	
	public static int bytes_to_int(byte[] myB) {
		return ByteBuffer.wrap(myB).order(ByteOrder.nativeOrder()).getInt();
	}
}
