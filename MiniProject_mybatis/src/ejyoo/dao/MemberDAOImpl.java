package ejyoo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ejyoo.dto.MemberVO;

public class MemberDAOImpl implements IMemberDAO{
//	private static IMemberDAO imemberDao;

//	private MemberDAOImpl() {}
	
//	public static IMemberDAO getInstance() {
//		if(imemberDao == null) {
//			imemberDao = new MemberDAOImpl();
//		}
		
//		return imemberDao;
//	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws SQLException {
		List<MemberVO> memberList = null;
		
		memberList = session.selectList("Member-Mapper.selectMemberList");
		
		return memberList;
	}
	
	@Override
	public List<MemberVO> selectMemberListByInfo(SqlSession session, MemberVO memberVO) throws SQLException {
		List<MemberVO> memberList = null;
		
		memberList = session.selectList("Member-Mapper.selectMemberListByInfo", memberVO);
		
		return memberList;
	}
	
	@Override
	public MemberVO selectMemberByInfo(SqlSession session, MemberVO memberVO) throws SQLException {
		MemberVO member = null;
		
		member = session.selectOne("Member-Mapper.selectMemberByInfo", memberVO);
		
		return member;
	}
	
	@Override
	public MemberVO selectMemberById(SqlSession session, String userId) throws SQLException {
		MemberVO member = null;
		
		member = session.selectOne("Member-Mapper.selectMemberById", userId);
		
		return member;
	}

	@Override
	public int insertMemberByInfo(SqlSession session, MemberVO memberVO) throws SQLException {
		int cnt = 0;
		
		cnt = session.insert("Member-Mapper.insertMemberByInfo", memberVO);
		
		return cnt;
	}

	@Override
	public int updateMemberByInfo(SqlSession session, MemberVO memberVO) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("Member-Mapper.updateMemberByInfo", memberVO);
		
		return cnt;
	}

	@Override
	public int deleteMemberById(SqlSession session, String userId) throws SQLException {
		int cnt = 0;
		
		cnt = session.delete("Member-Mapper.deleteMemberById", userId);
		
		return cnt;
	}
}
