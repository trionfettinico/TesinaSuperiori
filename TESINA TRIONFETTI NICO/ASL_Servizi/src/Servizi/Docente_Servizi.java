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
@Path("Docente")

public class Docente_Servizi {
	

	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM docenti;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertDocente/CF={id_cf}&Tutor={id_tutor}&Formatore={id_formatore}&Materia={id_materia}&Ente={id_ente}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertDocente(@PathParam("id_cf")String id_cf,@PathParam("id_congome")String id_cognome,@PathParam("id_nome")String id_nome,@PathParam("id_ente")String id_ente,@PathParam("id_email")String id_email,@PathParam("id_cellulare")String id_cellulare,@PathParam("id_password")String id_password,@PathParam("id_tutor")String id_tutor,@PathParam("id_formatore")String id_formatore,@PathParam("id_materia")String id_materia)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO docenti(CF, Tutor, Formatore, Materia, Ente) VALUES (\""+id_cf+"\",  \""+id_tutor+"\", \""+id_formatore+"\", \""+id_materia+"\",\""+id_ente+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
		
	}
	
	@Path("deleteDocente/CF={id_cf}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteDocente(@PathParam("id_cf")String id_cf)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM docenti WHERE CF = \""+id_cf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateDocente/NCF={id_Ncf}&VCF={id_Vcf}&Ente={id_ente}&Tutor={id_tutor}&Formatore={id_formatore}&Materia={id_materia}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateDocente(@PathParam("id_Ncf")String id_Ncf,@PathParam("id_tutor")String id_tutor,@PathParam("id_Vcf")String id_Vcf,@PathParam("id_ente")String id_ente,@PathParam("id_formatore")String id_formatore,@PathParam("id_materia")String id_materia)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE docenti SET CF=\""+id_Ncf+"\",Tutor=\""+id_tutor+"\",Formatore=\""+id_formatore+"\",Materia=\""+id_materia+"\",Ente=\""+id_ente+"\" WHERE CF =\""+id_Vcf+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
