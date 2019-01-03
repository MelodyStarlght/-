package 数据库;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		System.out.println("欢迎您来畅游知识的海洋！");
		UserDAO user=new UserDAO();
		BookDAO book=new BookDAO();
		BorrowInformation bookin=new BorrowInformation();
		Scanner reader=new Scanner(System.in);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=library;user=ggg;password=123";
		Connection conn = DriverManager.getConnection(url);
	    System.out.println("连接数据库成功！");
	    while (user.Login(conn))
		{
			Boolean bool1=true;
	        while(bool1)
	       {
	    	    System.out.println("1：个人信息查询");
				System.out.println("2：书籍信息查询");
				System.out.println("3：查询图书馆营业时间");
				System.out.println("4：书籍借阅登记");
				System.out.println("5：书籍归还");
				System.out.println("6：退出系统");
				System.out.println("7：更改密码");
		     	System.out.print("请输入序号选择您想办理的业务：");
			int n;
			n=reader.nextInt();
	
		    switch (n)
		    {
		    case 1:
		    {
		    	
		    	String sql="select *\r\n" + 
		    			"from dbo.ususer\r\n" + 
		    			"where userid="+"'"+user.userid+"'";
		    	user.find(conn,sql);
		    	break;
		    }
		    case 2:
		    {
		        System.out.print("请输入您想查找的书籍名:");
		    	Scanner reader2=new Scanner(System.in);
		    	String book1=reader2.nextLine(); 
		    
		    	String sql="select * \r\n" + 
		    			"from dbo.book\r\n" + 
		    			"where bookname="+"'"+book1+"'";
		    	book.find( conn,sql);   
		    	break;
		    }
		    case 3:
		    {
		    	 System.out.println("图书馆营业时间:");
		    	 System.out.println("7:00-22:00");
		    	 break;
		    }
		    case 6:
		    {
		    	 System.out.println("您已退出系统！");
		    	bool1=false;
		    	 break;
		    }
		    case 4:
		    {
		    	    System.out.print("请输入您想借阅的书籍名:");
		    	  
		    	    
			    	Scanner reader4=new Scanner(System.in);
			    	String book2=reader4.nextLine(); 
			   
				    
				 
				    
			    	String sql="select * \r\n" + 
			    			"from dbo.book\r\n" + 
			    			"where bookname="+"'"+book2+"'";
			       
			    	if(book.borrow( conn,sql))  
			    	{
			    	  	 System.out.print("请输入您借书日期:");
				    	  
					    	Scanner readerday1=new Scanner(System.in);
				   	String Day1=readerday1.nextLine(); 
					    	
					  	 System.out.print("请输入您还书日期:");
					    	  
						  	Scanner readerday2=new Scanner(System.in);
						  	String Day2=readerday2.nextLine(); 
						  	String str="借出-应还日期:"+Day2;
			    		  String sql1="insert into borrowing(tiaomahao,userid,bookname,author,borrowDate,returnDate,place)\r\n" + 
			   				   "values ('"+ book.tiaomahao +"',' "+user.userid+"','"+book.bookname +"',' "+ book.author +"',' "+ Day1 +"',' "+ Day2 +"',' "+ book.place+" ')";
			   			    	bookin.borrow(conn,sql1);   
			   			    	String sql2="update dbo.book\r\n" + 
						    			"set bookstatus='"+str+"'\r\n" + 
						    			"where bookname='"+book2+"'";
						       book.update(conn, sql2);
						       user.leijijieshu++;
						       String sql3="update dbo.ususer\r\n" + 
						    			"set leijijieshu='"+ user.leijijieshu+"' \r\n" + 
						    			"where userid='"+user.userid+"'";
						       user.update(conn, sql3);
			    	}
			    
			      break; 
		    	 
		    	 
		    }
		    case 5:
		    {
		    	    System.out.print("请输入您想归还的书籍名:");
		    	  
		    	    
			    	Scanner reader6=new Scanner(System.in);
			    	String book2=reader6.nextLine(); 
				    
			    	String sql="update dbo.book\r\n" + 
			    			"set bookstatus='可借'\r\n" + 
			    			"where bookname='"+book2+"'";
			       book.update(conn, sql);
			       System.out.println("还书成功！");
			      break; 
		    	 
		    	 
		    }
		    case 7:
		    {
		    	String sql="select *\r\n" + 
		    			"from dbo.ususer\r\n" + 
		    			"where userid="+"'"+user.userid+"'";
		    	    System.out.print("请输入您的原密码:");
	             	Scanner reader7=new Scanner(System.in);
			    	String yuanshimima=reader7.nextLine(); 
			    	
			    	if(user.mimayanzheng(conn,sql,user.userid, yuanshimima))
			    	{
			    		 System.out.print("请输入您的新密码:");
			             Scanner reader8=new Scanner(System.in);
					    String xinmima=reader8.nextLine(); 
			    		String sql1="update dbo.ususer\r\n" + 
				    			"set password1='"+ xinmima+"'\r\n" + 
				    			"where userid='"+user.userid+"'";
				       book.update(conn, sql1);
				       System.out.println("密码更改成功！");
			    	}
			    	
			      break; 
		    	 
		    	 
		    }
		    	default:
		    	{
		    		 System.out.println("对不起，您输入的内容不合法！");
		    		 break;
		    	}
		    }
	       }
			
		
	}
	
    	}
	}

