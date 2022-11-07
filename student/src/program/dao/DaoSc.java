package  dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import  conn.Conn;
import  user.SC;
import  user.SedCou;

public class DaoSc {
	/*
	 * ѡ�ι�ϵ����  	һ�β�������
	 * */
	@SuppressWarnings("null")
	public int[] insertSc(SC sc[]){
		int[] rs = null;
		try{
			String sql = "insert into sc(SNo,CNo,classroom) values(?,?,?);";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			SC tem = null;
			rs = new int[sc.length];
			for(int i = 0;i< sc.length;i++){
				tem = sc[i];
				pst.setInt(1, tem.getSNo());
				pst.setInt(2, tem.getCNo());
				pst.setString(3, tem.getClassroom());
				rs[i] = pst.executeUpdate();
			}
			
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	
	/*
	 * ѡ�ι�ϵɾ��  	һ��ɾ��һ��
	 * */
	public int deleteSc(int sno,int cno){
		int rs = 0;
		try{
			String sql = "delete from sc where SNo=? and CNo=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			pst.setInt(2, cno);
			rs = pst.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	/*
	 * ��ѯĳλѧ����ѡ�γ�
	 * */
	public Iterator<SedCou> selectSc(int sno){
		Iterator<SedCou> listall = null;
		SedCou cou = null;
		try{
			List<SedCou> list  = new ArrayList<SedCou>();
			String sql = "select sc.cno,cname,ccredit,classroom from course,sc where course.cno=sc.cno and sno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sno);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				cou = new SedCou();
				cou.setCNo(rs.getInt("CNo"));
				cou.setCname(rs.getString("Cname"));
				cou.setClassroom(rs.getString("classroom"));
				cou.setCcredit(rs.getFloat("Ccredit"));
				list.add(cou);
				System.out.println("selected course is over!!");
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	/*
	 * ����ѧ�š��κ�Ψһ��ѯѡ�ι�ϵ
	 * */
	public SC selectone(int sno,int cno){
		ResultSet rs = null;
		SC sc = null;
		try{
			String sql = "select * from sc where sno=? and cno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,sno);
			pst.setInt(2,cno);
			rs = pst.executeQuery();
			if(rs.next()){
				System.out.println("classroom select over!!");	
				sc = new SC();
				sc.setSNo(rs.getInt("SNo"));
				sc.setCNo(rs.getInt("CNo"));
				sc.setClassroom(rs.getString("Classroom"));
			}
		}catch(Exception e){e.printStackTrace();}
		return sc;
	}
	/*
	 * ѡ�ι�ϵ�޸Ľ�ʦ
	 * */
	public int updateClass(SC sc){
		int rs = 0;
		try{
			String sql = "update sc set classroom=? where sno=? and cno=?;";
			Connection conn = new Conn().getConn();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,sc.getClassroom());
			pst.setInt(2, sc.getSNo());
			pst.setInt(3, sc.getCNo());
			rs = pst.executeUpdate();
			if(rs!=0) System.out.println("classroom update over!!");			
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	
}
