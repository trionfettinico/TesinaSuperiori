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
@Path("Tutor_aziendale")

public class Tutor_Aziendale_Servizi{

    @Path("getAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String getAll(@PathParam("id_cf")String id_cf)
	{
    	String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="SELECT * FROM tutor_aziendali ;";
		String json =  Main.DB.executeQueryTOJSON(sql,methodName,className);
		return json;
	}
    
    @Path("deleteTutor_aziendali/CF={id_cf}")
   	@DELETE
   	@Produces(MediaType.APPLICATION_JSON)
   	
   	public String deleteTutor_aziendali(@PathParam("id_cf")String id_cf)throws IOException
   	{
       	String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
   		String className = this.getClass().getName();
   		String sql="DELETE FROM tutor_aziendali WHERE CF = \""+id_cf+"\";";
   		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
   		return json;
   	}
    
	@Path("insertTutor_aziendali/CF={id_CF}&P_IVA={id_p_iva}&Reparto={id_reparto}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public String insertTutor_aziendali(@PathParam("id_cf")String id_cf,@PathParam("id_p_iva")String id_p_iva,@PathParam("id_reparto")String id_reparto)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="INSERT INTO tutor_aziendali(CF, P_IVA, Reparto) VALUES (\""+id_cf+"\", \""+id_p_iva+"\", \""+id_reparto+"\");";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
	
	@Path("UpdateTutor_aziendali/NCF={id_Ncf}&VCF={id_Vcf}&P_IVA={id_p_iva}&Reparto={id_reparto}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateTutor_Aziendale(@PathParam("id_Vcf")String id_Vcf,@PathParam("id_Ncf")String id_Ncf,@PathParam("id_p_iva")String id_p_iva,@PathParam("id_reparto")String id_reparto)throws IOException
	{
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String className = this.getClass().getName();
		String sql="UPDATE tutor_aziendale SET CF=\""+id_Ncf+"\",P_IVA=\""+id_p_iva+"\",Reparto=\""+id_reparto+"\" WHERE CF= {id_Vcf};";
		String json =  Main.DB.executeUpdateTOJSON(sql,methodName,className);
		return json;
	}
    
}