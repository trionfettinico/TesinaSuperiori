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
@Path("Corso")

public class Corso_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="Select * FROM corsi;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteCorso/Cod_C={id_cod_c}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteCorso(@PathParam("id_cod_c")String id_cod_c)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM corsi WHERE corsi.Cod_C = \""+id_cod_c+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
		
	}
	
	
	@Path("updateCorso/NCod_C={id_NCod_c}&VCod_C={id_VCod_C}&Nome={id_nome}&Tipo={id_tipo}&Descrizione={id_descrizione}&Ore_tot={id_ore_tot}&Luogo={id_luogo}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateCorso(@PathParam("id_NCod_C")String id_NCod_C,@PathParam("id_VCod_C")String id_VCod_C,@PathParam("id_nome")String id_nome,@PathParam("id_tipo")String id_tipo,@PathParam("id_descrizione")String id_descrizione,@PathParam("id_ore_tot")String id_ore_tot,@PathParam("id_luogo")String id_luogo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE corsi SET Cod_C = \""+id_NCod_C+"\", Nome = \""+id_nome+"\" , Tipo = \""+id_tipo+"\", Descrizione = \""+id_descrizione+"\", Ore_tot = \""+id_ore_tot+"\",Luogo = \""+id_luogo+"\" WHERE corsi.Cod_C = \""+id_VCod_C+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertCorso/Cod_C={id_cod_c}&Nome={id_nome}&Tipo={id_tipo}&Descrizione={id_descrizione}&Ore_tot={id_ore_tot}&Luogo={id_luogo}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertCorso(@PathParam("id_cod_c")String id_cod_c,@PathParam("id_nome")String id_nome,@PathParam("id_tipo")String id_tipo,@PathParam("id_descrizione")String id_descrizione,@PathParam("id_ore_tot")String id_ore_tot,@PathParam("id_luogo")String id_luogo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO corsi(Cod_C, Nome, Tipo, Descrizione, Ore_tot, Luogo) VALUES (\""+id_cod_c+"\",\""+id_nome+"\",\""+id_tipo+"\",\""+id_descrizione+"\",\""+id_ore_tot+"\",\""+id_luogo+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	

}