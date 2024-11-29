package PromoCopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PromoCopyasfile {

	

	static String campcode = "PROMO_svwapn38a.FREEDOM_GW_CAMPAIGN_CODE.88002775.2.rt.csv";
	static String prodefdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_PromoDefinition.2008331.da.csv";
	static String proruledump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_RuleValues.2008291.da.csv";
	static String proentdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_EntitlementCat.9100022.da.csv";
	static String procamprodump = "PROMO_svwapn38a.FREEDOM_dGW_Campaign_Profile_Mapping.2006001.da.csv";
	static String procompatdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_Compatible.2008635.da.csv";
	
	static String inputpromo = "Promocodeinput.csv";
	public static ArrayList<String> promocodeinputarray = new ArrayList<String>();
	
	
	public static HashMap<String, String> promohash = new HashMap<String, String>();
	
	public static String outwritefile2 = "20xxxx.M_Promotion_GW_CAMPAIGN_CODE.88002775.2.rt.csv";
	
	public static ArrayList<String> campaigncodearray = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		inputreading();
		String dumpread = null;
		campaigncode(dumpread);
		campaigncodewriting(dumpread);

	}
	
	
	private static void inputreading() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(inputpromo));
		String dumpread;
		while ((dumpread = br.readLine()) !=null ) {
			System.out.println(dumpread);
			promocodeinputarray.add(dumpread);
			
			
		}
		br.close();
		System.out.println(promocodeinputarray);
		System.out.println("Baba Done");
	}


	private static void campaigncode(String dumpread) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(campcode));
		String campcode;
		while ((campcode = br.readLine()) !=null ) {
			String[] promosp = campcode.split(",");
			promohash.put(promosp[0],promosp[1]);
			if (promocodeinputarray.contains(promosp[0])) {
				System.out.println(campcode);
				
				campaigncodearray.add(campcode);
			}
			System.out.println(promosp[0]);
		//	System.out.println(skuhash.values());
	}
		br.close();
	}


	private static void campaigncodewriting(String campcode) {
	
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outwritefile2));
			String A = "REFERENCE_CODE,ABBREVIATION,CODE_LABEL,VALID,DESCRIPTION,CHILD_REFERENCE_TYPE,CHILD_ATTRIBUTE_TYPE\n";
			writer.write(A);
			for (String str : campaigncodearray ) {
				
			System.out.println(str);
			    writer.write(str); 
                writer.newLine();
			}
			
			writer.close();
			System.out.println("ArrayList written to file successfully."); 
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
		
	}
	
}
