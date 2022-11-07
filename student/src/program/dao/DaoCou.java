package  dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import  conn.Conn;
import  user.Course;
import  user.SC;
import  user.Student;

public class DaoCou {
	
	public static final String sql_select = "select * from course;";//��ѯ���е�sql���
	public static final String sql_selectfuz = "select * from course where CNo=? or....";//fuzzy queryģ����ѯ
	public static final String sql_selectone = "select * from course where CNo=?";//��ѯĳһ���γ�
	public static final String sql_update = "update course set Cname=?,Ccredit=? where CNo=?;";//�޸�һ���γ���Ϣ
	public static final String sql_delete = "delete from course where Cno=?;";//ɾ��һ���γ���Ϣ
	public static final String sql_insert = "insert into course(Cname,Ccredit) values(?,?);";//���һ���γ���Ϣ
	
	
	/*
	 * ��ѯ���пγ���Ϣ
	 * */
	public Iterator<Course> selectCou(){
		List<Course> list = null;
		Iterator<Course> listall = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_select);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){				
				Course cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
				list.add(cou);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * ��ѯĳ���γ���Ϣ
	 * */
	public Course selectCou(int id){
		Course cou = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectone);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
			}
		}catch(Exception e){e.printStackTrace();}
		return cou;
	}
	/*
	 * ��ѯĳ���γ���Ϣ��ģ����ѯ��
	 * */
	public Iterator<Course> selectCou(String aa){//aa��Ϊģ����ѯ�Ĺؼ���
		List<Course> list = null;
		Iterator<Course> listall = null;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_selectone);
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				Course cou = new Course(rs.getInt("CNo"),rs.getString("Cname"),rs.getString("Ccredit"));
				list.add(cou);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * �޸�ĳ���γ���Ϣ
	 * */
	public int updateCou(Course cou){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_update);
			pst.setString(1, cou.getCname());
			pst.setString(2, cou.getCcredit());
			pst.setInt(3, cou.getCNo());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+cou.getCNo()+"update over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * ɾ��ĳ���γ���Ϣ
	 * */
	public int deleteCou(int id){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_delete);
			pst.setInt(1, id);
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+id+"delete over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * ���һ���γ���Ϣ
	 * */
	public int insertCou(Course cou){
		int rs = 0;
		try{
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql_insert);
			pst.setString(1,cou.getCname());
			pst.setString(2, cou.getCcredit());
			rs = pst.executeUpdate();
			if(rs!=0){
				System.out.println("course_id"+cou.getCname()+"insert over!");
			}
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * ����ѧ�ţ���ѯѧ����ѧ��
	 * */
	public float selectScre(int sno){
		float sum = 0;
		try{
			String sql = "select sc.sno,sum(ccredit) as scredit from sc,course where sc.cno=course.cno and sno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			ResultSet rs = null;
			rs = pst.executeQuery();
			if(rs.next()){
				sum = rs.getFloat("scredit");
			}
		}catch(Exception e){e.printStackTrace();}
		return sum;
	}
}
