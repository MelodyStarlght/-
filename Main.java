package ���ݿ�;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		System.out.println("��ӭ��������֪ʶ�ĺ���");
		UserDAO user=new UserDAO();
		BookDAO book=new BookDAO();
		BorrowInformation bookin=new BorrowInformation();
		Scanner reader=new Scanner(System.in);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=library;user=ggg;password=123";
		Connection conn = DriverManager.getConnection(url);
	    System.out.println("�������ݿ�ɹ���");
	    while (user.Login(conn))
		{
			Boolean bool1=true;
	        while(bool1)
	       {
	    	    System.out.println("1��������Ϣ��ѯ");
				System.out.println("2���鼮��Ϣ��ѯ");
				System.out.println("3����ѯͼ���Ӫҵʱ��");
				System.out.println("4���鼮���ĵǼ�");
				System.out.println("5���鼮�黹");
				System.out.println("6���˳�ϵͳ");
				System.out.println("7����������");
		     	System.out.print("���������ѡ����������ҵ��");
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
		        System.out.print("������������ҵ��鼮��:");
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
		    	 System.out.println("ͼ���Ӫҵʱ��:");
		    	 System.out.println("7:00-22:00");
		    	 break;
		    }
		    case 6:
		    {
		    	 System.out.println("�����˳�ϵͳ��");
		    	bool1=false;
		    	 break;
		    }
		    case 4:
		    {
		    	    System.out.print("������������ĵ��鼮��:");
		    	  
		    	    
			    	Scanner reader4=new Scanner(System.in);
			    	String book2=reader4.nextLine(); 
			   
				    
				 
				    
			    	String sql="select * \r\n" + 
			    			"from dbo.book\r\n" + 
			    			"where bookname="+"'"+book2+"'";
			       
			    	if(book.borrow( conn,sql))  
			    	{
			    	  	 System.out.print("����������������:");
				    	  
					    	Scanner readerday1=new Scanner(System.in);
				   	String Day1=readerday1.nextLine(); 
					    	
					  	 System.out.print("����������������:");
					    	  
						  	Scanner readerday2=new Scanner(System.in);
						  	String Day2=readerday2.nextLine(); 
						  	String str="���-Ӧ������:"+Day2;
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
		    	    System.out.print("����������黹���鼮��:");
		    	  
		    	    
			    	Scanner reader6=new Scanner(System.in);
			    	String book2=reader6.nextLine(); 
				    
			    	String sql="update dbo.book\r\n" + 
			    			"set bookstatus='�ɽ�'\r\n" + 
			    			"where bookname='"+book2+"'";
			       book.update(conn, sql);
			       System.out.println("����ɹ���");
			      break; 
		    	 
		    	 
		    }
		    case 7:
		    {
		    	String sql="select *\r\n" + 
		    			"from dbo.ususer\r\n" + 
		    			"where userid="+"'"+user.userid+"'";
		    	    System.out.print("����������ԭ����:");
	             	Scanner reader7=new Scanner(System.in);
			    	String yuanshimima=reader7.nextLine(); 
			    	
			    	if(user.mimayanzheng(conn,sql,user.userid, yuanshimima))
			    	{
			    		 System.out.print("����������������:");
			             Scanner reader8=new Scanner(System.in);
					    String xinmima=reader8.nextLine(); 
			    		String sql1="update dbo.ususer\r\n" + 
				    			"set password1='"+ xinmima+"'\r\n" + 
				    			"where userid='"+user.userid+"'";
				       book.update(conn, sql1);
				       System.out.println("������ĳɹ���");
			    	}
			    	
			      break; 
		    	 
		    	 
		    }
		    	default:
		    	{
		    		 System.out.println("�Բ�������������ݲ��Ϸ���");
		    		 break;
		    	}
		    }
	       }
			
		
	}
	
    	}
	}

