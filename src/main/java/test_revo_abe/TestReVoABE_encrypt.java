package test_revo_abe;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import revoabe.Ciphertext;
import revoabe.MasterKey;
import revoabe.PrivateKey;
import revoabe.PublicKey;
import revoabe.ReVo_ABE;

public class TestReVoABE_encrypt {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		Pairing pairing = PairingFactory.getPairing("./src/main/java/a.properties");
		PairingFactory.getInstance().setUsePBCWhenPossible(true);
		int nodecount = 10;
		ReVo_ABE testABE = new ReVo_ABE(pairing, nodecount);
		
		List<String> attr_list= new ArrayList<String>();
		attr_list.add("a");
		attr_list.add("B");
		attr_list.add("C");
		attr_list.add("d");
		int user_id = 3;
		PrivateKey prik = testABE.keygen(attr_list, user_id);
		//System.out.println(prik);
		//prik.printPrivateKey();

		MasterKey mk = testABE.getMasterKey();
		//System.out.println(mk);
		//mk.printMasterKey();
		
		PublicKey pk = testABE.getPublicKey();
		//System.out.println(pk);
		//pk.printPublicKey();
		//pk.printPublicKey();
		List<Integer> RL = new ArrayList<Integer>();
		RL.add(7);
		
		byte[] msg = "What messagea is good>?".getBytes();
		testABE.printBytes(msg);
		
		Ciphertext ctxt = testABE.encrypt(pk, msg, "(a and b) or (b and c)", RL);
		testABE.printBytes(testABE.decrypt(pk, ctxt, prik).toBytes());
	}
	
	
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}

}
