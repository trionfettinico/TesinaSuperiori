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
@Path("Iscritto")

public class Iscritto_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM iscritto;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertIscritto/Stu_CF={id_stu_cf}&Cod_C={id_cod_c}&AnSc={id_ansc}&Valutazione={id_valutazione}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertIscritto(@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_cod_c")String id_cod_c,@PathParam("id_ansc")String id_ansc,@PathParam("id_valutazione")String id_valutazione)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO iscritto (Stu_CF, Cod_C, AnSc,Valutazione) VALUES (\""+id_stu_cf+"\",  \""+id_cod_c+"\", \""+id_ansc+"\",Valutazione=\""+id_valutazione+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteFrequenta/Stu_CF={id_stu_cf}&Cod_C={id_cod_c}&AnSc={id_ansc}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteInscritto(@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_cod_c")String id_cod_c,@PathParam("id_ansc")String id_ansc)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM iscritto WHERE Stu_CF = \""+id_stu_cf+"\" AND Cod_C = \""+id_cod_c+"\"AND AnSc = \""+id_ansc+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertIscritto/Stu_CF={id_Vstud_cf}&Cod_C={id_Vcod_c}&AnSc={id_Vansc}&Valutazione={id_valutazione}&Stu_CF={id_Nstud_cf}&Cod_C={id_Ncod_c}&AnSc={id_Nansc}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateIscritto(@PathParam("id_Vstu_cf")String id_Vstu_cf,@PathParam("id_Vcod_c")String id_Vcod_c,@PathParam("id_Vansc")String id_Vansc,@PathParam("id_valutazione")String id_valutazione,@PathParam("id_Nstu_cf")String id_Nstu_cf,@PathParam("id_Ncod_c")String id_Ncod_c,@PathParam("id_Nansc")String id_Nansc)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE iscritto SET Stu_CF=\""+id_Nstu_cf+"\",Cod_C=\""+id_Ncod_c+"\",Valutazione=\""+id_valutazione+"\" WHERE Stu_CF =\""+id_Vstu_cf+"\" AND Cod_C = \""+id_Vcod_c+"\" AND Cod_C = \""+id_Vansc+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
