package coTe.Pro.Level4;

import java.util.HashMap;
import java.util.Map;

class KakaoAssignHotelRoom {

	Map<Long, Long> roomMap = new HashMap<Long, Long>();

	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		for (int i = 0; i < room_number.length; i++) {

			long wantRoom = room_number[i];
			answer[i] = findRoom(wantRoom);

		}
		return answer;
	}

	public long findRoom(long wantRoom) {

		if (!roomMap.containsKey(wantRoom)) {

			roomMap.put(wantRoom, wantRoom + 1);
			return wantRoom;

		}

		long altRoom = findRoom(roomMap.get(wantRoom));
		roomMap.put(wantRoom, altRoom);
		return altRoom;
	}

}