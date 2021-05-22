package coTe.Pro.Kakao;

import java.util.TreeMap;

class KakaoSong {
	
	public static void main(String[] args) {
		
		String m = "ABC";
		
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		String answer = solution(m,musicinfos);
		
		System.out.println(answer);
		
	}
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        
        String neoListening = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        String[][] songInfo = new String[musicinfos.length][2];
        
        int num = 0;
        for(String str : musicinfos) {
        	
        	String[] tempArr = str.split("[:,]");

        	int songTime = (Integer.parseInt(tempArr[2])-Integer.parseInt(tempArr[0]))*60 + Integer.parseInt(tempArr[3])-Integer.parseInt(tempArr[1]);
        	
        	songInfo[num][0] = tempArr[4];
        	String tempSong = tempArr[5].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
        	String tempStr = "";
        	
        	int repetition = songTime/tempSong.length();
        	int remain = songTime%tempSong.length();
        	
        	while(repetition > 0) {
        		
        		tempStr += tempSong;
        		
        		repetition--;
        	}
        	tempStr += tempSong.substring(0,remain);
        
        	songInfo[num][1] = tempStr;
        	
        	num++;
        }
        
        TreeMap<Integer, String> possibleSong = new TreeMap<Integer, String>();
        for(int i = 0 ; i < songInfo.length; i++) {
        	if(songInfo[i][1].contains(neoListening)) {
        		
        		if(possibleSong.isEmpty()) {
        			possibleSong.put(songInfo[i][1].length(), songInfo[i][0]);
        			continue;
        		}
        		if(!possibleSong.containsKey(songInfo[i][1].length())) {
        			possibleSong.put(songInfo[i][1].length(), songInfo[i][0]);
        		}
        		
        	}
        	
        }
        
        if(possibleSong.isEmpty()) {
        	return "(None)";
        }
        
        answer = possibleSong.get(possibleSong.lastKey());
        return answer;
    }
}