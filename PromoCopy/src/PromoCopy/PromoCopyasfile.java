package PromoCopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PromoCopyasfile {
	public static String C;
	static String hotfixnumberfile = "hotfixno.csv";
	static String inputpromo = "Promocodeinput.csv";
	
	public static HashMap<String, String> promocodeinputarrayhash = new HashMap<String, String>();
	
	static String campcode = "PROMO_svwapn38a.FREEDOM_GW_CAMPAIGN_CODE.88002775.2.rt.csv";
	static String prodefdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_PromoDefinition.2008331.da.csv";
	static String proruledump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_RuleValues.2008291.da.csv";
	static String proentdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_EntitlementCat.9100022.da.csv";
	static String procamprodump = "PROMO_svwapn38a.FREEDOM_dGW_Campaign_Profile_Mapping.2006001.da.csv";
	static String procompatdump = "PROMO_svwapn38a.FREEDOM_dGW_PRO_Compatible.2008635.da.csv";
	
	public static HashMap<String, String> totalsystempromohash = new HashMap<String, String>();
	
	

	public static String outwritefile2 = hotfixno()+".M_Promotion_GW_CAMPAIGN_CODE.88002775.2.rt.csv";
	public static ArrayList<String> campaigncodearray = new ArrayList<String>();
	
	
	public static ArrayList<String> promodefarray = new ArrayList<String>();
	public static String outwritedeffile2 = hotfixno()+".M_FREEDOM_dGW_PRO_PromoDefinition.2008331.da.csv";
	
	public static ArrayList<String> outrulearray = new ArrayList<String>();
	public static String outrulefile = hotfixno()+".M_FREEDOM_dGW_PRO_RuleValues.2008291.da.csv";
	
	public static ArrayList<String> outcamprofile = new ArrayList<String>();
	public static String outcampaignfile = hotfixno()+".M_FREEDOM_dGW_Campaign_Profile_Mapping.2006001.da.csv";
	
	
	public static ArrayList<String> outprocompati = new ArrayList<String>();
	public static String outprocompatifile = hotfixno()+".M_FREEDOM_dGW_PRO_Compatible.2008635.da.csv";
	
	public static void main(String[] args) throws Exception {
		hotfixno();
		inputreading();
		String dumpread = null;
		campaigncode(dumpread);
		campaigncodewriting(dumpread);
		promodefread();
		promodefwriting(outwritedeffile2);
		promoruleread();
		promorulewriting(outrulefile);
		promocampprofile();
		promocampprowrite(outcampaignfile);
		promocompatiread();
		promocompatiwrite(outprocompatifile);
		
		
	}
		
	private static void promocompatiread() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(procompatdump));
		String procompati;
		try {
			while ((procompati = br.readLine()) !=null ) {
				String[] procomp = procompati.split(",");	
				if ( promocodeinputarrayhash.containsValue(procomp[0]) || promocodeinputarrayhash.containsValue(procomp[20]) == true) {		
					outprocompati.add(procompati);
				}	
}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		br.close();
		
	}

	private static void promocompatiwrite(String outprocompatifile2) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outprocompatifile));
		
			String A = "Promo Code,Compatible?,SEQNR,,,,,,,,,,,,,,,,,,Promo Code,,,,,,,,,,,,,,,,,,,Result20\n";
			writer.write(A);
			for (String str : outprocompati ) {
			    writer.write(str); 
                writer.newLine();
			}
		
			writer.close();
			System.out.println("ProCampPati: ArrayList written to file successfully."); 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void promocampprowrite(String outcampaignfile2) {
	
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outcampaignfile2));
		
			String A = "Order Sequence,Access Entity,CB Profile,Campaign,,,,,,,,,,,,,,,,,Maintenance Type,Agent,,,,,,,,,,,,,,,,,,,Description\n";
			writer.write(A);
			for (String str : outcamprofile ) {
			    writer.write(str); 
                writer.newLine();
			}
		
			writer.close();
			System.out.println("ProCampProfile: ArrayList written to file successfully."); 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void promocampprofile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(procamprodump));
		String procampro;
		while ((procampro = br.readLine()) !=null ) {
			String[] procamp = procampro.split(",");
				
			if ( promocodeinputarrayhash.containsValue(procamp[3]) == true) {
				
				outcamprofile.add(procampro);
				
			}	
	}
		br.close();
		
	}

	private static String hotfixno() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(hotfixnumberfile));
			String hotf;	
			while ((hotf = br.readLine()) !=null ) {
			C=hotf;		

		}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return C;
	}

	private static void promorulewriting(String outrulefile) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outrulefile));
		
			String A = "Promo Code,Rule Function,Parameter,Elig Type,SEQNR,,,,,,,,,,,,,,,,Parameter Value,Code Value,,,,,,,,,,,,,,,,,,Result\n";
			writer.write(A);
			for (String str : outrulearray ) {
			    writer.write(str); 
                writer.newLine();
			}
		
			writer.close();
			System.out.println("ProRule: ArrayList written to file successfully."); 
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private static void promoruleread() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(proruledump));
		String prorule;
		while ((prorule = br.readLine()) !=null ) {
			String[] prorulear = prorule.split(",");
			
			
			if ( promocodeinputarrayhash.containsValue(prorulear[0]) == true) {
				
				outrulearray.add(prorule);
				
			}	
	}
		br.close();
		
	}

	private static void promodefwriting(String outwritedeffile2) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outwritedeffile2));
		
			String A = "Promo Code,,,,,,,,,,,,,,,,,,,,Type,ActionType,Start Date,End Date,Months Until Benefit,BenefitDuration,Reusable/Stackable?,Short Name,UniqueCode?,MembershipId?,BenefitType,Rep EndDate,Promo Category,Invoice Message Code,Invoice Description,,,,Measurement,Max Redemption,Description\n";
			writer.write(A);
			for (String str : promodefarray ) {
			    writer.write(str); 
                writer.newLine();
			}
		
			writer.close();
			System.out.println("ProoDef: ArrayList written to file successfully."); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	private static void promodefread() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(prodefdump));
		String prodef;
		while ((prodef = br.readLine()) !=null ) {
			String[] promod = prodef.split(",");
			
		
			if ( promocodeinputarrayhash.containsValue(promod[0]) == true) {
				
				promodefarray.add(prodef);
			}	
	}
		br.close();
		
	}  



	private static void inputreading() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(inputpromo));
		String inputrad;
		while ((inputrad = br.readLine()) !=null ) {
			String[] promoinsplit = inputrad.split(",");
			promocodeinputarrayhash.put(promoinsplit[0],promoinsplit[1]);			
		}
		br.close();
		System.out.println(promocodeinputarrayhash);
		System.out.println("Baba Done");
	}


	private static void campaigncode(String dumpread) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(campcode));
		String campcode;
		while ((campcode = br.readLine()) !=null ) {
			String[] promosp = campcode.split(",");
			totalsystempromohash.put(promosp[0],promosp[1]);
			if (promocodeinputarrayhash.containsKey(promosp[0])) {
				System.out.println(campcode);
				
				campaigncodearray.add(campcode);
			}
		//	System.out.println(promosp[0]);
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
				
		//	System.out.println(str);
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
