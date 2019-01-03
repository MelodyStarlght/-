package 数据库;
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
			 System.out.println("书籍名："+rsFind.getString("bookname")+"  "+"出版："+rsFind.getString("chuban")+"  "
		+"价格："+rsFind.getString("price")+"  "+"作者："+rsFind.getString("author")+"  "+"索书号："+rsFind.getString("typenumber")+"  "
		+"备注："+rsFind.getString("remark")+"  "+"条码号："+rsFind.getString("tiaomahao")+"  "+"位置："+rsFind.getString("place")+"  "
		+"书刊状态："+rsFind.getString("bookstatus")+"  ");
		}
	}
	public Boolean borrow(Connection conn,String sql) throws SQLException
	{
		Boolean b=false;
		Statement stmtBorrow = conn.createStatement();
		ResultSet rsBorrow = null;
		rsBorrow= stmtBorrow.executeQuery(sql);
		while (rsBorrow.next()){
			if(rsBorrow.getString("bookstatus").trim().equals("可借"))
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
				System.out.println("这本书已"+bookstatus);
			}
			
		}
		return b;
	}


}

