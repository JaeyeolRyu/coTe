package coTe.Pro.Kakao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class KakaoMatchingSuspend {
    public int solution(String word, String[] pages) {
        int answer = 0;
        
        word = word.toLowerCase();
        
        for(String page : pages) {
        	
        	Pattern pattern = Pattern.compile("  <meta property=\"og:url\" content=");
        	Matcher matcher = pattern.matcher(page);
        	
        	
        	
        	
        	
        	
        	
        }
        
        
        
        
        
        
        return answer;
    }
}