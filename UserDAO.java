package 数据库;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
 public class UserDAO implements LibraryDAO{
	String username;
	String userid;
	String password;
	String workplace;
	String address;
	String Birthday;
	String shixiaoriqi;
	String zuidakejietushu;
	String duzheleixing;
	String weizhangcishu;
	String email;
	String zhiye;
	String postcode;
	String wenhuachengdu;
	String banzhengriqi;
	String maxreserve;
	String jieyuedengji;
	String qianfeijine;
	String zhiwei;
	String dianhua;
	String yajin;
	String shengxiaoriqi;
	String zuidakeweituotushu;
	int leijijieshu;
	String xibie;
	String shenfenzhenghao;
	String xingbie;
	String shouji;
	String shouxufei;

	public void update(Connection conn,String sql) throws SQLException
	{
		Statement stmtUpdate = conn.createStatement();
		
	    @SuppressWarnings("unused")
		int n= stmtUpdate.executeUpdate(sql);
		
	}
	public Boolean Login(Connection conn) throws SQLException
	{
		Scanner reader=new Scanner(System.in);
		System.out.println("请先登录");
		System.out.println("请输入用户id：");
		userid=reader.nextLine();
		System.out.println("请输入密码：");
		password=reader.nextLine();
		Statement stmtLogin = null;
		ResultSet rsLogin = null;
         Boolean bool=false;
         Boolean bool1=false;

		try {
			stmtLogin= conn.createStatement();
			rsLogin= stmtLogin.executeQuery("select userid,password1,leijijieshu\r\n" + 
					"from dbo.ususer");
			while (rsLogin.next()){
	
				if(rsLogin.getString("userid").trim().equals(userid)&&rsLogin.getString("password1").trim().equals(password))
				{
					 bool1=true;
					bool=true;
					leijijieshu=rsLogin.getInt("leijijieshu");
				
					System.out.println("登陆成功！");
				}
				else if(rsLogin.getString("userid").trim().equals(userid)&&!rsLogin.getString("password1").trim().equals(password))
				{
					 bool1=true;
					System.out.println("密码错误！");
				}
             
			}
			if(!bool1)
            {
           	 System.out.println("用户名不存在！");
           	 bool=false;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	
		return bool;
	}
	
	public Boolean mimayanzheng(Connection conn,String sql,String userid,String yuanshimima) throws SQLException
	{
		Boolean bool=false;
		Statement stmtmimayanzheng =conn.createStatement();
		ResultSet rsmimayanzheng = null;
		
		rsmimayanzheng= stmtmimayanzheng.executeQuery(sql);
		while (rsmimayanzheng.next()){
			if(rsmimayanzheng.getString("userid").trim().equals(userid)&&rsmimayanzheng.getString("password1").trim().equals(yuanshimima))
			{
				 
		    bool=true;
			}
			else
			{
				System.out.println("原始密码错误！");
			}
		}
		return bool;
	}
	public void find(Connection conn,String sql) throws SQLException
	{
		Statement stmtFind =conn.createStatement();
		ResultSet rsFind = null;
		rsFind= stmtFind.executeQuery(sql);
		while (rsFind.next()){
			 System.out.println("姓名："+rsFind.getString("username")+"  "+"证件号："+rsFind.getString("userid")+"  "
		+"工作单位："+rsFind.getString("workplace")+"  "+"住址："+rsFind.getString("address")+"  "
		+"出生日期："+rsFind.getString("Birthday")+"  "+"失效日期："+rsFind.getString("shixiaoriqi")+"  "+"最大可借图书："+rsFind.getString("zuidakejietushu")+"  "
		+"读者类型："+rsFind.getString("duzheleixing")+"  "+"违章次数："+rsFind.getString("weizhangcishu")+"  "+"Email："+rsFind.getString("email")+"  "
		+"职业/职称："+rsFind.getString("zhiye")+"  "+"邮编："+rsFind.getString("postcode")+"  "+"文化程度："+rsFind.getString("wenhuachengdu")+"  "
		+"办证日期："+rsFind.getString("banzhengriqi")+"  "+"最大可预约图书："+rsFind.getString("maxreserve")+"  "+"借阅等级："+rsFind.getString("jieyuedengji")+"  "
		+"欠费金额："+rsFind.getString("qianfeijine")+"  "+"职位："+rsFind.getString("zhiwei")+"  "+"电话："+rsFind.getString("dianhua")+"  "
		+"押金："+rsFind.getString("yajin")+"  "+"生效日期："+rsFind.getString("shengxiaoriqi")+"  "+"最大可借阅图书："+rsFind.getString("zuidakeweituotushu")+"  "
		+"累计借书："+rsFind.getString("leijijieshu")+"  "+"系别："+rsFind.getString("xibie")+"  "+"身份证号："+rsFind.getString("shenfenzhenghao")+"  "
		+"性别："+rsFind.getString("xingbie")+"  "+"手机："+rsFind.getString("shouji")+"  "+"手续费："+rsFind.getString("shouxufei")+"  ");
		}
	}

}

