package com.kuang.dao;

import com.kuang.pojo.Member;

/**
 * 成员相关查询
 */
public interface MemberMapper {
    public Member findMemberById(String memberId);
}
