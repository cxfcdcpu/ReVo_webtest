package test;

import java.util.ArrayList;
import java.util.List;

import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import revoabe.MasterKey;
import revoabe.PrivateKey;
import revoabe.PublicKey;
import revoabe.ReVo_ABE;

public class TestReVoABE_encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pairing pairing = PairingFactory.getPairing("./src/main/java/a.properties");
		PairingFactory.getInstance().setUsePBCWhenPossible(true);
		int nodecount = 10;
		ReVo_ABE testABE = new ReVo_ABE(pairing, nodecount);
		
		List<String> attr_list= new ArrayList<String>();
		attr_list.add("a");
		attr_list.add("b");
		attr_list.add("c");
		attr_list.add("d");
		int user_id = 3;
		PrivateKey prik = testABE.keygen(attr_list, user_id);
		System.out.println(prik);
		//prik.printPrivateKey();

		MasterKey mk = testABE.getMasterKey();
		System.out.println(mk);
		//mk.printMasterKey();
		
		PublicKey pk = testABE.getPublicKey();
		System.out.println(pk);
		//pk.printPublicKey();
		List<Integer> RL = new ArrayList<Integer>();
		RL.add(7);
		testABE.encrypt(pk, "It suppose to be security", "(a and b) or (b and c)", RL);
		
	}

}
