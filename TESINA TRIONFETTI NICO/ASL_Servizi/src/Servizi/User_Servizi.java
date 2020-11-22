package Servizi;

import java.io.IOException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Main.Main;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("User")

public class User_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM user;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateUser/NUtente={id_Nutente}&VUtente={id_Vutente}&Password={id_password}&Tipo={id_tipo}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateUser(@PathParam("id_Nutente")String id_Nutente,@PathParam("id_Vutente")String id_Vutente,@PathParam("id_password")String id_password,@PathParam("id_tipo")String id_tipo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE user SET Utente = \""+id_Nutente+"\" , Password = \""+id_password+"\" , Tipo = \""+id_tipo+"\" WHERE Utente = \""+id_Vutente+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertUser/Utente={id_utente}&Password={id_password}&Tipo={id_tipo}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertUser(@PathParam("id_utente")String id_utente,@PathParam("id_password")String id_password,@PathParam("id_tipo")String id_tipo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO user(Utente,Password,Tipo) VALUES (\""+id_utente+"\", \""+id_password+"\", \""+id_tipo+"\" );";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

	@Path("deleteUser/Utente={id_utente}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteUser(@PathParam("id_utente")String id_utente)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM user  WHERE Utente=\""+id_utente+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
