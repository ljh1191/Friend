package friend;

import java.util.ArrayList;

public interface FriendDBA {//κ΅¬ν?  ?¨? λͺμ ? ?κΈ? ??΄ ?Έ?°??΄?€ λ§λ€κ³? ?¨?λͺ? ? ?¨.
	//μΆκ?
	//λ³΄κΈ°
	//κ²??
	public void friendInsert(Friend f) ;
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String key,String str);
}
