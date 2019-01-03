package 数据库;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 class BorrowInformation implements LibraryDAO{
	String tiaomahao;
	String useid;
	String bookname;
	String author;
	String borrowDate;
	String returnDate;
	String place;
	
	public void borrow(Connection conn,String sql) throws SQLException
	{
		Statement stmtBorrow = conn.createStatement();
	    @SuppressWarnings("unused")
		int i= stmtBorrow.executeUpdate(sql);
		System.out.println("借书成功！");
	}
}

