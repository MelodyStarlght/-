package ���ݿ�;
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
		System.out.println("���ȵ�¼");
		System.out.println("�������û�id��");
		userid=reader.nextLine();
		System.out.println("���������룺");
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
				
					System.out.println("��½�ɹ���");
				}
				else if(rsLogin.getString("userid").trim().equals(userid)&&!rsLogin.getString("password1").trim().equals(password))
				{
					 bool1=true;
					System.out.println("�������");
				}
             
			}
			if(!bool1)
            {
           	 System.out.println("�û��������ڣ�");
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
				System.out.println("ԭʼ�������");
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
			 System.out.println("������"+rsFind.getString("username")+"  "+"֤���ţ�"+rsFind.getString("userid")+"  "
		+"������λ��"+rsFind.getString("workplace")+"  "+"סַ��"+rsFind.getString("address")+"  "
		+"�������ڣ�"+rsFind.getString("Birthday")+"  "+"ʧЧ���ڣ�"+rsFind.getString("shixiaoriqi")+"  "+"���ɽ�ͼ�飺"+rsFind.getString("zuidakejietushu")+"  "
		+"�������ͣ�"+rsFind.getString("duzheleixing")+"  "+"Υ�´�����"+rsFind.getString("weizhangcishu")+"  "+"Email��"+rsFind.getString("email")+"  "
		+"ְҵ/ְ�ƣ�"+rsFind.getString("zhiye")+"  "+"�ʱࣺ"+rsFind.getString("postcode")+"  "+"�Ļ��̶ȣ�"+rsFind.getString("wenhuachengdu")+"  "
		+"��֤���ڣ�"+rsFind.getString("banzhengriqi")+"  "+"����ԤԼͼ�飺"+rsFind.getString("maxreserve")+"  "+"���ĵȼ���"+rsFind.getString("jieyuedengji")+"  "
		+"Ƿ�ѽ�"+rsFind.getString("qianfeijine")+"  "+"ְλ��"+rsFind.getString("zhiwei")+"  "+"�绰��"+rsFind.getString("dianhua")+"  "
		+"Ѻ��"+rsFind.getString("yajin")+"  "+"��Ч���ڣ�"+rsFind.getString("shengxiaoriqi")+"  "+"���ɽ���ͼ�飺"+rsFind.getString("zuidakeweituotushu")+"  "
		+"�ۼƽ��飺"+rsFind.getString("leijijieshu")+"  "+"ϵ��"+rsFind.getString("xibie")+"  "+"���֤�ţ�"+rsFind.getString("shenfenzhenghao")+"  "
		+"�Ա�"+rsFind.getString("xingbie")+"  "+"�ֻ���"+rsFind.getString("shouji")+"  "+"�����ѣ�"+rsFind.getString("shouxufei")+"  ");
		}
	}

}

