package coTe;

class ProJoyStick {
	static int totalDis = 0;
	static int skipIdx = 0;
	static int changeLetter = 0;
	static String name = "";
	
	public static void main(String[] args) {
//		String name = "JEROEN";
		String name = "JAN";
//		String name = "ABABAAAAABA";

		int answer = solution(name);
		System.out.println(totalDis);
		System.out.println(answer);

	}

	public static int solution(String names) {
		int answer = 0;
		name = names;
		skipIdx = name.length();
		int[] alphabet = new int[26];

		for (int i = 0; i < 26; i++) { // A가 0, B가 1 ...
			alphabet[i] = Math.min(i, Math.abs(i - 26));
		}

		if (name.length() == 1) {
			
			return alphabet[name.charAt(0) - 'A'];

		} else { // 앞 뒤중에 어느쪽으로 가는게 이득인지 따져봐야함. 움직이는 거리와 알파벳을 따로계산
			
			for(int i = 0 ; i < name.length(); i++) { //알파벳 바꾸는데 필요한 횟수
				
				changeLetter += alphabet[name.charAt(i) - 'A'];
			}
			
		}
		
		fowardDir(1);
		
		answer = totalDis + changeLetter;
		
		return answer;
	}
	
	public static void fowardDir(int idx) {
		
		int dis = 0; //되돌아갈때 필요한 추가거리
		for (int i = idx; i < name.length(); i++) { // 정방향 이동 중 연속된 A갯수
			int cnt = 0;

			if (name.charAt(i) == 'A') {
				
				for( int j = i; j < name.length(); j++) {
					
					if (name.charAt(j) == 'A') {
						cnt++;
					} else {
						break;
					}
				}
				
				if(dis < cnt+1) { 
					
					skipIdx = i+cnt;
					totalDis += dis+1;
					reverseDir(name.length()-1);
					return;
				} else { // A를 지나가는게 낫다면 A부분을 건너뛴 거리를 구해서 i에 대입해줘야 함.
					
					totalDis += cnt+1;
					dis += cnt+1;
					i += cnt;
					
				}
				
			} else {
				totalDis++;
				dis++;
			}

		}
		
	}
	
	public static void reverseDir(int idx) {
		
		for (int i = idx; i > skipIdx; i--) { 
							
			totalDis++;

		}
		
	}
	
}