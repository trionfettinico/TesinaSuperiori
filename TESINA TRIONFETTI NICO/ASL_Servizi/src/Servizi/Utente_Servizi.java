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
@Path("Utente")

public class Utente_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM utenti;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateUtente/CF={id_cf}Username={id_username}&Email={id_email}&Password={id_password}&Cognome={id_cognome}&Nome={id_nome}&Cellulare={id_cellulare}&Admin={id_admin}&Ruolo={id_ruolo}&Stato={id_stato}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateUtente(@PathParam("id_cognome")String id_cognome,@PathParam("id_nome")String id_nome,@PathParam("id_username")String id_username,@PathParam("id_email")String id_email,@PathParam("id_cellulare")String id_cellulare,@PathParam("id_password")String id_password,@PathParam("id_stato")int id_stato,@PathParam("id_Ncf")int id_Ncf,@PathParam("id_ruolo")int id_ruolo,@PathParam("id_admin")int id_admin,@PathParam("id_Vcf")int id_Vcf) throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE utenti SET Cognome = \""+id_cognome+"\", Nome = \""+id_nome+"\", Username = \""+id_username+"\", Email = \""+id_email+"\", Cellulare = \""+id_cellulare+"\", Password = \""+id_password+"\", Stato = \""+id_stato+"\",Admin = \""+id_admin+"\",Ruolo = \""+id_ruolo+"\",CF = \""+id_Ncf+"\" WHERE CF = \""+id_Vcf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertUtente/cf={id_cf}&cognome={id_cognome}&nome={id_nome}&username={id_username}&email={id_email}&cellulare={id_cellulare}&password={id_password}&admin={id_admin}&stato={id_stato}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertUtente(@PathParam("id_cf")int id_cf,@PathParam("id_cognome")String id_cognome,@PathParam("id_nome")String id_nome,@PathParam("id_username")String id_username,@PathParam("id_email")String id_email,@PathParam("id_cellulare")String id_cellulare,@PathParam("id_password")String id_password,@PathParam("id_admin")int id_admin,@PathParam("id_ruolo")String id_ruolo,@PathParam("id_stato")int id_stato)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO utenti(CF, Cognome, Nome, Username, Email, Cellulare, Password, Admin, Ruolo, Stato) VALUES (\""+id_cf+"\", \""+id_cognome+"\", \""+id_nome+"\" , \""+id_username+"\", \""+id_email+"\" , \""+id_cellulare+"\", \""+id_password+"\", \""+id_admin+"\" , \""+id_ruolo+"\", \""+id_ruolo+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

	@Path("deleteUtente/id_={id_cf}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteUtente(@PathParam("id_cf")String id_cf)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM utenti  WHERE CF=\""+id_cf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
