package coTe.Pro.Kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class KakaoSong1 { // 테스트케이스 27 성공 못한 소스코드
	static Map<String, String> songInfo = new HashMap<>();
    static Map<Integer, String> posSong = new HashMap<>();
    
	public static void main(String[] args) {
		
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		
		String answer = solution(m, musicinfos);
		
		System.out.println(answer);
	}

	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String melody = m.replace("A#", "a").replace("B#", "b").replace("C#", "c").replace("D#", "d").replace("E#", "e").replace("F#", "f").replace("G#", "g"); //#처리를 해주기위해 #앞에 문자를 소문자로 바꾼다.
        System.out.println("들은노래 " + melody);
        int songTime = 0;
        String songName ="";	
        String songMelody ="";
    
        for(String str : musicinfos) {
        	
        	String[] tempArr = str.split(":|,");
        	songTime = (Integer.parseInt(tempArr[2])*60 +Integer.parseInt(tempArr[3])) - (Integer.parseInt(tempArr[0])*60+Integer.parseInt(tempArr[1]));
        	if(songTime == 0) { // 이거넣으니 테스트케이스 22,23,24 해결
        		continue;
        	}
        	songName = tempArr[4];
        	songMelody = tempArr[5].replace("A#", "a").replace("B#", "b").replace("C#", "c").replace("D#", "d").replace("E#", "e").replace("F#", "f").replace("G#", "g"); //#처리를 해주기위해 #앞에 문자를 소문자로 바꾼다.

        	String totalMelody = "";
        	int tempNum = 0;
        	System.out.println("노래길이 " +songMelody);
        	for(int i = 0; i< songTime; i++ ) {
        		
    			totalMelody += songMelody.charAt(tempNum);
        	
        		tempNum++;
        		if(tempNum == songMelody.length()) {
        			tempNum = 0;
        		}
        	}
        	System.out.println("토탈길이 " +totalMelody);
        	songInfo.put(songName, totalMelody);
        }
        
        Iterator<Map.Entry<String, String>> it = songInfo.entrySet().iterator();
        
        while(it.hasNext()) { // 일치하는 곳 있는지 확인
        	
        	Map.Entry<String, String> entry = it.next();
        	String sName = entry.getKey();
        	String tMelody = entry.getValue();
    
        	if(tMelody.length() <= melody.length()) { 
        		
        		if(melody.contains(tMelody)) {
        			posSong.put(tMelody.length(), sName);
        		}
        		
        	} else {
        		
        		if(tMelody.contains(melody)) {
        			posSong.put(tMelody.length(), sName);
        		}
        		
            }
        }

        if(posSong.isEmpty()) {
        	return "(None)";
        } else {
        	
        	Object[] keySet = posSong.keySet().toArray();
        	Arrays.sort(keySet, Collections.reverseOrder());
        	answer = posSong.get(keySet[0]);
        }
        
        return answer;
    }
    
    
}