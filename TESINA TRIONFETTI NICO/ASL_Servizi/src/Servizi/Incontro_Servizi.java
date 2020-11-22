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
@Path("Incontro")

public class Incontro_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM incontri;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertIncontro/Cod_I={id_cod_i}&Doc_CF={id_cod_cf}&Cod_C={id_cod_c}&Data_Incontro={id_data_incontro}&N_ore={id_n_ore}&N_inc={id_n_inc}&Luogo={id_luogo}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertIncontro(@PathParam("id_cod_i")String id_cod_i,@PathParam("id_doc_cf")String id_doc_cf,@PathParam("id_cod_c")String id_cod_c,@PathParam("id_data_incontro")String id_data_incontro,@PathParam("id_n_ore")String id_n_ore,@PathParam("id_n_inc")String id_n_inc,@PathParam("id_luogo")String id_luogo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO incontri (Cod_I, Doc_CF, Cod_C,Data_Incontro,N_ore,N_inc,Luogo) VALUES (\""+id_cod_i+"\",  \""+id_doc_cf+"\", \""+id_cod_c+"\", \""+id_data_incontro+"\", \""+id_n_ore+"\", \""+id_n_inc+"\", \""+id_luogo+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteFrequenta/Cod_I={id_cod_i}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteIncontro(@PathParam("id_cod_i")String id_cod_i)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM incontri WHERE Cod_I = \""+id_cod_i+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateIncontro/VCod_I={id_Vcod_i}&NCod_I={id_Ncod_i}&Doc_CF={id_cod_cf}&Cod_C={id_cod_c}&Data_Incontro={id_data_incontro}&N_ore={id_n_ore}&N_inc={id_n_inc}&Luogo={id_luogo}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateIncontro(@PathParam("id_Vcod_i")String id_Vcod_i,@PathParam("id_Ncod_i")String id_Ncod_i,@PathParam("id_doc_cf")String id_doc_cf,@PathParam("id_cod_i")String id_cod_c,@PathParam("id_data_incontro")String id_data_incontro,@PathParam("id_n_ore")String id_n_ore,@PathParam("id_n_inc")String id_n_inc,@PathParam("id_luogo")String id_luogo)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE incontri SET Cod_IF=\""+id_Ncod_i+"\",Doc_CF=\""+id_doc_cf+"\",Cod_C=\""+id_cod_c+"\",Data_Incontro=\""+id_data_incontro+"\",N_ore=\""+id_n_ore+"\",N_inc=\""+id_n_inc+"\",Luogo=\""+id_luogo+"\" WHERE Cod_I = \""+id_Vcod_i+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
