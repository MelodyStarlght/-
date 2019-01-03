package ���ݿ�;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
 class BookDAO implements LibraryDAO{
	String bookname;
	String chuban;
	String price;
	String author;
	String typenumber;
	String remark;
	String tiaomahao;
	String place;
	String bookstatus;
	

	public void update(Connection conn,String sql) throws SQLException
	{
		Statement stmtUpdate = conn.createStatement();
		
	    @SuppressWarnings("unused")
		int n= stmtUpdate.executeUpdate(sql);
		
	}
	public void find(Connection conn,String sql) throws SQLException
	{
		Statement stmtFind = conn.createStatement();
		ResultSet rsFind = null;
		rsFind= stmtFind.executeQuery(sql);
		while (rsFind.next()){
			 System.out.println("�鼮����"+rsFind.getString("bookname")+"  "+"���棺"+rsFind.getString("chuban")+"  "
		+"�۸�"+rsFind.getString("price")+"  "+"���ߣ�"+rsFind.getString("author")+"  "+"����ţ�"+rsFind.getString("typenumber")+"  "
		+"��ע��"+rsFind.getString("remark")+"  "+"����ţ�"+rsFind.getString("tiaomahao")+"  "+"λ�ã�"+rsFind.getString("place")+"  "
		+"�鿯״̬��"+rsFind.getString("bookstatus")+"  ");
		}
	}
	public Boolean borrow(Connection conn,String sql) throws SQLException
	{
		Boolean b=false;
		Statement stmtBorrow = conn.createStatement();
		ResultSet rsBorrow = null;
		rsBorrow= stmtBorrow.executeQuery(sql);
		while (rsBorrow.next()){
			if(rsBorrow.getString("bookstatus").trim().equals("�ɽ�"))
			{
				b=true;
               bookname=rsBorrow.getString("bookname");
				
			   	author=rsBorrow.getString("author");
			
				 tiaomahao=rsBorrow.getString("tiaomahao");
				 place=rsBorrow.getString("place");
				 bookstatus=rsBorrow.getString("bookstatus").trim();
				
			}
			else
			{
				 bookstatus=rsBorrow.getString("bookstatus").trim();
				System.out.println("�Ȿ����"+bookstatus);
			}
			
		}
		return b;
	}


}

