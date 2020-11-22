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
@Path("Frequenta")

public class Frequenta_Servizi {
	
	@Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll()
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM frequenta;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("insertFrequenta/Stu_CF={id_stu_cf}&Cod_I={id_cod_i}&Ore_presenza={id_ore_presenza}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertFrequenta(@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_cod_i")String id_cod_i,@PathParam("id_ore_presenza")String id_ore_presenza)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO frequenta (Stu_CF, Cod_I, Ore_presenza) VALUES (\""+id_stu_cf+"\",  \""+id_cod_i+"\", \""+id_ore_presenza+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("deleteFrequenta/Stu_CF={id_stu_cf}&Cod_I={id_cod_i}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	
	public String deleteFrequenta(@PathParam("id_stu_cf")String id_stu_cf,@PathParam("id_cod_i")String id_cod_i)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="DELETE FROM frequenta WHERE Stu_CF = \""+id_stu_cf+"\" AND Cod_I = \""+id_cod_i+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("updateFrequenta/Stu_NCF={id_Nstu_cf}&Stu_VCF={id_Vstu_cf}&NCod_I={id_Ncod_i}&Vcod_I={id_Vcod_i}&Ore_presenza={id_ore_presenza}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateFrequenta(@PathParam("id_Nstu_cf")String id_Nstu_cf,@PathParam("id_Vstu_cf")String id_Vstu_cf,@PathParam("id_Ncod_i")String id_Ncod_i,@PathParam("id_Vcod_i")String id_Vcod_i,@PathParam("id_ore_presenza")String id_ore_presenza)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE frequenta SET Stu_CF=\""+id_Nstu_cf+"\",Cod_I=\""+id_Ncod_i+"\",Ore_presenza=\""+id_ore_presenza+"\" WHERE Stu_CF =\""+id_Vstu_cf+"\" AND Cod_I = \""+id_Vcod_i+"\";";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}

}
