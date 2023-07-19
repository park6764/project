package com.korea.k2.guestbook;

import java.util.List;

public interface GuestBookService {
	void insert(GuestBookVO vo);
	List<GuestBookVO> list(GuestBookVO vo);
	int totalCount(GuestBookVO vo);
}
