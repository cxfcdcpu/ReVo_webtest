package entity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import it.unisa.dia.gas.plaf.jpbc.util.Arrays;

public class EntityHelper {
	public static byte[] int_to_bytes(int myI) {
		return ByteBuffer.allocate(4).order(ByteOrder.nativeOrder()).putInt(myI).array();
	}
	
	public static int bytes_to_int(byte[] myB) {
		return ByteBuffer.wrap(myB).order(ByteOrder.nativeOrder()).getInt();
	}
	
	public static byte[] stringList_to_bytes(List<String> sl) {
		int totalSize = 4;
		
		for(String s: sl) {
			totalSize+=4;
			totalSize+=s.getBytes().length;
		}
		
		ByteBuffer bf = ByteBuffer.allocate(totalSize).order(ByteOrder.nativeOrder());
		bf.putInt(totalSize);
		for(String s: sl) {
			byte[] sb = s.getBytes();
			bf.putInt(sb.length);
			bf.put(sb);
		}
		return bf.array();
	}
	
	public static List<String> bytes_to_stringList(byte[] sb){
		int start = 0;
		List<String> ret = new ArrayList<String>();
		while(start < sb.length) {
			int curStringSize = ByteBuffer.wrap(Arrays.copyOfRange(sb, start, start+4)).order(ByteOrder.nativeOrder()).getInt();
			start+=4;
			String curString = new String(Arrays.copyOfRange(sb, start, start+curStringSize), StandardCharsets.UTF_8);
			start+=curStringSize;
			ret.add(curString);
		}
		return ret;
		
	}
	
	public static void printStringList(List<String> sl) {
		for(String s:sl) {
			System.out.println(s);
		}
	}
	
	
}
