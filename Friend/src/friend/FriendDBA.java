package friend;

import java.util.ArrayList;

public interface FriendDBA {//구현?�� ?��?�� 명을 ?��?���? ?��?�� ?��?��?��?��?�� 만들�? ?��?���? ?��?��.
	//추�?
	//보기
	//�??��
	public void friendInsert(Friend f) ;
	public ArrayList<Friend> friendView();
	public ArrayList<Friend> friendSearch(String key,String str);
}
