import java.awt.*;
import java.util.*;
import java.io.*;
public class NBAGM
{
    public static void main(String[] args) throws IOException
    {
    	// Input a txt file that is formatted by tab-spaces.
		File inFile = new File("C:\\NBAGMSimCompiledJSON\\8513nbagm224.txt");
		Scanner inScan = new Scanner(inFile);

	  	FileWriter fstream = new FileWriter("C:\\NBAGMSimCompiledJSON\\compiled8713nbagm1047.json");
	  	BufferedWriter out = new BufferedWriter(fstream);

	  	out.write("{\"startingSeason\":2014,");
	  	out.write("\"players\":[");

	  	int count = 0;
	  	String textFinal="",line;
	  	String[] array, teams;
	  	String teamsTID="",teamsNm="";
	  	String tid="",hgt="",stre="",spd="",jmp="",endu="",ins="",dnk="",ft="",fg="",tp="",blk="",stl="",drb="",pss="",reb="",pot="",position="",weight="",yearBorn="",name="",contractAmt="";
	  	String skills1="",skills2="",skills3="",skills4="",skills5="",skills6="",skills7="",skills8="";
	  	String contractExp="",draftRnd="",draftPick="",draftTid="",draftYear="",injuryType="",originalTid="",originalHeight="",firstYearSalary="",teamName="",playerIMG="",gamesRemaining="";
		System.out.println("Compiling...");
	  	while(inScan.hasNextLine()&&count<=699)
	  	{
		  	line = inScan.nextLine();

	  		array = line.split("\\t");
		  	tid=array[0];
		  	hgt=array[1];
		  	stre=array[2];
		  	spd=array[3];
		  	jmp=array[4];
		  	endu=array[5];
		  	ins=array[6];
		  	dnk=array[7];
		  	ft=array[8];
		  	fg=array[9];
		  	tp=array[10];
		  	blk=array[11];
		  	stl=array[12];
		  	drb=array[13];
		  	pss=array[14];
		  	reb=array[15];
		  	pot=array[16];
		  	skills1=array[17];
		  	skills2=array[18];
		  	skills3=array[19];
		  	skills4=array[20];
		  	skills5=array[21];
		  	skills6=array[22];
		  	skills7=array[23];
		  	skills8=array[24];
		  	String[] skillsArray = {skills1,skills2,skills3,skills4,skills5,skills6,skills7,skills8};
		  	position=array[25];
		  	weight=array[26];
		  	yearBorn=array[27];
		  	name=array[28];
		  	contractAmt=array[29];
		  	contractExp=array[30];
		  	draftRnd=array[31];
		  	draftPick=array[32];
		  	draftTid=array[33];
		  	draftYear=array[34];
		  	injuryType=array[35];
		  	originalTid=array[36];
		  	originalHeight=array[37];
		  	firstYearSalary=array[38];
		  	teamName=array[39];
		  	try {playerIMG=array[40];}
		  	catch (Exception ex) {playerIMG="";}

		  	gamesRemaining="0";

		  	textFinal+="{\"tid\": "+tid+",\"ratings\":[{";
		  	textFinal+="\"hgt\": "+hgt+",\"stre\": "+ stre;
		  	textFinal+=",\"spd\": "+spd+",\"jmp\": "+jmp+",\"endu\": "+endu+",\"ins\": ";
		  	textFinal+=ins+",\"dnk\": "+dnk+",\"ft\": "+ft+",\"fg\": "+fg+",\"tp\": "+tp;
		  	textFinal+=",\"blk\": "+blk+",\"stl\": "+stl+",\"drb\": "+drb;
		  	textFinal+=",\"pss\": "+pss+",\"reb\": "+reb+",\"pot\": "+pot;
		  	textFinal+=",\"skills\": ["+checkValid(skillsArray)+"]}],\"pos\": \""+position;
		  	textFinal+="\",\"hgt\": "+originalHeight+",\"weight\": "+weight+",\"born\": {\"year\": "+yearBorn+"},";
		  	textFinal+="\"name\": \""+name+"\",\"imgURL\": \""+playerIMG+"\",\"contract\": {\"amount\": "+firstYearSalary;
		  	textFinal+=",\"exp\": "+contractExp+"},\"draft\":{\"round\": "+draftRnd;
		  	textFinal+=",\"pick\": "+draftPick+",\"tid\": "+draftTid+",\"originalTid\": "+originalTid+",\"year\": "+draftYear;
		  	textFinal+=",\"loc\": \"USA\"},\"injury\":{\"type\": \""+injuryType+"\",\"gamesRemaining\": "+gamesRemaining+"}},";
		  	count++;
		  	if(count==698)break;else continue;
	  	} //MAKE SURE TO REMOVE LAST COMMA (",") FROM LAST LINE IN FINAL FILE ^
	  	/*Put TEAMS*/
	  	textFinal+="],\"teams\": [";

	  	while(inScan.hasNextLine())
	  	{
	  		line=inScan.nextLine();
	  		teams=line.split("\\t");
	  		teamsTID=teams[0];
	  		teamsNm=teams[1];
	  		textFinal+="{\"tid\": "+teamsTID+",\"name\": \""+teamsNm+"\"},";
	  	}
	  	textFinal+="]}";
	  	textFinal=textFinal.substring(0,textFinal.length()-4)+"}]}";
	  	String finalTextTemp=textFinal.replaceAll("\",]","\"]");
	  	String finalText=finalTextTemp.replaceAll("},],\"teams\"","}],\"teams\"");
	  	out.write(finalText);
	  	out.close();
    }

    public static String checkValid(String[] array)
    {
        String returnS="";
        for(int a=0;a<array.length;a++)
        {
            if(array[a].equals("N/A"))returnS+="";else returnS+=("\""+array[a]+"\",");
        }
        return returnS;
    }
}