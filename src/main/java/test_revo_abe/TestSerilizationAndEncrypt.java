package test_revo_abe;

import java.sql.Timestamp;

import entity.Match;
import entity.mission;
import entity.user;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import revoabe.Ciphertext;
import revoabe.PrivateKey;
import revoabe.PublicKey;
import revoabe.ReVo_ABE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import db.DBConnection;
import db.DBConnectionFactory;


public class TestSerilizationAndEncrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pairing pairing = PairingFactory.getPairing("./src/main/java/a.properties");
		PairingFactory.getInstance().setUsePBCWhenPossible(true);
		Date localTime = new Date();
				
		Timestamp startTime = new Timestamp(localTime.getTime());
		Timestamp endTime = new Timestamp(localTime.getTime()+10*24*3600*1000);
		System.out.println(startTime);
		System.out.println(endTime);
		
		DBConnection conn = DBConnectionFactory.getConnection();
		int missionCount = conn.getAllMissions().size();
		mission curMission = new mission("test serialization mission"+missionCount, 10,startTime, endTime);
		
		conn.insertMission(curMission);
		
		mission serilizedMission = conn.searchMission(curMission.getMissionName());
		byte[] needToEncrypt = "It supposed to be secure".getBytes();
		List<Integer> RL = new ArrayList<Integer>();
		RL.add(7);
		PublicKey serilizedPK = serilizedMission.getPublicKey();
		Ciphertext ct = ReVo_ABE.encrypt(pairing, serilizedPK, needToEncrypt, "(a and b) or (b and c)", RL);
		
		List<String> attr_list= new ArrayList<String>();
		attr_list.add("a");
		attr_list.add("B");
		attr_list.add("C");
		attr_list.add("d");
		int user_id = 3;
		PrivateKey prik = ReVo_ABE.keyGen(serilizedPK, serilizedMission.getMasterKey(), attr_list, user_id);
		
		String decoded = new String(ReVo_ABE.decrypt(pairing, serilizedPK, ct, prik));
		System.out.println("Try to decode with private key generated from serilized public and master keys");
		System.out.println(decoded);
		int userCount = conn.getAllUsers().size();
		String username = "d"+userCount;
		String password = "p"+userCount;
		String firstname = "first_d"+userCount;
		String lastname = "last_d"+userCount;
		List<String> attributes =Arrays.asList("a, b, c, d, e".split(","));
		user us = new user(username, password, firstname, lastname, attributes);
		conn.insertUser(us);
		
		int userCountForMission = conn.getUsersForMission(serilizedMission.getMissionName()).size();
		Match curMatch = new Match(curMission,us,userCountForMission+1);
		conn.insertMatch(curMatch);
		
		Match serilizedMatch = conn.searchMatch(curMission.getMissionName(), us.getUsername());
		//PrivateKey prik = serilizedMatch
	}

}
