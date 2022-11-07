package  dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import  conn.Conn;
import  user.QueryResult;

public class DaoQuery {
	/*
	 * ����ѧ�Ų�ѯѡ�����
	 * */
	public List<QueryResult> selectSno(int sno){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * ����ѧ��������ѯѡ�����
	 * */
	public List<QueryResult> selectSname(String name){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sname=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * ���ݰ༶��ѯѡ�����
	 * */
	public List<QueryResult> selectSclass(String _class){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and student.sclass=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, _class);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * ���ݿγ̺Ų�ѯѡ�����
	 * */
	public List<QueryResult> selectCno(int cno){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and course.cno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cno);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * ���ݿγ�����ѯѡ�����
	 * */
	public List<QueryResult> selectCname(String cname){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and course.cname=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cname);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
	/*
	 * �����Ͽν��Ҳ�ѯѡ�����
	 * */
	public List<QueryResult> selectRoom(String room){
		List<QueryResult> list = null;
		try{
			list = new ArrayList<QueryResult>();
			String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course " +
					"where student.sno=sc.sno and sc.cno=course.cno and classroom=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, room);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				QueryResult qrs = new QueryResult();
				qrs.setSNo(rs.getInt("sno"));
				qrs.setCNo(rs.getInt("cno"));
				qrs.setSname(rs.getString("sname"));
				qrs.setCname(rs.getString("cname"));
				qrs.setSclass(rs.getString("sclass"));
				qrs.setClassroom(rs.getString("classroom"));
				list.add(qrs);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return list;
	}

}
