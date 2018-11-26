package friend;

import java.util.ArrayList;

public interface FriendDBA {//êµ¬í˜„?•  ?•¨?ˆ˜ ëª…ì„ ? •?•˜ê¸? ?œ„?•´ ?¸?„°?˜?´?Š¤ ë§Œë“¤ê³? ?•¨?ˆ˜ëª? ? •?•¨.
	//ì¶”ê?
	//ë³´ê¸°
	//ê²??ƒ‰
	public void friendInsert(Friend f) ;
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String key,String str);
}
